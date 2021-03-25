package com.lesamisdelescalade.dao.impl;

import com.lesamisdelescalade.dao.CommentaireDao;
import com.lesamisdelescalade.model.Commentaire;
import com.lesamisdelescalade.model.Site;
import com.lesamisdelescalade.model.Utilisateur;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository("commentaireDao")
@Transactional
public class CommentaireDaoImpl extends BaseDao<Commentaire> implements CommentaireDao {
    public CommentaireDaoImpl() {
        this.setmodelClass(Commentaire.class);
    }

    @Override
    public List<Commentaire> search(Commentaire criteria) {
        return new ArrayList<>();
    }
    
    @Override
    public void deleteComment(Commentaire commentToDelete) {
    	this.initEntityManager();
    	this.delete(commentToDelete);
    }
    
	@Override
    public void addComment(Commentaire commentaire) {
		this.initEntityManager();
    	this.create(commentaire);
    }
	
	@Override
    public void updateComment(Commentaire commentaire) {
		this.initEntityManager();
    	this.update(commentaire);
    }
}
