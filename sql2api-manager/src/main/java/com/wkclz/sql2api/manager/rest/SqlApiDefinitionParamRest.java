package com.wkclz.sql2api.manager.rest;

import com.wkclz.sql2api.manager.domain.base.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${sql2api.rest-prefix:/sql2api}")
public class SqlApiDefinitionParamRest {

    @GetMapping(Routes.DEFINITION_PARAM_LIST)
    public Result definitionParamList() {
        return Result.ok();
    }
    @PostMapping(Routes.DEFINITION_PARAM_CREATE)
    public Result definitionParamCreate() {
        return Result.ok();
    }
    @PostMapping(Routes.DEFINITION_PARAM_UPDATE)
    public Result definitionParamUpdate() {
        return Result.ok();
    }
    @PostMapping(Routes.DEFINITION_PARAM_DELETE)
    public Result definitionParamDelete() {
        return Result.ok();
    }


}
