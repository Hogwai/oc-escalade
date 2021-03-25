package com.lesamisdelescalade.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lesamisdelescalade.dao.UtilisateurDao;
import com.lesamisdelescalade.model.Utilisateur;
import com.lesamisdelescalade.service.UtilisateurService;
import com.lesamisdelescalade.enums.UserInfoConsts;

@Service("utilisateurService")
public class UtilisateurServiceImpl implements UtilisateurService {
	
	@Autowired
	private UtilisateurDao utilisateurDao;
    
    @Override
	public Utilisateur registerUser(Map<String, String> userInfos) {
    	for(Map.Entry<String, String> entry : userInfos.entrySet()) {
    		if(entry.getValue() == null || entry.getValue().isEmpty()){
    			return null;
    		}
    	}

    	Utilisateur userToRegister = new Utilisateur();
    	userToRegister.setPseudo(userInfos.get(UserInfoConsts.PSEUDO));
    	userToRegister.setMotDePasse(userInfos.get(UserInfoConsts.MOTDEPASSE));
    	userToRegister.setNom(userInfos.get(UserInfoConsts.NOM));
    	userToRegister.setPrenom(userInfos.get(UserInfoConsts.PRENOM));
    	userToRegister.setNumeroTel(userInfos.get(UserInfoConsts.NUMTEL));
    	userToRegister.setEmail(userInfos.get(UserInfoConsts.EMAIL));
    	userToRegister.setAdresse(userInfos.get(UserInfoConsts.ADRESSE));
    	userToRegister.setCodePostal(userInfos.get(UserInfoConsts.CODEPOSTAL));
    	userToRegister.setMembreAssoYN(Integer.valueOf(userInfos.get(UserInfoConsts.MEMBREASSOYN)));
    	return utilisateurDao.registerUser(userToRegister);
    }
    
    @Override
	public Utilisateur isRegisteredUser(String pseudo, String motDePasse) {
    	return utilisateurDao.isRegisteredUser(pseudo, motDePasse);
    }
}
