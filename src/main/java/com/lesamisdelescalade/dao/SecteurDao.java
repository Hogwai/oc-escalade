package com.lesamisdelescalade.dao;

import com.lesamisdelescalade.model.Secteur;

import java.util.List;

public interface SecteurDao {
    List<Secteur> search(Secteur criteria);
    Secteur getById(Integer secteurId);
}
