package com.lesamisdelescalade.service;

public interface CommentaireService {
	void deleteCommentById(Integer commentId);
	void addComment(String contenu, Integer userId, Integer siteId);
	void updateComment(Integer commentId, String contenu);
}