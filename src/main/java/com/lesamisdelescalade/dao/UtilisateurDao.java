package com.lesamisdelescalade.dao;

import com.lesamisdelescalade.model.Utilisateur;

import java.util.List;

public interface UtilisateurDao {
    List<Utilisateur> search(Utilisateur criteria);
    Boolean isRegisteredUser(String userName, String password);
}
