package com.jespApiTest.CarServices.services;

import java.util.List;

import com.jespApiTest.CarServices.exception.InternalServerErrorException;
import com.jespApiTest.CarServices.models.Auto;

public interface AutoServiceInt {
	Auto saveAuto(Auto auto)throws InternalServerErrorException;
	void deleteAuto(int id) throws InternalServerErrorException;
	//public Auto getAuto(int id);
	//public List<Auto> setAuto(Auto auto);
	List<Auto> getUserAuto();
	//private List<Auto> generateListaAuto();

}
