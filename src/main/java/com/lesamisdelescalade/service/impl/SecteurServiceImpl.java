package com.lesamisdelescalade.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lesamisdelescalade.dao.SecteurDao;
import com.lesamisdelescalade.dao.SiteDao;
import com.lesamisdelescalade.model.Secteur;
import com.lesamisdelescalade.model.Site;
import com.lesamisdelescalade.service.SecteurService;


@Service("secteurService")
public class SecteurServiceImpl implements SecteurService {
	
	@Autowired
	private SecteurDao secteurDao;
	
	@Autowired
	private SiteDao siteDao;
	
	@Override
	public Secteur getById(Integer siteId) {
		return this.secteurDao.getById(siteId);
	}
	
	@Override
	public void addSecteur(String libelle, Integer siteId) {
		Site site = siteDao.getById(siteId);
		Secteur secteurToAdd = new Secteur();
		secteurToAdd.setSite(site);
		secteurToAdd.setLibelle(libelle);
		this.secteurDao.addSecteur(secteurToAdd);
	}

}
