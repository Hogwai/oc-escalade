package com.lesamisdelescalade.service;

import java.util.List;

import com.lesamisdelescalade.model.Topo;
import com.lesamisdelescalade.model.Utilisateur;

public interface TopoService {

	List<Topo> getToposByProprietaire(Utilisateur user);

	List<Topo> getAllTopoInfos();

	Topo getById(Integer topoId);

	void updateTopo(Integer topoId, Integer topoTag);

	void addTopo(String nom, String description, Integer topoTag, Utilisateur currentUser, Integer siteId);

}
