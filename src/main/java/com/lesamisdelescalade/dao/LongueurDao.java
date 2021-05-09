package com.lesamisdelescalade.dao;

import java.util.List;

import com.lesamisdelescalade.model.Longueur;

public interface LongueurDao {
    List<Longueur> search(Longueur criteria);

	void addLongueur(Longueur longueur);

	Longueur getById(Integer longueurId);
}
