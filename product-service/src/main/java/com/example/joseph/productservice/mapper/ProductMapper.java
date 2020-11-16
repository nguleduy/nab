package com.example.joseph.productservice.mapper;

import com.example.joseph.productservice.dto.ProductDTO;
import com.example.joseph.productservice.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper extends AbstractMapper<ProductDTO, Product> {

  ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

}
