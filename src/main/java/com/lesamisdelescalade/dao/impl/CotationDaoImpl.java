package com.lesamisdelescalade.dao.impl;

import com.lesamisdelescalade.dao.CotationDao;
import com.lesamisdelescalade.model.Cotation;

import java.util.ArrayList;
import java.util.List;

public class CotationDaoImpl extends BaseDao<Cotation> implements CotationDao {
    public CotationDaoImpl() {
        this.setmodelClass(Cotation.class);
    }

    @Override
    public List<Cotation> search(Cotation criteria) {
        return new ArrayList<>();
    }
}
