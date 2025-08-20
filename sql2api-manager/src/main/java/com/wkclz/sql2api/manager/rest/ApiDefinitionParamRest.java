package com.wkclz.sql2api.manager.rest;

import com.wkclz.sql2api.engine.domain.base.SaResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shrimp
 */
@RestController
@RequestMapping("${sql2api.rest-prefix:/sql2api}")
public class ApiDefinitionParamRest {

    @GetMapping(Routes.DEFINITION_PARAM_LIST)
    public SaResult definitionParamList() {
        return SaResult.ok();
    }
    @PostMapping(Routes.DEFINITION_PARAM_CREATE)
    public SaResult definitionParamCreate() {
        return SaResult.ok();
    }
    @PostMapping(Routes.DEFINITION_PARAM_UPDATE)
    public SaResult definitionParamUpdate() {
        return SaResult.ok();
    }
    @PostMapping(Routes.DEFINITION_PARAM_DELETE)
    public SaResult definitionParamDelete() {
        return SaResult.ok();
    }


}
