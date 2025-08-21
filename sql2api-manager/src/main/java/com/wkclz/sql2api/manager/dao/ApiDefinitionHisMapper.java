package com.wkclz.sql2api.manager.dao;

import com.wkclz.sql2api.manager.domain.dto.ApiDefinitionHisDto;
import com.wkclz.sql2api.manager.domain.entity.ApiDefinitionHis;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ApiDefinitionHisMapper {

    Long getCount(ApiDefinitionHisDto dto);
    List<ApiDefinitionHisDto> getList(ApiDefinitionHisDto dto);
    ApiDefinitionHis getById(@Param("id") Long id);
    Long insert(ApiDefinitionHis entity);
    Integer update(ApiDefinitionHis entity);
    Integer delete(ApiDefinitionHis entity);

}
