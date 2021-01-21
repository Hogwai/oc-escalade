package com.lesamisdelescalade.dao;

import com.lesamisdelescalade.model.Topo;

import java.util.List;

public interface TopoDao {
    List<Topo> search(Topo criteria);
}
