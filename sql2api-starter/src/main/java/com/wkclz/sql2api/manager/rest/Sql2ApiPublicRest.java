package com.wkclz.sql2api.manager.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Sql2ApiPublicRest {

    @GetMapping("/public/status")
    public ResponseEntity<Long> publicTest() {
        long now = System.currentTimeMillis();
        return ResponseEntity.ok(now);
    }

}
