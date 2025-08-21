package com.wkclz.sql2api.manager.dao;

import com.wkclz.sql2api.manager.domain.dto.ApiDefinitionDto;
import com.wkclz.sql2api.manager.domain.entity.ApiDefinition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ApiDefinitionMapper {

    Long getCount(ApiDefinitionDto dto);
    List<ApiDefinitionDto> getList(ApiDefinitionDto dto);
    ApiDefinition getById(@Param("id") Long id);
    Long insert(ApiDefinition entity);
    Integer update(ApiDefinition entity);
    Integer delete(ApiDefinition entity);


}
