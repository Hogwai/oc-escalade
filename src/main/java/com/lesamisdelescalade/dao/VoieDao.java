package com.lesamisdelescalade.dao;

import com.lesamisdelescalade.model.Voie;

import java.util.List;

public interface VoieDao {
    List<Voie> search(Voie criteria);
    Voie getById(Integer voieId);
}
