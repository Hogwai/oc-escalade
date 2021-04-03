package com.lesamisdelescalade.service;

import java.util.List;
import java.util.Map;

import com.lesamisdelescalade.criteria.SearchSiteCriteria;
import com.lesamisdelescalade.model.Site;

public interface SiteService {
	List<Site> getAllSiteInfos();
	Map<Integer, Site> getAllSiteMap();
	Site getById(Integer siteId);
	void updateSiteTag(Integer siteId, Integer tag);
	List<Site> search(SearchSiteCriteria criteria);
	Map<String, String> getAllVillePays();
}