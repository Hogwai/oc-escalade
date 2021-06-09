package com.lesamisdelescalade.dao.impl;

import com.lesamisdelescalade.dao.VoieDao;
import com.lesamisdelescalade.model.Voie;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository("voieDao")
@Transactional
public class VoieDaoImpl extends BaseDao<Voie> implements VoieDao {
    public VoieDaoImpl() {
        this.setmodelClass(Voie.class);
        this.initEntityManager();
    }
    
    @Override
    public void addVoie(Voie voie) {
    	this.create(voie);
    }
}
