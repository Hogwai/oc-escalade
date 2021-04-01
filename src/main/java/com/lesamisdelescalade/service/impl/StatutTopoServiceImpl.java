package com.lesamisdelescalade.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lesamisdelescalade.dao.StatutTopoDao;
import com.lesamisdelescalade.model.StatutTopo;
import com.lesamisdelescalade.service.StatutTopoService;


@Service("statutTopoService")
public class StatutTopoServiceImpl implements StatutTopoService {
	
	@Autowired
	private StatutTopoDao statutTopoDao;

	
	@Override
	public StatutTopo getById(Integer statutTopoId) {
		return this.statutTopoDao.getById(statutTopoId);
	}
}
