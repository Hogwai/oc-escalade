package com.lesamisdelescalade.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lesamisdelescalade.dao.CotationDao;
import com.lesamisdelescalade.dao.SecteurDao;
import com.lesamisdelescalade.dao.VoieDao;
import com.lesamisdelescalade.model.Cotation;
import com.lesamisdelescalade.model.Secteur;
import com.lesamisdelescalade.model.Voie;
import com.lesamisdelescalade.service.VoieService;


@Service("voieService")
public class VoieServiceImpl implements VoieService {
	
	@Autowired
	private VoieDao voieDao;
	
	@Autowired
	private SecteurDao secteurDao;
	
	@Autowired
	private CotationDao cotationDao;
	
	@Override
	public Voie getById(Integer voieId) {
		return this.voieDao.getById(voieId);
	}
	
	@Override
	public void addVoie(Integer secteurId, Integer equipeeTag, Integer cotationId) {
		Secteur secteur = secteurDao.getById(secteurId);
		Cotation cotation = this.cotationDao.getById(cotationId);
		Voie voieToAdd = new Voie();
		voieToAdd.setSecteur(secteur);
		voieToAdd.setCotation(cotation);
		voieToAdd.setEquipeeYN(equipeeTag.byteValue());
		this.voieDao.addVoie(voieToAdd);
	}

}
