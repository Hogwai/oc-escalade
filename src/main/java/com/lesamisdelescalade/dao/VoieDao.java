package com.lesamisdelescalade.dao;

import com.lesamisdelescalade.model.Voie;

public interface VoieDao {
	/**
	 * Get a Voie by its id
	 * @param voieId
	 * @return Voie
	 */
    Voie getById(Integer voieId);
    
    /**
     * Add a new Voie
     * @param voie
     */
	void addVoie(Voie voie);
}
