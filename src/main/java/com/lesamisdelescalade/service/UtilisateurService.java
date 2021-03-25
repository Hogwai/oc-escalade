package com.lesamisdelescalade.service;

import java.util.Map;

import com.lesamisdelescalade.model.Utilisateur;

public interface UtilisateurService {
	Utilisateur registerUser(Map<String, String> userInfos);
	Utilisateur isRegisteredUser(String pseudo, String motDePasse);
}