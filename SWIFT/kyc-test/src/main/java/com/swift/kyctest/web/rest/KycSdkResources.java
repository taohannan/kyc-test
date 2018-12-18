package com.swift.kyctest.web.rest;

import com.swift.kyc.java_client.ApiClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.swift.kyc.java_client.auth.*;
import com.swift.kyc.java_client.api.ConsumptionApi;
import com.swift.kyc.java_client.model.*;

import java.util.Map;


@RestController
@RequestMapping("api/kyc/sdk")
public class KycSdkResources {
	
	
	  private final Logger log = LoggerFactory.getLogger(KycSdkResources.class);
	
	@PostMapping("/token")
	public ResponseEntity<String> authenticate(){
		
		OAuth auth = new OAuth();
		String token =auth.getAccessToken();
		log.info(token);
		return new ResponseEntity<String>(token, HttpStatus.OK);
		
	}
	
	@GetMapping("/myEntities")
	public ResponseEntity getMyEntities() throws Exception{
		ConsumptionApi consumptionApi  = new ConsumptionApi();
//		Authentication authentication = new ApiKeyAuth();
		ApiClient apiClient = new ApiClient();
        apiClient.addDefaultHeader("Content-Type", "application/x-www-form-urlencoded");
        apiClient.addDefaultHeader("Authorization", " Bearer yGAmT2hMAkjUOhxBZqRKKKlNuM6q");
//		apiClient.setAccessToken("eVZHaEtpVjV6MVpHZGFxRlhvWjhBaVNBOW41Q3JZNkI6cHl2SEVtR3JOcVJIQkhScA");
//		apiClient.setUsername("sandbox-id");
//		apiClient.setPassword("sandbox-key");
		apiClient.setAccessToken("tqzeFAW9Cl8xRLlV3Rt6G5CxYL22");
		consumptionApi.setApiClient(apiClient);
		EntityList entities =consumptionApi.getMyEntities();
		return new ResponseEntity(entities,HttpStatus.OK);
		
	}

}
