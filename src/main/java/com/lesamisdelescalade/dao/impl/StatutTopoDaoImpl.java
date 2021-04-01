package com.lesamisdelescalade.dao.impl;

import com.lesamisdelescalade.dao.StatutTopoDao;
import com.lesamisdelescalade.model.StatutTopo;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository("statutTopoDao")
@Transactional
public class StatutTopoDaoImpl extends BaseDao<StatutTopo> implements StatutTopoDao {
    public StatutTopoDaoImpl() {
        this.setmodelClass(StatutTopo.class);
        this.initEntityManager();
    }
}
