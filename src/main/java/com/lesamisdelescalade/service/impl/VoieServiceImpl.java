package com.lesamisdelescalade.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lesamisdelescalade.dao.VoieDao;
import com.lesamisdelescalade.model.Voie;
import com.lesamisdelescalade.service.VoieService;


@Service("voieService")
public class VoieServiceImpl implements VoieService {
	
	@Autowired
	private VoieDao voieDao;
	
	@Override
	public Voie getById(Integer voieId) {
		return this.voieDao.getById(voieId);
	}

}
