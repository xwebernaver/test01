package com.kc.sba.controller;


import com.kc.sba.dto.CreateDeveloper;
import com.kc.sba.service.SbaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SbaController {
/*
    SbaController(Bean) SbaService(Bean) DeveloperRespository(Bean)
    ================= Spring Application Context ===================
*/

    private final SbaService sbaService;

    /*
    public SbaController(SbaService sbaService) {
        this.sbaService = sbaService;
    }
    */

    @GetMapping("/developers")
    public List<String> getAllDevelopers(){
        // GET /developers HTTP/1.1
        log.info("GET /developers HTTP/1.1");

        //return new ArrayList<String>(Arrays.asList("snow", "elsa", "Olaf"));
        return Arrays.asList("jin", "lee", "jung");
    }

    @PostMapping("/create-developer")
    public List<String> createDevelopers(@Valid @RequestBody CreateDeveloper.Request request)
    {

        // GET /developers HTTP/1.1
        log.info("request : {}", request);

        sbaService.createDeveloper(request);

        //return new ArrayList<String>(Arrays.asList("snow", "elsa", "Olaf"));
        return List.of("love");
    }


}

