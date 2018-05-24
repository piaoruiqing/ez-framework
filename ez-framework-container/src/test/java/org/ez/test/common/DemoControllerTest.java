package org.ez.test.common;

import org.ez.common.controller.DemoController;
import org.ez.test.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class DemoControllerTest extends BaseTest{
	
	@Autowired
	private DemoController demoController;

	@Test
	public void create() {
		demoController.create();
	}
}
