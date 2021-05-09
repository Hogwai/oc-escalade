package com.lesamisdelescalade.service;

import com.lesamisdelescalade.model.Voie;

public interface VoieService {
	Voie getById(Integer voieId);

	void addVoie(Integer secteurId, Integer equipeeTag, Integer cotationId);
}