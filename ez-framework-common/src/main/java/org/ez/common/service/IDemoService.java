package org.ez.common.service;

import org.ez.common.entity.DemoEntity;

/**
 * demo service
 * @author Ruiqing.Piao
 *
 */
public interface IDemoService {
	
	DemoEntity save(DemoEntity entity);
	
	DemoEntity findById(Long id);

}
