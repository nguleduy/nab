package com.example.joseph.productservice.service;

import com.example.joseph.productservice.dto.ProductDTO;
import com.example.joseph.productservice.repository.ProductHistoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

  @Mock
  private ProductHistoryRepository productHistoryRepository;

  @Mock
  private ProductService productService;

  private PodamFactory podam = new PodamFactoryImpl();

  private ProductDTO productDTO;

  private ProductDTO initProduct() {
    productDTO = podam.manufacturePojo(ProductDTO.class);
    return productDTO;
  }

  @Test
  public void updateProductWithOldPriceTest() {
    initProduct();
    ProductDTO updatedProduct = productDTO;
    updatedProduct.setName("Pepsi");
    productService.update(updatedProduct);
    verifyNoInteractions(productHistoryRepository);
  }

  @Test
  public void updateProductWithNewPriceTest() {
    initProduct();
    ProductDTO updatedProduct = productDTO;
    updatedProduct.setPrice(BigDecimal.valueOf(21000));
    productService.update(updatedProduct);
    verify(productHistoryRepository).save(any());
  }
}
