package org.ez.test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@WebAppConfiguration
@ContextConfiguration(locations = { "classpath*:spring/spring*.xml","classpath*:spring/dispatcher-basic-restful.xml" })
public class BaseTest extends AbstractTransactionalTestNGSpringContextTests{
	
	@BeforeClass
	public void beforeClass() {
		System.out.println(">>>>>>>>>>>>>>>>>>>>> BeforeClass <<<<<<<<<<<<<<<<<<<<");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println(">>>>>>>>>>>>>>>>>>>>> AfterClass <<<<<<<<<<<<<<<<<<<<");
	}

}
