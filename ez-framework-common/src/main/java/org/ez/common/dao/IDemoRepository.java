package org.ez.common.dao;

import org.ez.common.entity.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDemoRepository extends JpaRepository<DemoEntity, Long> {

}
