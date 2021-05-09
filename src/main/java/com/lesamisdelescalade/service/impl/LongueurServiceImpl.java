package com.lesamisdelescalade.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lesamisdelescalade.dao.CotationDao;
import com.lesamisdelescalade.dao.LongueurDao;
import com.lesamisdelescalade.dao.VoieDao;
import com.lesamisdelescalade.model.Cotation;
import com.lesamisdelescalade.model.Longueur;
import com.lesamisdelescalade.model.Voie;
import com.lesamisdelescalade.service.LongueurService;


@Service("longueurService")
public class LongueurServiceImpl implements LongueurService {
	
	@Autowired
	private VoieDao voieDao;
	
	@Autowired
	private CotationDao cotationDao;
	
	@Autowired
	private LongueurDao longueurDao;
	
	@Override
	public Longueur getById(Integer longueurId) {
		return this.longueurDao.getById(longueurId);
	}
	
	@Override
	public void addLongueur(Integer voieId, Integer relaiTag, Integer cotationId) {
		Voie voie = voieDao.getById(voieId);
		Cotation cotation = this.cotationDao.getById(cotationId);
		Longueur longueurToAdd = new Longueur();
		longueurToAdd.setVoie(voie);
		longueurToAdd.setCotation(cotation);
		longueurToAdd.setRelaiYN(relaiTag.byteValue());
		this.longueurDao.addLongueur(longueurToAdd);
	}

}
