package com.lesamisdelescalade.dao;

import com.lesamisdelescalade.model.Commentaire;

import java.util.List;

public interface CommentaireDao {
    List<Commentaire> search(Commentaire criteria);
    Commentaire getById(Integer commentId);
	void deleteComment(Commentaire commentToDelete);
	void addComment(Commentaire commentaire);
	void updateComment(Commentaire commentaire);
}
