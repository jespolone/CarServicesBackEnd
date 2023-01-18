package com.jespApiTest.CarServices.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.jespApiTest.CarServices.models.Auto;
import com.jespApiTest.CarServices.services.impl.AutoServiceImple;

/**
 *
 * Servizi REST Auto
 *
 * @author Elvin Iluca
 *
 */

@RestController
public class AutoController {
	@Autowired
	public AutoServiceImple service;

	//@PreAuthorize("hasAnyAuthority('ADMIN') || hasAnyAuthority('SERVICE')")
	@GetMapping("auto/all")
	@ResponseStatus(HttpStatus.OK)
	public List<Auto> getUserAuto(){
		return service.getUserAuto();
	}
	
//	@GetMapping("auto/{id}")
//	@ResponseStatus(HttpStatus.OK)
//	public Auto getAuto(@PathVariable("id") int idAuto) {
//		return service.getAutoRep(idAuto);
//	}
	
	@PostMapping("auto/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Auto saveAuto(@RequestBody Auto auto) { return service.saveAuto(auto); }


	//@PreAuthorize("hasAnyAuthority('ADMIN')")
	@DeleteMapping("autodelete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAuto(@PathVariable("id") int idAuto){
		service.deleteAuto(idAuto);
	}
}
