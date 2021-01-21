package com.lesamisdelescalade.dao.impl;

import com.lesamisdelescalade.dao.StatutTopoDao;
import com.lesamisdelescalade.model.StatutTopo;

import java.util.ArrayList;
import java.util.List;

public class StatutTopoDaoImpl extends BaseDao<StatutTopo> implements StatutTopoDao {
    public StatutTopoDaoImpl() {
        this.setmodelClass(StatutTopo.class);
    }

    @Override
    public List<StatutTopo> search(StatutTopo criteria) {
        return new ArrayList<>();
    }
}
