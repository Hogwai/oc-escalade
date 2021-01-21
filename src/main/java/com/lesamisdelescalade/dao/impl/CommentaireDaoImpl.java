package com.lesamisdelescalade.dao.impl;

import com.lesamisdelescalade.dao.CommentaireDao;
import com.lesamisdelescalade.model.Commentaire;

import java.util.ArrayList;
import java.util.List;

public class CommentaireDaoImpl extends BaseDao<Commentaire> implements CommentaireDao {
    public CommentaireDaoImpl() {
        this.setmodelClass(Commentaire.class);
    }

    @Override
    public List<Commentaire> search(Commentaire criteria) {
        return new ArrayList<>();
    }
}
