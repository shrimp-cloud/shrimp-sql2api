package com.wkclz.sql2api.manager.service;

import com.wkclz.sql2api.engine.domain.base.SaPageData;
import com.wkclz.sql2api.manager.dao.ApiGroupMapper;
import com.wkclz.sql2api.manager.domain.dto.ApiGroupDto;
import com.wkclz.sql2api.manager.domain.entity.ApiGroup;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shrimp
 */
@Service
public class ApiGroupService {

    @Resource
    private ApiGroupMapper apiGroupMapper;

    public SaPageData<ApiGroupDto> groupPage(ApiGroupDto dto) {
        Long count = apiGroupMapper.getCount(dto);
        List<ApiGroupDto> rows;
        if (count > 0) {
            dto.init();
            rows = apiGroupMapper.getList(dto);
        } else {
            rows = new ArrayList<>();
        }
        return SaPageData.newInstance(dto.getCurrent(), dto.getSize(), count, rows);
    }

    public ApiGroup groupDetail(Long id) {
        return apiGroupMapper.getById(id);
    }
    public ApiGroup groupCreate(ApiGroup entity) {
        apiGroupMapper.insert(entity);
        return entity;
    }
    public ApiGroup groupUpdate(ApiGroup entity) {
        apiGroupMapper.update(entity);
        return entity;
    }
    public Integer groupDelete(ApiGroup entity) {
        return apiGroupMapper.delete(entity);
    }

}
