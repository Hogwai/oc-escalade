package com.lesamisdelescalade.dao;

import com.lesamisdelescalade.model.Utilisateur;

import java.util.List;

public interface UtilisateurDao {
    List<Utilisateur> search(Utilisateur criteria);
    Utilisateur isRegisteredUser(String userName, String password);
    Utilisateur registerUser(Utilisateur userToRegister);
    Utilisateur getById(Integer userId);
}
