package com.pinguin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinguin.dto.DeveloperDto;
import com.pinguin.service.DeveloperService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = DeveloperController.class)
class DeveloperControllerTest {

    private final static String CONTENT_TYPE = "application/json";


    @InjectMocks
    private DeveloperController developerController;
    @MockBean
    private DeveloperService developerService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Before("")
    void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(developerController).build();

    }

    @Test
    void whenGetAllDevelopers_thenReturn200() throws Exception {
        DeveloperDto dto = new DeveloperDto();
        dto.setName("Nick");
        Mockito.when(developerService.getAll()).thenReturn(Arrays.asList(dto));

        MvcResult mvcResult = mockMvc.perform(get("/developers")
                .accept(CONTENT_TYPE)).andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();
        assertEquals(objectMapper.writeValueAsString(List.of(dto)).trim(), responseBody);
    }

    @Test
    void whenCallGetDevelopers_thenReturnNoData() throws Exception {
        Mockito.when(developerService.getAll()).thenReturn(Collections.emptyList());
        MvcResult mvcResult = mockMvc.perform(get("/developers")
                .accept(CONTENT_TYPE)).andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();
        assertEquals("",responseBody);
    }
}