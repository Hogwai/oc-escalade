package com.lesamisdelescalade.dao;

import com.lesamisdelescalade.model.Site;

import java.util.List;

public interface SiteDao {
    List<Site> search(Site criteria);
}
