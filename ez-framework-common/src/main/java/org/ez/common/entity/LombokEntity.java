package org.ez.common.entity;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LombokEntity extends BasicEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "c_index_code", length = 64)
	String indexCode;

}
