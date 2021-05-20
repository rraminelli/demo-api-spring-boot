package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.helper.Response;
import com.example.demo.infra.IEnterpriseServiceInfra;

@RestController
@RequestMapping("/api/enterprise")
@CrossOrigin(origins = "*")
public class EnterpriseInfoController {

	@Autowired
	@Qualifier("enterpriseServiceInfra")
	private IEnterpriseServiceInfra enterpriseServiceInfra;
	
	@GetMapping
	public ResponseEntity<Response<String>> get() {
		Response<String> response = new Response<String>();
		response.setData(enterpriseServiceInfra.getInfo());		
		return ResponseEntity.ok(response);
	}
	
}
