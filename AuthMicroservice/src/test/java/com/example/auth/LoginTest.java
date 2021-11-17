package com.example.auth;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LoginTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@WithMockUser(roles = "ADMIN")
	public void roleADMINTest() throws Exception {
		this.mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				.andDo(print());
	}

	@Test
	@WithMockUser(roles = "USER")
	public void roleUSERTest() throws Exception {
		this.mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				.andDo(print());
	}

	@Test
	@WithMockUser(roles = "SOMEROLE")
	public void roleSOMEROLETest() throws Exception {
		this.mockMvc.perform(get("/"))
				.andExpect(status().is4xxClientError())
				.andDo(print());
	}


}
