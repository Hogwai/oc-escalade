package com.lesamisdelescalade.dao;

import com.lesamisdelescalade.model.Topo;
import com.lesamisdelescalade.model.Utilisateur;

import java.util.List;

public interface TopoDao {
	List<Topo> getAllTopoInfos();

	List<Topo> getToposByProprietaire(Utilisateur user);

	void addTopo(Topo topo);

	void updateTopo(Topo topo);

	Topo getById(Integer topoId);

	List<Topo> getToposByEmprunteurStatut(Utilisateur user, Integer statut);

	List<Topo> getToposByStatut(Integer statut);

	List<Topo> getToposByProprietaireStatut(Utilisateur user, Integer statut);
}
