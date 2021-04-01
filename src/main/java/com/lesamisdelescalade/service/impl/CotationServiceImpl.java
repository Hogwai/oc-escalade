package com.lesamisdelescalade.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lesamisdelescalade.dao.CotationDao;
import com.lesamisdelescalade.model.Cotation;
import com.lesamisdelescalade.service.CotationService;


@Service("cotationService")
public class CotationServiceImpl implements CotationService {
	
	@Autowired
	private CotationDao cotationDao;

	@Override
	public List<Cotation> getAllCotationInfos() {
		return this.cotationDao.getAllCotationInfos();
	}

}
