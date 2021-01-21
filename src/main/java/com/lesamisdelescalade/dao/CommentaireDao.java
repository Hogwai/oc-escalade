package com.lesamisdelescalade.dao;

import com.lesamisdelescalade.model.Commentaire;

import java.util.List;

public interface CommentaireDao {
    List<Commentaire> search(Commentaire criteria);
}
