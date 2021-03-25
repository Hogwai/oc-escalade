package com.lesamisdelescalade.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lesamisdelescalade.dao.SecteurDao;
import com.lesamisdelescalade.model.Secteur;
import com.lesamisdelescalade.service.SecteurService;


@Service("secteurService")
public class SecteurServiceImpl implements SecteurService {
	
	@Autowired
	private SecteurDao secteurDao;
	
	@Override
	public Secteur getById(Integer siteId) {
		return this.secteurDao.getById(siteId);
	}

}
