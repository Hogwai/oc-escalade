package com.lesamisdelescalade.dao.impl;

import com.lesamisdelescalade.dao.UtilisateurDao;
import com.lesamisdelescalade.model.Utilisateur;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.stream.Stream;


@Repository("utilisateurDao")
@Transactional
public class UtilisateurDaoImpl extends BaseDao<Utilisateur> implements UtilisateurDao {
	
	public UtilisateurDaoImpl() {
        this.setmodelClass(Utilisateur.class);
        this.initEntityManager();
    }

    @Override
    public Utilisateur isRegisteredUser(String username, String password) {
    	Utilisateur user;
		EntityTransaction tx = this.getTransaction();
		tx.begin();
        try {
			user = (Utilisateur) this.getEntityManager()
					.createQuery("FROM Utilisateur WHERE pseudo = :pseudo and motDePasse= :motDePasse")
					.setParameter("pseudo", username).setParameter("motDePasse", password).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		tx.commit();
		return user;
    }

	@Override
	public Utilisateur registerUser(Utilisateur userToRegister) throws EntityExistsException {
		Utilisateur userCheck = this.isRegisteredUser(userToRegister.getPseudo(), userToRegister.getMotDePasse());
		Stream<Utilisateur> users = this.getAll().stream()
				.filter(user -> (user.getEmail().equals(userToRegister.getEmail())
						|| user.getNumeroTel().equals(userToRegister.getNumeroTel())));
		if (userCheck != null || users.count() > 0) {
			throw new EntityExistsException();
		}
		return this.create(userToRegister);
	}
}

