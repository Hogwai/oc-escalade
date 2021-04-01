package com.lesamisdelescalade.dao;

import com.lesamisdelescalade.criteria.SearchSiteCriteria;
import com.lesamisdelescalade.model.Site;

import java.util.List;

public interface SiteDao {
    List<Site> getAllSiteInfos();
    Site getById(Integer siteId);
	void updateSite(Site site);
	List<Site> search(SearchSiteCriteria criteria);
}
