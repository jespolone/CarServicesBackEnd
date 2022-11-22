package com.jespApiTest.CarServices.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jespApiTest.CarServices.exception.InternalServerErrorException;
import com.jespApiTest.CarServices.exception.NotFoundException;
import com.jespApiTest.CarServices.models.Auto;
import com.jespApiTest.CarServices.repository.AutoRepository;
import com.jespApiTest.CarServices.services.AutoServiceInt;

@Service
public class AutoServiceImple implements AutoServiceInt{

	@Autowired
	private AutoRepository autoRepository;
	
	public Auto getAutoVuota() {
		return new Auto();
	}
	
	public void saveAuto(Auto auto)throws InternalServerErrorException{
		try {
			autoRepository.save(auto);
		}
		catch(Exception exception){
			throw new InternalServerErrorException(exception.getMessage());
		}
	}
	
	public void deleteAuto(int id) throws InternalServerErrorException{
		try {
			autoRepository.deleteById(id);
		}
		catch(Exception exception){
			throw new InternalServerErrorException(exception.getMessage());
		}
	}
	
	public Auto getAutoRep(int id) throws InternalServerErrorException{
		try {
			Auto auto = autoRepository.findById(id).get();
			if(auto != null) {
				return auto;
			}else {
				throw new NotFoundException("Nessun auto trovata per id: "+id);
			}
				
		}
		catch(Exception e) {
			throw new InternalServerErrorException(e.getMessage());
		}
	}
	
	public Auto getAuto(int id) {
		List<Auto> autoList = generateListaAuto();
		for(Auto temp : autoList) {
			if(temp.getId() == id)
				return temp;
		}
		return null;
	}
	
	public List<Auto> setAuto(Auto auto){
		List<Auto> listAuto = generateListaAuto();
		listAuto.add(auto);
		return listAuto;
	}
	
	public List<Auto> getListaAuto() throws InternalServerErrorException{
		try {
			return (List<Auto>) autoRepository.findAll();
		}
		catch(Exception exception){
			throw new InternalServerErrorException(exception.getMessage());
		}
		
	}
	
	private List<Auto> generateListaAuto() {
		List<Auto> retList = new ArrayList<Auto>();
		for(int i=0;i<30;i++) {
			//private int id; private String modello;private String marca;private String targa;private String colore;private int anno;
			Auto temp = new Auto(i, "modello" + i, "marca" + i, "targa" + i, "colore"+i, 1998+i );
			retList.add(temp);
		}
		return retList;
	}

}
