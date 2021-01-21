package com.lesamisdelescalade.dao.impl;

import com.lesamisdelescalade.dao.UtilisateurDao;
import com.lesamisdelescalade.model.Utilisateur;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Repository("utilisateurDao")
@Transactional
public class UtilisateurDaoImpl extends BaseDao<Utilisateur> implements UtilisateurDao {

    @Override
    public List<Utilisateur> search(Utilisateur criteria) {
        return new ArrayList<>();
    }

    @Override
    public Boolean isRegisteredUser(String username, String password) {
        this.initEntityManager();
        this.getTransaction().begin();
        Utilisateur user = (Utilisateur) this.getEntityManager().
                createQuery("FROM Utilisateur WHERE pseudo = :pseudo and motDePasse= :motDePasse")
                .setParameter("pseudo", username)
                .setParameter("motDePasse", password)
                .getSingleResult();
        this.getTransaction().commit();
        return user != null;
    }
}

