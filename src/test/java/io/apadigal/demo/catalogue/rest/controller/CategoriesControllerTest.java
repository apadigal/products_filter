package io.apadigal.demo.catalogue.rest.controller;

import io.apadigal.demo.catalogue.CatalogueApplicationIntegrationTests;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@CatalogueApplicationIntegrationTests
public class CategoriesControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void Home() {
    }

    @Test
    public void getCategoryProducts() throws Exception {
        mockMvc.perform(get("/v1/categories/600001506?labelType=unknown")
                .accept(MediaTypes.HAL_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

        mockMvc.perform(get("/v1/categories/unknown")
                .accept(MediaTypes.HAL_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isNotFound());

        mockMvc.perform(get("/wrong/url/unknown")
                .accept(MediaTypes.HAL_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isNotFound());


        mockMvc.perform(get("/v1/categories/600001506?labelType=ShowPercDscount")
                .accept(MediaTypes.HAL_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(document("categories"));


    }
}