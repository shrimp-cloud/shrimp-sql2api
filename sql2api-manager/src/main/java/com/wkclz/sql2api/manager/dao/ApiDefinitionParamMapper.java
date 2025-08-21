package com.wkclz.sql2api.manager.dao;

import com.wkclz.sql2api.manager.domain.entity.ApiDefinitionParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ApiDefinitionParamMapper {

    List<ApiDefinitionParam> getList(ApiDefinitionParam entity);
    ApiDefinitionParam getById(@Param("id") Long id);
    Long insert(ApiDefinitionParam entity);
    Integer update(ApiDefinitionParam entity);
    Integer delete(ApiDefinitionParam entity);

}
