package com.wkclz.sql2api.manager.rest;

import com.wkclz.sql2api.manager.domain.base.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${sql2api.rest-prefix:/sql2api}")
public class SqlApiDefinitionRest {

    @GetMapping(Routes.DEFINITION_PAGE)
    public Result definitionPage() {
        return Result.ok();
    }
    @GetMapping(Routes.DEFINITION_DETAIL)
    public Result definitionDetail() {
        return Result.ok();
    }
    @PostMapping(Routes.DEFINITION_CREATE)
    public Result definitionCreate() {
        return Result.ok();
    }
    @PostMapping(Routes.DEFINITION_UPDATE)
    public Result definitionUpdate() {
        return Result.ok();
    }
    @PostMapping(Routes.DEFINITION_DELETE)
    public Result definitionDelete() {
        return Result.ok();
    }

}
