package com.example.demo.infra.impl;

import org.springframework.stereotype.Service;

import com.example.demo.infra.IEnterpriseServiceInfra;

@Service("enterpriseServiceInfraDB")
public class EnterpriseServiceInfraDBImpl implements IEnterpriseServiceInfra {

	@Override
	public String getInfo() {
		return "InfraDB";
	}

}
