package com.swift.kyctest.web.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.swift.kyctest.KycTestApp;
import com.swift.kyctest.web.rest.errors.ExceptionTranslator;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KycTestApp.class)
public class KycSdkResourcesIntTest {

	@Autowired
	private ExceptionTranslator exceptionTranslator;
	private MockMvc mockMvc;

	@Before
	public void setup() {
		KycSdkResources kycSdkResources = new KycSdkResources();
		this.mockMvc = MockMvcBuilders.standaloneSetup(kycSdkResources).setControllerAdvice(exceptionTranslator)
				.build();
	}
	
	@Test
	public void testAuthentication() throws Exception{
		mockMvc.perform(post("/kyc/sdk/token")).andExpect(status().isOk());
				
	}
    @Test
	public void testMyEntities () throws Exception {
        mockMvc.perform(get("/kyc/sdk/myEntities")).andExpect(status().isOk());

    }
}
