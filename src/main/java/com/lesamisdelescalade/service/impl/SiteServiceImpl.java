package com.lesamisdelescalade.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lesamisdelescalade.dao.SiteDao;
import com.lesamisdelescalade.model.Site;
import com.lesamisdelescalade.service.SiteService;


@Service("siteService")
public class SiteServiceImpl implements SiteService {
	
	@Autowired
	private SiteDao siteDao;

	@Override
	public List<Site> getAllSiteInfos() {
		return this.siteDao.getAllSiteInfos();
	}
	
	@Override
	public Map<Integer, Site> getAllSiteMap(){
		HashMap<Integer, Site> siteMap = new HashMap<>();
		for(Site site : this.siteDao.getAllSiteInfos()) {
			siteMap.put(site.getId(), site);
		}
		return siteMap;
	}
	
	@Override
	public Site getById(Integer siteId) {
		return this.siteDao.getById(siteId);
	}
	
	@Override
	public void updateSiteTag(Integer siteId, Integer tag) {
		Site siteToUpdate = siteDao.getById(siteId);
		siteToUpdate.setTagYN(tag.byteValue());
		this.siteDao.updateSite(siteToUpdate);
	}

}
