package com.kc.sba.controller;


import com.kc.sba.dto.CreateDeveloper;
import com.kc.sba.dto.DeveloperDetailDto;
import com.kc.sba.dto.DeveloperDto;
import com.kc.sba.service.SbaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    /**
    public SbaController(SbaService sbaService) {
        this.sbaService = sbaService;
    }
    */

    @GetMapping("/developers")
    public List<DeveloperDto> getAllDevelopers(){
        // GET /developers HTTP/1.1
        log.info("GET /developers HTTP/1.1");

        //return new ArrayList<String>(Arrays.asList("snow", "elsa", "Olaf"));
        //return Arrays.asList("jung", "park", "kim");
        return sbaService.getAllDeveloper();
    }

    @GetMapping("/developers/{memberId}")
    public DeveloperDetailDto getDeveloperDetail(
            @PathVariable String memberId
    ){
        // GET /developers HTTP/1.1
        log.info("GET /developers HTTP/1.1");

        return sbaService.getDeveloperDetail(memberId);
    }


    @PostMapping("/create-developer")
    public CreateDeveloper.Response createDevelopers(
            @Valid @RequestBody CreateDeveloper.Request request)
    {

        // GET /developers HTTP/1.1
        log.info("request : {}", request);

        // sbaService.createDeveloper(request);
        // return new ArrayList<String>(Arrays.asList("snow", "elsa", "Olaf"));
        // return List.of("love");

        return sbaService.createDeveloper(request);
    }

}

