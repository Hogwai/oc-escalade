package com.lesamisdelescalade.dao.impl;

import com.lesamisdelescalade.dao.CotationDao;
import com.lesamisdelescalade.model.Cotation;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository("cotationDao")
@Transactional
public class CotationDaoImpl extends BaseDao<Cotation> implements CotationDao {
    public CotationDaoImpl() {
        this.setmodelClass(Cotation.class);
        this.initEntityManager();
    }

    @Override
	public List<Cotation> getAllCotationInfos() {
		return this.getAll();
	}

	@Override
    public List<Cotation> search(Cotation criteria) {
        return new ArrayList<>();
    }
    
    
}
