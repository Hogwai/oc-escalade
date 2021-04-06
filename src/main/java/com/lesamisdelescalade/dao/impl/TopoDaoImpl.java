package com.lesamisdelescalade.dao.impl;

import com.lesamisdelescalade.dao.TopoDao;
import com.lesamisdelescalade.enums.TopoConsts;
import com.lesamisdelescalade.model.Topo;
import com.lesamisdelescalade.model.Utilisateur;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository("topoDao")
@Transactional
public class TopoDaoImpl extends BaseDao<Topo> implements TopoDao {
    public TopoDaoImpl() {
        this.setmodelClass(Topo.class);
        this.initEntityManager();
    }
    
    @Override
	public List<Topo> getAllTopoInfos() {
		return this.getAll();
	}

    //@Override
    public List<Topo> getToposByUtilisateur(Utilisateur user, String typeUser){
    	CriteriaBuilder critBuilder = em.getCriteriaBuilder();
    	CriteriaQuery<Topo> critQuery = critBuilder.createQuery(Topo.class);
    	Root<Topo> root = critQuery.from(Topo.class);
    	
    	critQuery.where(critBuilder.equal(root.get(typeUser), user));
    	TypedQuery<Topo> query = em.createQuery(critQuery); 
		return query.getResultList();
    }
    
    @Override
    public List<Topo> getToposByProprietaire(Utilisateur user){
		return this.getToposByUtilisateur(user, TopoConsts.PROPRIETAIRE);
    }
    
    public List<Topo> getToposByEmprunteur(Utilisateur user){
    	return this.getToposByUtilisateur(user, TopoConsts.EMPRUNTEUR);
    }
    
    @Override
    public List<Topo> getToposByEmprunteurStatut(Utilisateur user, Integer statut){
    	List<Topo> toposByEmprunteur = this.getToposByEmprunteur(user);
    	toposByEmprunteur.removeIf(topo -> topo.getStatutTopo().getId() != statut);
    	return toposByEmprunteur;
    }
    
    @Override
    public List<Topo> getToposByStatut(Integer statut){
    	List<Topo> topos = this.getAllTopoInfos();
    	topos.removeIf(topo -> topo.getStatutTopo().getId() != statut);
    	return topos;
    }
    
	@Override
    public void addTopo(Topo topo) {
		//this.initEntityManager();
    	this.create(topo);
    }
	
	@Override
    public void updateTopo(Topo topo) {
		//this.initEntityManager();
    	this.update(topo);
    }
}
