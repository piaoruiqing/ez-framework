package org.ez.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ez_demo_entity")
public class DemoEntity extends BasicEntity{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "c_index_code", length = 64)
	String indexCode;

	public String getIndexCode() {
		return indexCode;
	}
	public void setIndexCode(String indexCode) {
		this.indexCode = indexCode;
	}
	
}
