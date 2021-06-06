package com.lesamisdelescalade.service;

import java.util.Map;

import javax.persistence.EntityExistsException;

import com.lesamisdelescalade.model.Utilisateur;

public interface UtilisateurService {
	Utilisateur registerUser(Map<String, String> userInfos) throws EntityExistsException;
	Utilisateur isRegisteredUser(String pseudo, String motDePasse);
}