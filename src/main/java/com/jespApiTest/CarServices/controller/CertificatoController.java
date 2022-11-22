package com.jespApiTest.CarServices.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jespApiTest.CarServices.models.Certificato;
import com.jespApiTest.CarServices.services.impl.CertificatoServiceImple;

@RestController
public class CertificatoController{
	
	@Autowired
	private CertificatoServiceImple serviceCert;
	
	@GetMapping("certificato/all")
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Certificato> getListaCertificati() {
		return serviceCert.getListaCertificati();
	}
}
