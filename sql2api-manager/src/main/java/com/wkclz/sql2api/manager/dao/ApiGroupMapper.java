package com.wkclz.sql2api.manager.dao;

import com.wkclz.sql2api.manager.domain.dto.ApiGroupDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApiGroupMapper {

    // 分页
    Integer getApiGroupCount(ApiGroupDto dto);
    List<ApiGroupDto> getApiGroupList(ApiGroupDto dto);

}
