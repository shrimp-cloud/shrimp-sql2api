package com.wkclz.sql2api.manager.service;

import com.wkclz.sql2api.manager.dao.ApiDefinitionParamMapper;
import com.wkclz.sql2api.manager.domain.entity.ApiDefinitionParam;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiDefinitionParamService {


    @Resource
    private ApiDefinitionParamMapper apDefinitionParamMapper;

    public List<ApiDefinitionParam> definitionParamList(ApiDefinitionParam entity) {
        return apDefinitionParamMapper.getList(entity);
    }

    public ApiDefinitionParam definitionParamDetail(Long id) {
        return apDefinitionParamMapper.getById(id);
    }
    public ApiDefinitionParam definitionParamCreate(ApiDefinitionParam entity) {
        apDefinitionParamMapper.insert(entity);
        return entity;
    }
    public ApiDefinitionParam definitionParamUpdate(ApiDefinitionParam entity) {
        apDefinitionParamMapper.update(entity);
        return entity;
    }
    public Integer definitionParamDelete(ApiDefinitionParam entity) {
        return apDefinitionParamMapper.delete(entity);
    }



}
