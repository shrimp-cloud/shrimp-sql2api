package com.wkclz.sql2api.manager.rest;

import com.wkclz.sql2api.engine.domain.base.SaPageData;
import com.wkclz.sql2api.engine.domain.base.SaResult;
import com.wkclz.sql2api.manager.domain.dto.ApiGroupDto;
import com.wkclz.sql2api.manager.service.ApiGroupService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shrimp
 */
@RestController
@RequestMapping("${sql2api.rest-prefix:/sql2api}")
public class ApiGroupRest {


    @Resource
    private ApiGroupService apiGroupService;

    @GetMapping(Routes.GROUP_PAGE)
    public SaResult groupPage(ApiGroupDto dto) {
        SaPageData<ApiGroupDto> page = apiGroupService.groupPage(dto);
        return SaResult.data(page);
    }

    @GetMapping(Routes.GROUP_DETAIL)
    public SaResult groupDetail() {
        return SaResult.ok();
    }
    @PostMapping(Routes.GROUP_CREATE)
    public SaResult groupCreate() {
        return SaResult.ok();
    }
    @PostMapping(Routes.GROUP_UPDATE)
    public SaResult groupUpdate() {
        return SaResult.ok();
    }
    @PostMapping(Routes.GROUP_DELETE)
    public SaResult groupDelete() {
        return SaResult.ok();
    }

}
