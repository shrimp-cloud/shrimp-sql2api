package com.wkclz.sql2api.manager.rest;

import com.wkclz.sql2api.engine.domain.base.SaResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shrimp
 */
@RestController
@RequestMapping("${sql2api.rest-prefix:/sql2api}")
public class ApiDefinitionHisRest {

    @GetMapping(Routes.DEFINITION_HIS_PAGE)
    public SaResult definitionHisPage() {
        return SaResult.ok();
    }
    @GetMapping(Routes.DEFINITION_HIS_DETAIL)
    public SaResult definitionHisDetail() {
        return SaResult.ok();
    }
}
