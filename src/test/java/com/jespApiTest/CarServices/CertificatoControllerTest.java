package com.jespApiTest.CarServices;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import com.jespApiTest.CarServices.exception.InternalServerErrorException;
import com.jespApiTest.CarServices.exception.NotFoundException;
import com.jespApiTest.CarServices.services.impl.CertificatoServiceImple;

@SpringBootTest  //@WebMvcTest(AutoController.class)
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CertificatoControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	@Mock
    private CertificatoServiceImple certificatoService;
	
//	@InjectMocks
//    private CertificatoController controller;
	
	//CertificatoServiceImple certificatoServiceTest = new CertificatoServiceImple();
	
//    @BeforeEach
//    private void before(){
//    	//autoService = mock(AutoServiceImple.class);
//    	mockMvc = MockMvcBuilders
//    	        .standaloneSetup(this.controller)
//    	        .setHandlerExceptionResolvers(ContextHelper.withExceptionControllerAdvice())
//    	        .defaultRequest(options("/")
//                .accept(MediaType.APPLICATION_JSON))
//    	        .build();
//
//    }
    
//    @Test
//    void getListaCertificati() throws Exception{
//    	//Auto auto = new Auto(15, "modello", "marca", "targa", "colore", 1998);
//    	//Iterable<Certificato> certificati =(Iterable<Certificato>) new TreeSet<Certificato>();
//    	List<Certificato> certificati = new ArrayList<Certificato>();
//    	for(int i=1; i<=30; i++) {
//    		Auto auto = new Auto(i,"modello"+i,"colore"+i,"cose"+i, "easd"+i, 1999+i);
//    		Certificato temp = new Certificato(i,auto,1999+i);
//    		certificati.add(temp);
//    	}
//
//    	when(certificatoService.getListaCertificati()).thenReturn(certificati);
//
//    	mockMvc.perform(get("/certificato/all")
//    			.contentType("application/json"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                //.andExpect(jsonPath("$.modello").value("modello"));
//    			.andExpect(jsonPath("$", hasSize(30)));
//    	 verify(certificatoService).getListaCertificati();
//    }
    
    @Test
    void getListaCertificatiInternalServerException() throws Exception{
    	
    	doThrow(InternalServerErrorException.class).when(certificatoService).getListaCertificati();
    	
    	mockMvc.perform(get("/certificato/all")
    			.contentType("application/json"))
                .andDo(print())
                .andExpect(status().isInternalServerError());
    			
    }
    
    @Test
    void getListaCertificatiNotFoundException() throws Exception{
    	
    	doThrow(NotFoundException.class).when(certificatoService).getListaCertificati();
    	
    	mockMvc.perform(get("/certificato/all")
    			.contentType("application/json"))
                .andDo(print())
                .andExpect(status().isNotFound());
    			
    }
    
    
}
