package org.ez.common.service.impl;

import org.ez.common.dao.IDemoRepository;
import org.ez.common.entity.DemoEntity;
import org.ez.common.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements IDemoService{
	
	@Autowired
	IDemoRepository demoRepository;

	@Override
	public DemoEntity save(DemoEntity entity) {
		return demoRepository.save(entity);
	}

	@Override
	public DemoEntity findById(Long id) {
		return demoRepository.findById(id).orElse(null);
	}

}
