package com.example.auth;


import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LoginTest {
	@Rule
	public WireMockRule wireMockRuleAdmin = new WireMockRule(wireMockConfig().port(8081));

	@Rule
	public WireMockRule wireMockRuleUser = new WireMockRule(wireMockConfig().port(8082));

	@Autowired
	private MockMvc mockMvc;

	@Test
	@WithMockUser(roles = "ADMIN")
	public void AdminMicroserviceForAdminTestShouldOK() throws Exception {
		wireMockRuleAdmin.stubFor(WireMock.get(urlEqualTo("/foradmin"))
				.willReturn(aResponse()
				.withStatus(HttpStatus.OK.value())
				.withBody("You are in the ADMIN microservice!")));
		this.mockMvc.perform(get("/admin/foradmin"))
				.andExpect(status().isOk())
				.andDo(print());
	}

	@Test
	@WithMockUser(roles = "USER")
	public void AdminMicroserviceForUserTestShouldError403() throws Exception {
		this.mockMvc.perform(get("/admin/foradmin"))
				.andExpect(status().is4xxClientError())
				.andDo(print());
	}

	@Test
	@WithMockUser(roles = {"ADMIN","USER"})
	public void UserMicroserviceForAdminTestShouldOK() throws Exception {
		wireMockRuleUser.stubFor(WireMock.get(urlEqualTo("/foruser"))
				.willReturn(aResponse()
				.withStatus(HttpStatus.OK.value())
				.withBody("You are in the USER microservice!")));
		this.mockMvc.perform(get("/orders/foruser"))
				.andExpect(status().isOk())
				.andDo(print());
	}
}
