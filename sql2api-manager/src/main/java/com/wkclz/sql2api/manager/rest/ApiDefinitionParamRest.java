package com.wkclz.sql2api.manager.rest;

import com.wkclz.sql2api.engine.domain.base.SaResult;
import com.wkclz.sql2api.manager.domain.dto.ApiDefinitionParamDto;
import com.wkclz.sql2api.manager.domain.entity.ApiDefinitionParam;
import com.wkclz.sql2api.manager.service.ApiDefinitionParamService;
import jakarta.annotation.Resource;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author shrimp
 */
@RestController
@RequestMapping("${sql2api.rest-prefix:/sql2api}")
public class ApiDefinitionParamRest {


    @Resource
    private ApiDefinitionParamService apiDefinitionParamService;

    @GetMapping(Routes.DEFINITION_PARAM_LIST)
    public SaResult definitionParamList(ApiDefinitionParamDto dto) {
        List<ApiDefinitionParam> list = apiDefinitionParamService.definitionParamList(dto);
        return SaResult.data(list);
    }

    @PostMapping(Routes.DEFINITION_PARAM_CREATE)
    public SaResult definitionParamCreate(@RequestBody ApiDefinitionParam entity) {
        paramCheck(entity);
        ApiDefinitionParam ag = apiDefinitionParamService.definitionParamCreate(entity);
        return SaResult.data(ag);
    }
    @PostMapping(Routes.DEFINITION_PARAM_UPDATE)
    public SaResult definitionParamUpdate(@RequestBody ApiDefinitionParam entity) {
        Assert.notNull(entity.getId(), "id can not be null");
        Assert.notNull(entity.getVersion(), "version can not be null");
        paramCheck(entity);
        ApiDefinitionParam ag = apiDefinitionParamService.definitionParamUpdate(entity);
        return SaResult.data(ag);
    }
    @PostMapping(Routes.DEFINITION_PARAM_DELETE)
    public SaResult definitionParamDelete(@RequestBody ApiDefinitionParam entity) {
        Assert.notNull(entity.getId(), "id can not be null");
        Integer d = apiDefinitionParamService.definitionParamDelete(entity);
        return SaResult.data(d);
    }

    private static void paramCheck(ApiDefinitionParam entity) {
        Assert.notNull(entity.getApiCode(), "apiCode can not be null");
        Assert.notNull(entity.getFieldName(), "fieldName can not be null");
        if (entity.getRequired() == null) {
            entity.setRequired(0);
        }
    }

}
