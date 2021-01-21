package com.lesamisdelescalade.dao.impl;

import com.lesamisdelescalade.dao.SiteDao;
import com.lesamisdelescalade.model.Site;

import java.util.ArrayList;
import java.util.List;

public class SiteDaoImpl extends BaseDao<Site> implements SiteDao {
    public SiteDaoImpl() {
        this.setmodelClass(Site.class);
    }

    @Override
    public List<Site> search(Site criteria) {
        return new ArrayList<>();
    }
}
