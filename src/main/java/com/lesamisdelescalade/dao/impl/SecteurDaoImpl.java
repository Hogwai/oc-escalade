package com.lesamisdelescalade.dao.impl;

import com.lesamisdelescalade.dao.SecteurDao;
import com.lesamisdelescalade.model.Secteur;

import java.util.ArrayList;
import java.util.List;

public class SecteurDaoImpl extends BaseDao<Secteur> implements SecteurDao {

    public SecteurDaoImpl() {
        this.setmodelClass(Secteur.class);
    }

    @Override
    public List<Secteur> search(Secteur criteria) {
        return new ArrayList<>();
    }
}
