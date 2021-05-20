package com.example.demo.infra.impl;

import org.springframework.stereotype.Service;

import com.example.demo.infra.IEnterpriseServiceInfra;

@Service("enterpriseServiceInfraWS")
public class EnterpriseServiceInfraWSImpl implements IEnterpriseServiceInfra {

	@Override
	public String getInfo() {
		return "InfraWS";
	}
	
}
