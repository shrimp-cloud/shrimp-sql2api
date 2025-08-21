package com.wkclz.sql2api.manager.service;

import com.wkclz.sql2api.engine.domain.base.SaPageData;
import com.wkclz.sql2api.manager.dao.ApiDefinitionHisMapper;
import com.wkclz.sql2api.manager.domain.dto.ApiDefinitionHisDto;
import com.wkclz.sql2api.manager.domain.entity.ApiDefinitionHis;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiDefinitionHisService {

    @Resource
    private ApiDefinitionHisMapper apDefinitionHisMapper;

    public SaPageData<ApiDefinitionHisDto> definitionHisPage(ApiDefinitionHisDto dto) {
        Long count = apDefinitionHisMapper.getCount(dto);
        List<ApiDefinitionHisDto> rows;
        if (count > 0) {
            dto.init();
            rows = apDefinitionHisMapper.getList(dto);
        } else {
            rows = new ArrayList<>();
        }
        return SaPageData.newInstance(dto.getCurrent(), dto.getSize(), count, rows);
    }

    public ApiDefinitionHis definitionHisDetail(Long id) {
        return apDefinitionHisMapper.getById(id);
    }


}
