package com.impact.distributed.caching.controller;

import com.impact.distributed.caching.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private CacheService cacheService;

    @GetMapping
    public Map<String, String> getCachedData() {
        return cacheService.getDataFromMap();
    }

    @PostMapping
    public Map<String, String> saveDataInCache(@RequestBody Map<String, String> metrics) {
        cacheService.putDataInMap(metrics);
        return metrics;
    }
}
