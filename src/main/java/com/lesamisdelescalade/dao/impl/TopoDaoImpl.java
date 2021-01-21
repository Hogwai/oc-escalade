package com.lesamisdelescalade.dao.impl;

import com.lesamisdelescalade.dao.TopoDao;
import com.lesamisdelescalade.model.Topo;

import java.util.ArrayList;
import java.util.List;

public class TopoDaoImpl extends BaseDao<Topo> implements TopoDao {
    public TopoDaoImpl() {
        this.setmodelClass(Topo.class);
    }

    @Override
    public List<Topo> search(Topo criteria) {
        return new ArrayList<>();
    }
}
