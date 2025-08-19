package com.wkclz.sql2api.manager.service;

import com.wkclz.sql2api.manager.domain.base.Result;
import com.wkclz.sql2api.manager.rest.Routes;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class ApiDefinitionHisService {

    public Result definitionHisPage() {
        return Result.ok();
    }
    public Result definitionHisDetail() {
        return Result.ok();
    }

}
