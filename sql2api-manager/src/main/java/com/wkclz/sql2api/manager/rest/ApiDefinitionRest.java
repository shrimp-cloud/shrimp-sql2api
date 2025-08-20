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
public class ApiDefinitionRest {

    @GetMapping(Routes.DEFINITION_PAGE)
    public SaResult definitionPage() {
        return SaResult.ok();
    }
    @GetMapping(Routes.DEFINITION_DETAIL)
    public SaResult definitionDetail() {
        return SaResult.ok();
    }
    @PostMapping(Routes.DEFINITION_CREATE)
    public SaResult definitionCreate() {
        return SaResult.ok();
    }
    @PostMapping(Routes.DEFINITION_UPDATE)
    public SaResult definitionUpdate() {
        return SaResult.ok();
    }
    @PostMapping(Routes.DEFINITION_DELETE)
    public SaResult definitionDelete() {
        return SaResult.ok();
    }

}
