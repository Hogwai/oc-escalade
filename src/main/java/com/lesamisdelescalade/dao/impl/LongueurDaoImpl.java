package com.lesamisdelescalade.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lesamisdelescalade.dao.LongueurDao;
import com.lesamisdelescalade.model.Longueur;

@Repository("longueurDao")
@Transactional
public class LongueurDaoImpl extends BaseDao<Longueur> implements LongueurDao {
    public LongueurDaoImpl() {
        this.setmodelClass(Longueur.class);
        this.initEntityManager();
    }

    @Override
    public List<Longueur> search(Longueur criteria) {
        return new ArrayList<>();
    }
    
    @Override
    public void addLongueur(Longueur longueur) {
    	this.create(longueur);
    }
}
