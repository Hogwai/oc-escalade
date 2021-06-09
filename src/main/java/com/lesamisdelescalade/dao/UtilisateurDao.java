package com.lesamisdelescalade.dao;

import javax.persistence.EntityExistsException;

import com.lesamisdelescalade.model.Utilisateur;

public interface UtilisateurDao {
    
    /**
     * Check if a Utilisateur is registered in the database
     * @param userName
     * @param password
     * @return Utilisateur found
     */
    Utilisateur isRegisteredUser(String userName, String password);
    
    /**
     * Register a new Utilisateur
     * @param userToRegister
     * @return Utilisateur registered
     * @throws EntityExistsException
     */
    Utilisateur registerUser(Utilisateur userToRegister) throws EntityExistsException;
    
    /**
     * Get a Utilisateur by its id
     * @param userId
     * @return Utilisateur found
     */
    Utilisateur getById(Integer userId);
}
