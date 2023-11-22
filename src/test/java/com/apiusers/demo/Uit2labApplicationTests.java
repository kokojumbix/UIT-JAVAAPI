package com.apiusers.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Uit2labApplicationTests {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MainController controller;


	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void controllerAccess() throws Exception {
		assertThat(controller).isNotNull();
	}

	@Test
	void contextLoads()
		throws Exception {
			assertThat( this.restTemplate.getForObject("http://localhost:" + port + "/user/", String.class).toString().contains("localhorse.space")).isTrue() ;

	}




}
