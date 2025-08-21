package com.wkclz.sql2api.manager.service;

import com.wkclz.sql2api.engine.domain.base.SaPageData;
import com.wkclz.sql2api.manager.dao.ApiDefinitionMapper;
import com.wkclz.sql2api.manager.domain.dto.ApiDefinitionDto;
import com.wkclz.sql2api.manager.domain.entity.ApiDefinition;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shrimp
 */
@Service
public class ApiDefinitionService {


    @Resource
    private ApiDefinitionMapper apDefinitionMapper;

    public SaPageData<ApiDefinitionDto> definitionPage(ApiDefinitionDto dto) {
        Long count = apDefinitionMapper.getCount(dto);
        List<ApiDefinitionDto> rows;
        if (count > 0) {
            dto.init();
            rows = apDefinitionMapper.getList(dto);
        } else {
            rows = new ArrayList<>();
        }
        return SaPageData.newInstance(dto.getCurrent(), dto.getSize(), count, rows);
    }

    public ApiDefinition definitionDetail(Long id) {
        return apDefinitionMapper.getById(id);
    }
    public ApiDefinition definitionCreate(ApiDefinition entity) {
        apDefinitionMapper.insert(entity);
        return entity;
    }
    public ApiDefinition definitionUpdate(ApiDefinition entity) {
        apDefinitionMapper.update(entity);
        return entity;
    }
    public Integer definitionDelete(ApiDefinition entity) {
        return apDefinitionMapper.delete(entity);
    }


}
