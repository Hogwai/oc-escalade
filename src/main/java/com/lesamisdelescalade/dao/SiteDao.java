package com.lesamisdelescalade.dao;

import com.lesamisdelescalade.model.Site;

import java.util.List;

public interface SiteDao {
    List<Site> search(Site criteria);
    List<Site> getAllSiteInfos();
    Site getById(Integer siteId);
	void updateSite(Site site);
}
