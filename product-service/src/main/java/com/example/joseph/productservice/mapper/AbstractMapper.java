package com.example.joseph.productservice.mapper;

import com.example.joseph.productservice.dto.AbstractDTO;
import com.example.joseph.productservice.entity.AbstractEntity;

public interface AbstractMapper<D extends AbstractDTO, E extends AbstractEntity> {

  E toEntity(D dto);

  D toDto(E entity);

}
