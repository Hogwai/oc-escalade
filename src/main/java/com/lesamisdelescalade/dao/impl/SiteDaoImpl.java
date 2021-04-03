package com.lesamisdelescalade.dao.impl;

import com.lesamisdelescalade.criteria.SearchSiteCriteria;
import com.lesamisdelescalade.dao.SiteDao;
import com.lesamisdelescalade.enums.SiteConsts;
import com.lesamisdelescalade.model.Secteur;
import com.lesamisdelescalade.model.Site;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
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
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, String> getAllVillePays() {
		Map<String, String> villePaysMap = new HashMap<>();
		Query q = this.em.createQuery("select distinct s.ville, s.pays from Site s");
		List<Object[]> results = q.getResultList();
		for (Object[] result : results) {
			villePaysMap.put((String) result[0], (String) result[1]);
		}
		return villePaysMap;
	}

    @Override
    public List<Site> search(SearchSiteCriteria criteria) {
    	CriteriaBuilder critBuilder = this.em.getCriteriaBuilder();
    	CriteriaQuery<Site> critQuery = critBuilder.createQuery(Site.class);
    	Root<Site> siteRoot = critQuery.from(Site.class);
    	List<Predicate> conditions = new ArrayList<>();
    	
    	critQuery.select(siteRoot);
    	
    	// Predicates
		if (criteria.getLibelle() != null) {
			conditions.add(critBuilder.like(siteRoot.<String>get(SiteConsts.LIBELLE), "%" + criteria.getLibelle() + "%"));
		}
		
		if (criteria.getHauteur() != null) {
			ParameterExpression<Float> hauteur = critBuilder.parameter(Float.class, SiteConsts.HAUTEUR);
			conditions.add(critBuilder.lessThanOrEqualTo(siteRoot.<Float> get(SiteConsts.HAUTEUR), hauteur));
		}
		
		if (criteria.getTagYN() != null) {
			ParameterExpression<Byte> tag = critBuilder.parameter(Byte.class, SiteConsts.TAG);
			conditions.add(critBuilder.equal(siteRoot.<Byte> get(SiteConsts.TAG), tag));
		}
		
		if (criteria.getVille() != null) {
			ParameterExpression<String> ville = critBuilder.parameter(String.class, SiteConsts.VILLE);
			conditions.add(critBuilder.equal(siteRoot.<String> get(SiteConsts.VILLE), ville));
		}
		
		if (criteria.getNbSecteurMax() != null) {
			//ParameterExpression<Integer> nbSecteur = critBuilder.parameter(Integer.class, SiteConsts.SECTEUR);
			ParameterExpression<Integer> nbSecteur = critBuilder.parameter(Integer.class, SiteConsts.SECTEURS);
			//conditions.add(critBuilder.lessThanOrEqualTo(siteRoot.<Integer> get(SiteConsts.SECTEUR), nbSecteur));
			conditions.add(critBuilder.lessThanOrEqualTo(critBuilder.size(siteRoot.<Collection<Secteur>> get(SiteConsts.SECTEURS)), nbSecteur));
		}
    	
		critQuery.where(conditions.toArray(new Predicate[] {}));
    	TypedQuery<Site> query = this.em.createQuery(critQuery);
    	
    	// Parameters
    	if (criteria.getHauteur() != null) {
    		query.setParameter(SiteConsts.HAUTEUR, criteria.getHauteur());
    	}
    	
    	if (criteria.getTagYN() != null) {
    		query.setParameter(SiteConsts.TAG, criteria.getTagYN().byteValue());
    	}
    	
    	if (criteria.getVille() != null) {
    		query.setParameter(SiteConsts.VILLE, criteria.getVille());
    	}
    	
    	if (criteria.getNbSecteurMax() != null) {
    		query.setParameter(SiteConsts.SECTEURS, criteria.getNbSecteurMax());
    	}
        return query.getResultList();
    }
}
