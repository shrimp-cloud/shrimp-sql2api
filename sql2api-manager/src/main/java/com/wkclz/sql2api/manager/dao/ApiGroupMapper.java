package com.wkclz.sql2api.manager.dao;

import com.wkclz.sql2api.manager.domain.dto.ApiGroupDto;
import com.wkclz.sql2api.manager.domain.entity.ApiGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ApiGroupMapper {

    Long getCount(ApiGroupDto dto);
    List<ApiGroupDto> getList(ApiGroupDto dto);
    ApiGroup getById(@Param("id") Long id);
    Long insert(ApiGroup entity);
    Integer update(ApiGroup entity);
    Integer delete(ApiGroup entity);

    List<ApiGroup> getOptions();

}
