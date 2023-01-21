package com.jespApiTest.CarServices.services.impl;
import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.jespApiTest.CarServices.exception.InternalServerErrorException;
import com.jespApiTest.CarServices.models.Auto;
import com.jespApiTest.CarServices.repository.AutoRepository;
import com.jespApiTest.CarServices.repository.UserRepository;
import com.jespApiTest.CarServices.services.AutoServiceInt;

@Slf4j
@Service
public class AutoServiceImple implements AutoServiceInt{

	@Autowired
	private AutoRepository autoRepository;
	@Autowired
	private UserRepository userRepository;
	
	public Auto saveAuto(Auto auto)throws InternalServerErrorException{
		try {
			UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			auto.setIdProprietario(userRepository.findByUsername(user.getUsername()).getId());
			return autoRepository.save(auto);
		}
		catch(Exception exception){
			throw new InternalServerErrorException(exception.getMessage());
		}
	}
	
	public Auto deleteAuto(int id) throws InternalServerErrorException{
		try {
			UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Optional<Auto> autoToRet = autoRepository.findById(id);
			if(!autoToRet.isPresent()) throw new InternalServerErrorException("Auto not found");
			if(autoRepository.findById(id).get().getIdProprietario() != userRepository.findByUsername(user.getUsername()).getId()){
				throw new InternalServerErrorException("Auto non autorizzata");
			}
			autoRepository.deleteById(id);
			return autoToRet.get();
		}
		catch(Exception exception){
			throw new InternalServerErrorException(exception.getMessage());
		}
	}
	
//	public Auto getAutoRep(int id) throws InternalServerErrorException{
//		try {
//
//
//			Auto auto = autoRepository.findById(id).get();
//			if(auto != null) {
//				return auto;
//			}else {
//				throw new NotFoundException("Nessun auto trovata per id: "+id);
//			}
//
//		}
//		catch(Exception e) {
//			throw new InternalServerErrorException(e.getMessage());
//		}
//	}
	
	public List<Auto> getUserAuto() throws InternalServerErrorException{
		try {
			UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			return (List<Auto>) autoRepository.findByidProprietario(userRepository.findByUsername(user.getUsername()).getId());
		}
		catch(Exception exception){
			throw new InternalServerErrorException(exception.getMessage());
		}
	}
//
//	public List<Auto> getAutoUser() throws InternalServerErrorException{
//		try {
//			return (List<Auto>) autoRepository.findAll();
//		}
//		catch(Exception exception){
//			throw new InternalServerErrorException(exception.getMessage());
//		}
//	}
	
//	private List<Auto> generateListaAuto() {
//		List<Auto> retList = new ArrayList<Auto>();
//		for(int i=0;i<30;i++) {
//			//private int id; private String modello;private String marca;private String targa;private String colore;private int anno;
//			Auto temp = new Auto(i, "modello" + i, "marca" + i, "targa" + i, "colore"+i, 1998+i );
//			retList.add(temp);
//		}
//		return retList;
//	}

}
