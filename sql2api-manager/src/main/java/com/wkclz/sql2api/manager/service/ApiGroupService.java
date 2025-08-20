package com.wkclz.sql2api.manager.service;

import com.wkclz.sql2api.engine.domain.base.SaPageData;
import com.wkclz.sql2api.engine.domain.base.SaResult;
import com.wkclz.sql2api.manager.dao.ApiGroupMapper;
import com.wkclz.sql2api.manager.domain.dto.ApiGroupDto;
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
        Long count = apiGroupMapper.getApiGroupCount(dto);
        List<ApiGroupDto> rows;
        if (count > 0) {
            dto.init();
            rows = apiGroupMapper.getApiGroupList(dto);
        } else {
            rows = new ArrayList<>();
        }
        return SaPageData.newInstance(dto.getCurrent(), dto.getSize(), count, rows);
    }

    public SaResult groupDetail() {
        return SaResult.ok();
    }
    public SaResult groupCreate() {
        return SaResult.ok();
    }
    public SaResult groupUpdate() {
        return SaResult.ok();
    }
    public SaResult groupDelete() {
        return SaResult.ok();
    }

}
