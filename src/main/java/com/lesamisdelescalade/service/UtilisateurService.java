package com.lesamisdelescalade.service;

import java.util.Map;

public interface UtilisateurService {
	Boolean registerUser(Map<String, String> userInfos);
	Boolean isRegisteredUser(String pseudo, String motDePasse);
}