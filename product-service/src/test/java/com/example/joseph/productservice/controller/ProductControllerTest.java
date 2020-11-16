package com.example.joseph.productservice.controller;

import com.example.joseph.productservice.constants.Constant;
import com.example.joseph.productservice.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Description;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ProductController.class)
public class ProductControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ProductService productService;

  @Test
  public void findAllProductsTest() throws Exception {
    mockMvc.perform(get(Constant.PRODUCT_URL)
            .header("username", "joseph")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    verify(productService).findAll();
  }
}
