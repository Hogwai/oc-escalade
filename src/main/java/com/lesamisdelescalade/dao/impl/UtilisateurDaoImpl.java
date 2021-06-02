package com.lesamisdelescalade.dao.impl;

import com.lesamisdelescalade.dao.UtilisateurDao;
import com.lesamisdelescalade.model.Utilisateur;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Repository("utilisateurDao")
@Transactional
public class UtilisateurDaoImpl extends BaseDao<Utilisateur> implements UtilisateurDao {
	
	public UtilisateurDaoImpl() {
        this.setmodelClass(Utilisateur.class);
    }
	
    @Override
    public List<Utilisateur> search(Utilisateur criteria) {
        return new ArrayList<>();
    }

    @Override
    public Utilisateur isRegisteredUser(String username, String password) {
    	Utilisateur user;
        this.initEntityManager();
        this.getTransaction().begin();
        try {
			user = (Utilisateur) this.getEntityManager()
					.createQuery("FROM Utilisateur WHERE pseudo = :pseudo and motDePasse= :motDePasse")
					.setParameter("pseudo", username).setParameter("motDePasse", password).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
        this.getTransaction().commit();
		return user;
    }

	@Override
	public Utilisateur registerUser(Utilisateur userToRegister) throws EntityExistsException {
		this.initEntityManager();
		return this.create(userToRegister);
	}
}

