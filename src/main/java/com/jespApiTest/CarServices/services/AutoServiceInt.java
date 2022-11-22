package com.jespApiTest.CarServices.services;

import java.util.List;

import com.jespApiTest.CarServices.exception.InternalServerErrorException;
import com.jespApiTest.CarServices.models.Auto;

public interface AutoServiceInt {
	public Auto getAutoVuota();
	public void saveAuto(Auto auto)throws InternalServerErrorException;
	public void deleteAuto(int id) throws InternalServerErrorException;
	public Auto getAuto(int id);
	public List<Auto> setAuto(Auto auto);
	public List<Auto> getListaAuto();
	//private List<Auto> generateListaAuto();

    interface UserService {
    }
}
