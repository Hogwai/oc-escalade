package com.lesamisdelescalade.dao;

import com.lesamisdelescalade.model.StatutTopo;

import java.util.List;

public interface StatutTopoDao {
    List<StatutTopo> search(StatutTopo criteria);
}
