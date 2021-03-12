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
	public Boolean registerUser(Map<String, String> userInfos) {
    	Boolean registerOk = true;
    	for(Map.Entry<String, String> entry : userInfos.entrySet()) {
    		if(entry.getValue() == null || entry.getValue().isEmpty()){
    			registerOk = false;
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
    	userToRegister.setMembreAssoYN(1);
    	utilisateurDao.registerUser(userToRegister);
    	return registerOk;
    }
    
    @Override
	public Boolean isRegisteredUser(String pseudo, String motDePasse) {
        if (pseudo != null && !pseudo.isEmpty() &&
                (motDePasse != null && !motDePasse.isEmpty())) {
        	return utilisateurDao.isRegisteredUser(pseudo, motDePasse);
        } else {
        	return false;
        }
    }
}
