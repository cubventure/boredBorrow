package com.gamerental.boredborrow;

import static org.assertj.core.api.Assertions.assertThat; //Manually imported

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gamerental.boredborrow.web.GameController;

@RunWith(SpringRunner.class) // JUnit is told to run using Spring's testing support
@SpringBootTest // annotation for regular tests
public class BoredborrowSmokeTest {
	
	@Autowired
	private GameController controller;
	
	@Test //defines the test method
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
