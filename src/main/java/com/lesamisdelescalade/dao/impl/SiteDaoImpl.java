package com.lesamisdelescalade.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lesamisdelescalade.consts.SiteConsts;
import com.lesamisdelescalade.criteria.SearchSiteCriteria;
import com.lesamisdelescalade.dao.SiteDao;
import com.lesamisdelescalade.model.Secteur;
import com.lesamisdelescalade.model.Site;

@Repository("siteDao")
@Transactional
public class SiteDaoImpl extends BaseDao<Site> implements SiteDao {
    public SiteDaoImpl() {
        this.setmodelClass(Site.class);
        this.initEntityManager();
    }
    
	@Override
	public List<Site> getAllSiteInfos() {
		return this.getAll();
	}
	
	@Override
    public void updateSite(Site site) {
    	this.update(site);
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, String> getAllVillePays() {
		Map<String, String> villePaysMap = new HashMap<>();
		List<Object[]> results = this.em.createQuery("select distinct s.ville, s.pays from Site s").getResultList();
		results.forEach(result -> villePaysMap.put((String) result[0], (String) result[1]));
		return villePaysMap;
	}
	

    @Override
    public List<Site> search(SearchSiteCriteria criteria) {
    	CriteriaBuilder critBuilder = this.em.getCriteriaBuilder();
    	CriteriaQuery<Site> critQuerySite = critBuilder.createQuery(Site.class);
    	Root<Site> siteRoot = critQuerySite.from(Site.class);
    	List<Predicate> conditions = new ArrayList<>();
    	
    	critQuerySite.select(siteRoot).distinct(true);
    	
		// Predicates
		if (criteria.getLibelle() != null) {
			conditions.add(critBuilder.like(siteRoot.<String>get(SiteConsts.LIBELLE), "%" + criteria.getLibelle() + "%"));
		}

		if (criteria.getHauteur() != null) {
			ParameterExpression<Float> hauteur = critBuilder.parameter(Float.class, SiteConsts.HAUTEUR);
			conditions.add(critBuilder.lessThanOrEqualTo(siteRoot.<Float>get(SiteConsts.HAUTEUR), hauteur));
		}

		if (criteria.getTagYN() != null) {
			ParameterExpression<Byte> tag = critBuilder.parameter(Byte.class, SiteConsts.TAG_YN);
			conditions.add(critBuilder.equal(siteRoot.<Byte>get(SiteConsts.TAG_YN), tag));
		}

		if (criteria.getVille() != null) {
			ParameterExpression<String> ville = critBuilder.parameter(String.class, SiteConsts.VILLE);
			conditions.add(critBuilder.equal(siteRoot.<String>get(SiteConsts.VILLE), ville));
		}

		if (criteria.getNbSecteurMin() != null) {
			ParameterExpression<Integer> nbSecteur = critBuilder.parameter(Integer.class, SiteConsts.SECTEURS);
			conditions.add(critBuilder.greaterThanOrEqualTo(
					critBuilder.size(siteRoot.<Collection<Secteur>>get(SiteConsts.SECTEURS)), nbSecteur));
		}

		// Query
		critQuerySite.where(conditions.toArray(new Predicate[] {}));
    	TypedQuery<Site> query = this.em.createQuery(critQuerySite);
    	
    	// Parameters
    	if (criteria.getHauteur() != null) {
    		query.setParameter(SiteConsts.HAUTEUR, criteria.getHauteur());
    	}
    	
    	if (criteria.getTagYN() != null) {
    		query.setParameter(SiteConsts.TAG_YN, criteria.getTagYN().byteValue());
    	}
    	
    	if (criteria.getVille() != null) {
    		query.setParameter(SiteConsts.VILLE, criteria.getVille());
    	}
    	
    	if (criteria.getNbSecteurMin() != null) {
    		query.setParameter(SiteConsts.SECTEURS, criteria.getNbSecteurMin());
    	}
        return query.getResultList();
    }
}
