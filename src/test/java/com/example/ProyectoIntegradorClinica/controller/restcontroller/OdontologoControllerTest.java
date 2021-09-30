package com.example.ProyectoIntegradorClinica.controller.restcontroller;

import com.example.ProyectoIntegradorClinica.dto.OdontologoDto;
import com.example.ProyectoIntegradorClinica.util.Jsons;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class OdontologoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testBuscarOdontologo() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/odontologos/buscarId/{id}", 1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nombre").value("Lisandro"));
    }


    @BeforeEach
    public void testRegistrarOdontologo() throws Exception {

     OdontologoDto od = new OdontologoDto("Lisandro", "Leon", "AAA999");
     OdontologoDto respuesta = new OdontologoDto(1, "Lisandro", "Leon", "AAA999");

     MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/odontologos/nuevo")
            .contentType(MediaType.APPLICATION_JSON)
            .content(Jsons.asJsonString(od)))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
      Assert.assertEquals(Jsons.asJsonString(respuesta), response.getResponse().getContentAsString());
 }

}