package com.wkclz.sql2api.manager.rest;

import com.wkclz.sql2api.engine.domain.base.SaPageData;
import com.wkclz.sql2api.engine.domain.base.SaResult;
import com.wkclz.sql2api.manager.domain.dto.ApiDefinitionHisDto;
import com.wkclz.sql2api.manager.domain.entity.ApiDefinitionHis;
import com.wkclz.sql2api.manager.service.ApiDefinitionHisService;
import jakarta.annotation.Resource;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shrimp
 */
@RestController
@RequestMapping("${sql2api.rest-prefix:/sql2api}")
public class ApiDefinitionHisRest {


    @Resource
    private ApiDefinitionHisService apiDefinitionHisService;

    @GetMapping(Routes.DEFINITION_HIS_PAGE)
    public SaResult definitionHisPage(ApiDefinitionHisDto dto) {
        SaPageData<ApiDefinitionHisDto> page = apiDefinitionHisService.definitionHisPage(dto);
        return SaResult.data(page);
    }

    @GetMapping(Routes.DEFINITION_HIS_DETAIL)
    public SaResult definitionHisDetail(ApiDefinitionHis entity) {
        Assert.notNull(entity.getId(), "id can not be null");
        ApiDefinitionHis ag = apiDefinitionHisService.definitionHisDetail(entity.getId());
        return SaResult.data(ag);
    }
    
}
