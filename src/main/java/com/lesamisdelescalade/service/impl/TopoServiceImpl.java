package com.lesamisdelescalade.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lesamisdelescalade.dao.SiteDao;
import com.lesamisdelescalade.dao.StatutTopoDao;
import com.lesamisdelescalade.dao.TopoDao;
import com.lesamisdelescalade.model.Site;
import com.lesamisdelescalade.model.StatutTopo;
import com.lesamisdelescalade.model.Topo;
import com.lesamisdelescalade.model.Utilisateur;
import com.lesamisdelescalade.service.TopoService;


@Service("topoService")
public class TopoServiceImpl implements TopoService {
	
	@Autowired
	private TopoDao topoDao;
	
	@Autowired
	private StatutTopoDao statutTopoDao;
	
	@Autowired
	private SiteDao siteDao;

	@Override
	public List<Topo> getToposByProprietaire(Utilisateur user){
		return this.topoDao.getToposByProprietaire(user);
	}
	
	@Override
	public List<Topo> getAllTopoInfos(){
		return this.topoDao.getAllTopoInfos();
	}
	
	@Override
	public void updateTopo(Integer topoId, Integer statutTopoTag) {
		Topo topoToUpdate = this.topoDao.getById(topoId);
		StatutTopo statutTopo = this.statutTopoDao.getById(statutTopoTag);
		topoToUpdate.setStatutTopo(statutTopo);
		this.topoDao.updateTopo(topoToUpdate);
	}
	
	@Override
	public Topo getById(Integer topoId) {
		return this.topoDao.getById(topoId);
	}

	@Override
	public void addTopo(String nom, String description, Integer statutTopoTag, Utilisateur currentUser, Integer siteId) {
		StatutTopo statutTopo = this.statutTopoDao.getById(statutTopoTag);
		Site site = this.siteDao.getById(siteId);
		
		Topo topoToAdd = new Topo();
		topoToAdd.setNom(nom);
		topoToAdd.setDescription(description);
		topoToAdd.setStatutTopo(statutTopo);
		topoToAdd.setProprietaire(currentUser);
		topoToAdd.setSite(site);
		topoToAdd.setDateParution(new Date(System.currentTimeMillis()));
		this.topoDao.addTopo(topoToAdd);
	}
}
