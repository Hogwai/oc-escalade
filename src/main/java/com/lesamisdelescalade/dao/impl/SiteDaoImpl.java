package com.lesamisdelescalade.dao.impl;

import com.lesamisdelescalade.criteria.SearchSiteCriteria;
import com.lesamisdelescalade.dao.SiteDao;
import com.lesamisdelescalade.enums.SiteConsts;
import com.lesamisdelescalade.model.Site;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;


import org.springframework.stereotype.Repository;

@Repository("siteDao")
@Transactional
public class SiteDaoImpl extends BaseDao<Site> implements SiteDao {
    public SiteDaoImpl() {
        this.setmodelClass(Site.class);
        this.initEntityManager();
    }
    
	@Override
	public List<Site> getAllSiteInfos() {
		//this.initEntityManager();
		return this.getAll();
	}
	
	@Override
    public void updateSite(Site site) {
		//this.initEntityManager();
    	this.update(site);
    }

    @Override
    public List<Site> search(SearchSiteCriteria criteria) {
    	CriteriaBuilder critBuilder = this.em.getCriteriaBuilder();
    	CriteriaQuery<Site> critQuery = critBuilder.createQuery(Site.class);
    	Root<Site> root = critQuery.from(Site.class);
    	List<Predicate> conditions = new ArrayList<>();
    	
    	critQuery.select(root);
    	
		if (criteria.getLibelle() != null) {
			conditions.add(critBuilder.like(root.<String>get(SiteConsts.LIBELLE), "%" + criteria.getLibelle() + "%"));
		}
    	
		critQuery.where(conditions.toArray(new Predicate[] {}));
    	TypedQuery<Site> query = this.em.createQuery(critQuery);
    	//query.setParameter(SiteConsts.LIBELLE, criteria.getLibelle());
        return query.getResultList();
    }
}
