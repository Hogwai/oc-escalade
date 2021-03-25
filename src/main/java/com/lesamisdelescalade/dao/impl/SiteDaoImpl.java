package com.lesamisdelescalade.dao.impl;

import com.lesamisdelescalade.dao.SiteDao;
import com.lesamisdelescalade.model.Commentaire;
import com.lesamisdelescalade.model.Site;

import java.util.ArrayList;
import java.util.List;

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
    public List<Site> search(Site criteria) {
        return new ArrayList<>();
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
}
