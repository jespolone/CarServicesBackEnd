package com.jespApiTest.CarServices.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jespApiTest.CarServices.exception.InternalServerErrorException;
import com.jespApiTest.CarServices.exception.NotFoundException;
import com.jespApiTest.CarServices.models.Certificato;
import com.jespApiTest.CarServices.repository.CertificatoRepository;
import com.jespApiTest.CarServices.services.CertificatoServiceInt;

@Service
public class CertificatoServiceImple implements CertificatoServiceInt {
	
	@Autowired
	private CertificatoRepository repository;
	
	public Iterable<Certificato> getListaCertificati() throws InternalServerErrorException{
		try {
			Iterable<Certificato> toRet = repository.findAll();
			if(!((List<Certificato>)toRet).isEmpty()) {
				return toRet;
			}
			else {
				throw new NotFoundException("Nessun certificato trovato!");
			}
		}
		catch(Exception e) {
			throw new InternalServerErrorException(e.getMessage());
		}
	}
}
