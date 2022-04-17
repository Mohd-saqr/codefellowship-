package com.codefellowship.codefellowship;

import com.codefellowship.codefellowship.Controller.AppController;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class CodefellowshipApplicationTests {

	private MockMvc mockMvc;
	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webapplicationContext).build();
	}
	@Autowired
	AppController appController;
	@Autowired
	private WebApplicationContext webapplicationContext;

	@Test
	void contextLoads() {
	}
	@Test
	void testLoginPage() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/login"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("text/html;charset=UTF-8"))
				.andExpect(view().name("loginPage"))
				.andExpect(content().string(Matchers.containsString("Login")));

	}
	@Test
	void testSignUpPage() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/signUp"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("text/html;charset=UTF-8"))
				.andExpect(view().name("signUpPage"))
				.andExpect(content().string(Matchers.containsString("Sign Up")));

	}
	@Test
	void testSplashPage() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("text/html;charset=UTF-8"))
				.andExpect(view().name("Home"))
				.andExpect(content().string(Matchers.containsString("Code Fellow Ship")));

	}
}
