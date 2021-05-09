package com.lesamisdelescalade.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lesamisdelescalade.dao.SecteurDao;
import com.lesamisdelescalade.model.Secteur;

@Repository("secteurDao")
@Transactional
public class SecteurDaoImpl extends BaseDao<Secteur> implements SecteurDao {

    public SecteurDaoImpl() {
        this.setmodelClass(Secteur.class);
        this.initEntityManager();
    }

    @Override
    public List<Secteur> search(Secteur criteria) {
        return new ArrayList<>();
    }
    
    @Override
    public void addSecteur(Secteur secteur) {
    	this.create(secteur);
    }
}
