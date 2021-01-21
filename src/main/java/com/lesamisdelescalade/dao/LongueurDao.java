package com.lesamisdelescalade.dao;

import com.lesamisdelescalade.model.Longueur;

import java.util.List;

public interface LongueurDao {
    List<Longueur> search(Longueur criteria);
}
