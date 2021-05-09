package com.lesamisdelescalade.service;

import com.lesamisdelescalade.model.Secteur;

public interface SecteurService {
	Secteur getById(Integer secteurId);

	void addSecteur(String libelle, Integer siteId);
}