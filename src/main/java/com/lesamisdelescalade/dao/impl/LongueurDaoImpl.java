package com.lesamisdelescalade.dao.impl;

import com.lesamisdelescalade.dao.LongueurDao;
import com.lesamisdelescalade.model.Longueur;

import java.util.ArrayList;
import java.util.List;

public class LongueurDaoImpl extends BaseDao<Longueur> implements LongueurDao {
    public LongueurDaoImpl() {
        this.setmodelClass(Longueur.class);
    }

    @Override
    public List<Longueur> search(Longueur criteria) {
        return new ArrayList<>();
    }
}
