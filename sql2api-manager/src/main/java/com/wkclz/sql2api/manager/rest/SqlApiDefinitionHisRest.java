package com.wkclz.sql2api.manager.rest;

import com.wkclz.sql2api.manager.domain.base.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${sql2api.rest-prefix:/sql2api}")
public class SqlApiDefinitionHisRest {

    @GetMapping(Routes.DEFINITION_HIS_PAGE)
    public Result definitionHisPage() {
        return Result.ok();
    }
    @GetMapping(Routes.DEFINITION_HIS_DETAIL)
    public Result definitionHisDetail() {
        return Result.ok();
    }
}
