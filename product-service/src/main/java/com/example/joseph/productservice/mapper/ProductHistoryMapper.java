package com.example.joseph.productservice.mapper;

import com.example.joseph.productservice.dto.ProductHistoryDTO;
import com.example.joseph.productservice.entity.ProductHistory;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductHistoryMapper extends AbstractMapper<ProductHistoryDTO, ProductHistory> {

  ProductHistoryMapper INSTANCE = Mappers.getMapper(ProductHistoryMapper.class);

}
