package com.lesamisdelescalade.service;

import com.lesamisdelescalade.model.Longueur;

public interface LongueurService {
	Longueur getById(Integer longueurId);
	void addLongueur(Integer voieId, Integer relaiTag, Integer cotationId);
}
