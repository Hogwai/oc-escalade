package com.lesamisdelescalade.service.impl;

import java.util.List;
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
 

}
