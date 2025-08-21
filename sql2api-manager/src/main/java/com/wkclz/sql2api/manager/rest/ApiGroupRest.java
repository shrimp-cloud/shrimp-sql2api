package com.wkclz.sql2api.manager.rest;

import com.wkclz.sql2api.engine.domain.base.SaPageData;
import com.wkclz.sql2api.engine.domain.base.SaResult;
import com.wkclz.sql2api.manager.domain.dto.ApiGroupDto;
import com.wkclz.sql2api.manager.domain.entity.ApiGroup;
import com.wkclz.sql2api.manager.service.ApiGroupService;
import jakarta.annotation.Resource;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

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
    public SaResult groupDetail(ApiGroup entity) {
        Assert.notNull(entity.getId(), "id can not be null");
        ApiGroup ag = apiGroupService.groupDetail(entity.getId());
        return SaResult.data(ag);
    }
    @PostMapping(Routes.GROUP_CREATE)
    public SaResult groupCreate(@RequestBody ApiGroup entity) {
        paramCheck(entity);
        ApiGroup ag = apiGroupService.groupCreate(entity);
        return SaResult.data(ag);
    }
    @PostMapping(Routes.GROUP_UPDATE)
    public SaResult groupUpdate(@RequestBody ApiGroup entity) {
        Assert.notNull(entity.getId(), "id can not be null");
        Assert.notNull(entity.getVersion(), "version can not be null");
        paramCheck(entity);
        ApiGroup ag = apiGroupService.groupUpdate(entity);
        return SaResult.data(ag);
    }
    @PostMapping(Routes.GROUP_DELETE)
    public SaResult groupDelete(@RequestBody ApiGroup entity) {
        Assert.notNull(entity.getId(), "id can not be null");
        Integer d = apiGroupService.groupDelete(entity);
        return SaResult.data(d);
    }

    private static void paramCheck(ApiGroup entity) {
        Assert.notNull(entity.getGroupName(), "groupName can not be null");
    }
}
