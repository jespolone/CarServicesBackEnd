package com.jespApiTest.CarServices;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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
import com.jespApiTest.CarServices.services.impl.AutoServiceImple;

@SpringBootTest  //@WebMvcTest(AutoController.class)
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AutoControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@Mock
    private AutoServiceImple autoService;
	
//    @InjectMocks
//    private AutoController controller;

//	@BeforeEach
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
//    void getAutoController() throws Exception{
//    	Auto auto = new Auto(15, "modello", "marca", "targa", "colore", 1998);
//
//    	when(autoService.getAutoRep(anyInt())).thenReturn(auto);
//
//    	 mockMvc.perform(get("/auto/0")
//                 .contentType("application/json"))
//                 .andDo(print())
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$.modello").value("modello"));
//
//    	 verify(autoService).getAutoRep(eq(0));
//    }
    
//    @Test
//    void getAutoError() throws Exception{
//    	Auto auto = new Auto(15, "modello", "marca", "targa", "colore", 1998);
//
//    	when(autoService.getAutoRep(anyInt())).thenReturn(auto);
//
//    	 mockMvc.perform(get("/auto/0")
//                 .contentType("application/json"))
//                 .andDo(print())
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$.modello").value("modello"));
//
//    	 verify(autoService).getAutoRep(eq(0));
//    }
    
//    @Test
//    void getAutoListController() throws Exception {
////    	List<Auto> autoLista = new ArrayList<Auto>();
////		for(int i=0;i<30;i++) {
////			//private int id; private String modello;private String marca;private String targa;private String colore;private int anno;
////			Auto temp = new Auto(i, "modello" + i, "marca" + i, "targa" + i, "colore"+i, 1998+i );
////			autoLista.add(temp);
////		}
//
//    	List<Auto> autoLista = generateListaAuto();
//    	when(autoService.getListaAuto()).thenReturn(autoLista);
//
//        mockMvc.perform(get("/auto/all")
//                .contentType("application/json"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(30)));
//
//        verify(autoService).getListaAuto();
//
//    }
    
//    @Test
//    void getAutoController() throws Exception{
//    	Auto auto = new Auto(15, "modello", "marca", "targa", "colore", 1998);
//    	
//    	when(autoService.getAuto(anyInt())).thenReturn(auto);
//    	
//    	 mockMvc.perform(get("/auto/0")
//                 .contentType("application/json"))
//                 .andDo(print())
//                 .andExpect(status().isOk())
//                 //.andExpect(jsonPath("$", hasSize(6)));
//                 .andExpect(jsonPath("$.modello").value("modello"));
//                 
//    	 verify(autoService).getAuto(eq(0));
//    }
    
   
//    @Test
//    void setAutoController() throws Exception {
//    	Auto auto = new Auto(15, "modello", "marca", "targa", "colore", 1998);
//    	List<Auto> listaAuto = generateListaAuto();
//    	listaAuto.add(auto);
//
//    	doNothing().when(autoService).saveAuto(any(Auto.class));
//
//    	mockMvc.perform(post("/auto/save")
//    			.contentType("application/json")
//    			.content(objectMapper.writeValueAsString(auto)))
//                .andDo(print())
//                .andExpect(status().isCreated());
//
//    	 verify(autoService).saveAuto(eq(auto));
//    }
    
//    @Test
//    void getAutoRepErrorNotFound() throws Exception {
//
//    	doThrow(NotFoundException.class).when(autoService).getAutoRep(anyInt());
//
//    	mockMvc.perform(get("/auto/0")
//    			.contentType("application/json"))
//                .andDo(print())
//                .andExpect(status().isNotFound());
//    	//non si verifica niente perche' esplode gg
//    }
    
//    @Test
//    void getAutoRepErrorInternalServerException() throws Exception {
//
//    	doThrow(InternalServerErrorException.class).when(autoService).getAutoRep(anyInt());
//
//    	mockMvc.perform(get("/auto/0")
//    			.contentType("application/json"))
//                .andDo(print())
//                .andExpect(status().isInternalServerError());
//    	//non si verifica niente perche' esplode gg
//    }
    
    @Test
    void deleteAutoController() throws Exception {
    	
    	doNothing().when(autoService).deleteAuto(anyInt());
    	
    	mockMvc.perform(delete("/autodelete/0")
    			.contentType("application/json"))
                .andDo(print())
                .andExpect(status().isNoContent());
    	
    }
    
    @Test
    void deleteAutoControllerError() throws Exception {
    	
    	doThrow(InternalServerErrorException.class).when(autoService).deleteAuto(anyInt());
    	
    	mockMvc.perform(delete("/autodelete/0")
    			.contentType("application/json"))
                .andDo(print())
                .andExpect(status().isInternalServerError());
    }
    
//    @Test
//    void saveAuto() throws Exception{
//		//controller.service = autoService;
//		Auto temp = new Auto(15, "modello", "marca", "targa", "colore", 1998);
//		//when(autoService.saveAuto(temp)).thenReturn(null);
//		autoService.saveAuto(temp);
//		verify(autoService).saveAuto(temp);
//	}
    
//    @Test
//    void deleteAuto() throws Exception{
//		 //when(autoService.deleteAuto(1)).thenReturn("first");
//		autoService.deleteAuto(0);
//		verify(autoService).deleteAuto(0);
//	}
    
//    @Test
//    void getAuto() throws Exception{
//		Auto compareAuto = getAutoAux(generateListaAuto(), 1);
//		assertEquals(autoServiceTest.getAuto(1),compareAuto);
//	}
    
//    @Test
//    void setAuto() throws Exception{
//    	Auto temp = new Auto(15, "modello", "marca", "targa", "colore", 1998);
//    	List<Auto> listaAuto = generateListaAuto();
//    	listaAuto.add(temp);
//    	assertEquals(autoServiceTest.setAuto(temp),listaAuto);
//    }
    
//	@Test
//	void getAutoList() throws Exception{
//		List<Auto> retList = new ArrayList<Auto>();
//		for(int i=0;i<30;i++) {
//			//private int id; private String modello;private String marca;private String targa;private String colore;private int anno;
//			Auto temp = new Auto(i, "modello" + i, "marca" + i, "targa" + i, "colore"+i, 1998+i );
//			retList.add(temp);
//		}
//		assertEquals(autoServiceTest.getListaAuto(),retList);
//		//Assert.assertEquals(autoService.getListaAuto(),retList);
//		//verify(autoService).getListaAuto();
//		//verify(controller).getAutoList();
//	}
	
//	private List<Auto> generateListaAuto() {
//		List<Auto> retList = new ArrayList<Auto>();
//
//		for(int i=0;i<30;i++) {
//			//private int id; private String modello;private String marca;private String targa;private String colore;private int anno;
//			Auto temp = new Auto(i, "modello" + i, "marca" + i, "targa" + i, "colore"+i, 1998+i );
//			retList.add(temp);
//		}
//		return retList;
//	}
	
//	public Auto getAutoAux(List<Auto> listaAuto, int id) {
//		for(Auto temp : listaAuto) {
//			if(temp.getId() == id)
//				return temp;
//		}
//		return null;
//	}

}
