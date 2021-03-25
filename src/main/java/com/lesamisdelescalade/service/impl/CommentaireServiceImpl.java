package com.lesamisdelescalade.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lesamisdelescalade.dao.CommentaireDao;
import com.lesamisdelescalade.dao.SiteDao;
import com.lesamisdelescalade.dao.UtilisateurDao;
import com.lesamisdelescalade.model.Commentaire;
import com.lesamisdelescalade.model.Site;
import com.lesamisdelescalade.model.Utilisateur;
import com.lesamisdelescalade.service.CommentaireService;


@Service("commentaireService")
public class CommentaireServiceImpl implements CommentaireService {
	
	@Autowired
	private CommentaireDao commentaireDao;
	
	@Autowired
	private UtilisateurDao utilisateurDao;
	
	@Autowired
	private SiteDao siteDao;

	@Override
	public void deleteCommentById(Integer commentId) {
		Commentaire commentToDelete = this.commentaireDao.getById(commentId);
		this.commentaireDao.deleteComment(commentToDelete);
	}

	
	@Override
	public void addComment(String contenu, Integer userId, Integer siteId) {
		Utilisateur user = this.utilisateurDao.getById(userId);
		Site site = this.siteDao.getById(siteId);
		Commentaire commentToAdd = new Commentaire();
		commentToAdd.setContenu(contenu);
		commentToAdd.setUtilisateur(user);
		commentToAdd.setSite(site);
		this.commentaireDao.addComment(commentToAdd);
	}
	
	@Override
	public void updateComment(Integer commentId, String contenu) {
		Commentaire commentToUpdate = this.commentaireDao.getById(commentId);
		commentToUpdate.setContenu(contenu);
		this.commentaireDao.updateComment(commentToUpdate);
	}

}
