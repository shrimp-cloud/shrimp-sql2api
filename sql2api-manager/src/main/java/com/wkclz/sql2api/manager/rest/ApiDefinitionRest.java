package com.wkclz.sql2api.manager.rest;

import com.wkclz.sql2api.engine.domain.base.SaPageData;
import com.wkclz.sql2api.engine.domain.base.SaResult;
import com.wkclz.sql2api.manager.domain.dto.ApiDefinitionDto;
import com.wkclz.sql2api.manager.domain.entity.ApiDefinition;
import com.wkclz.sql2api.manager.service.ApiDefinitionService;
import jakarta.annotation.Resource;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

/**
 * @author shrimp
 */
@RestController
@RequestMapping("${sql2api.rest-prefix:/sql2api}")
public class ApiDefinitionRest {


    @Resource
    private ApiDefinitionService apiDefinitionService;

    @GetMapping(Routes.DEFINITION_PAGE)
    public SaResult definitionPage(ApiDefinitionDto dto) {
        SaPageData<ApiDefinitionDto> page = apiDefinitionService.definitionPage(dto);
        return SaResult.data(page);
    }

    @GetMapping(Routes.DEFINITION_DETAIL)
    public SaResult definitionDetail(ApiDefinition entity) {
        Assert.notNull(entity.getId(), "id can not be null");
        ApiDefinition ag = apiDefinitionService.definitionDetail(entity.getId());
        return SaResult.data(ag);
    }
    @PostMapping(Routes.DEFINITION_CREATE)
    public SaResult definitionCreate(@RequestBody ApiDefinition entity) {
        paramCheck(entity);
        ApiDefinition ag = apiDefinitionService.definitionCreate(entity);
        return SaResult.data(ag);
    }
    @PostMapping(Routes.DEFINITION_UPDATE)
    public SaResult definitionUpdate(@RequestBody ApiDefinition entity) {
        Assert.notNull(entity.getId(), "id can not be null");
        Assert.notNull(entity.getVersion(), "version can not be null");
        paramCheck(entity);
        ApiDefinition ag = apiDefinitionService.definitionUpdate(entity);
        return SaResult.data(ag);
    }
    @PostMapping(Routes.DEFINITION_DELETE)
    public SaResult definitionDelete(@RequestBody ApiDefinition entity) {
        Assert.notNull(entity.getId(), "id can not be null");
        Integer d = apiDefinitionService.definitionDelete(entity);
        return SaResult.data(d);
    }

    private static void paramCheck(ApiDefinition entity) {
        Assert.notNull(entity.getGroupCode(), "groupCode can not be null");
        Assert.notNull(entity.getApiName(), "apiName can not be null");
        Assert.notNull(entity.getApiMethod(), "apiMethod can not be null");
        Assert.notNull(entity.getApiName(), "apiName can not be null");
        Assert.notNull(entity.getApiUri(), "apiUri can not be null");
        Assert.notNull(entity.getResultType(), "resultType can not be null");
        if (entity.getEnableFlag() == null) {
            entity.setEnableFlag(1);
        }
        if (entity.getHumpConversionSwitch() == null) {
            entity.setHumpConversionSwitch(1);
        }
    }

}
