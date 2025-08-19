package com.wkclz.sql2api.manager.rest;

import com.wkclz.sql2api.manager.domain.base.Result;
import com.wkclz.sql2api.manager.domain.entity.ApiGroup;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${sql2api.rest-prefix:/sql2api}")
public class SqlApiGroupRest {

    @GetMapping(Routes.GROUP_PAGE)
    public Result groupPage(ApiGroup entity) {
        return Result.ok();
    }
    @GetMapping(Routes.GROUP_DETAIL)
    public Result groupDetail() {
        return Result.ok();
    }
    @PostMapping(Routes.GROUP_CREATE)
    public Result groupCreate() {
        return Result.ok();
    }
    @PostMapping(Routes.GROUP_UPDATE)
    public Result groupUpdate() {
        return Result.ok();
    }
    @PostMapping(Routes.GROUP_DELETE)
    public Result groupDelete() {
        return Result.ok();
    }

}
