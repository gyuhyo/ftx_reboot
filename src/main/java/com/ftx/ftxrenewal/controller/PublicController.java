package com.ftx.ftxrenewal.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
public class PublicController {

    /**
     * 주소검색 api
     */
    @GetMapping("/api/address")
    public void address() {}

    /**
     * 템플릿
     */
    @GetMapping("/layout/layoutTemplate1")
    public void template() {}

    /**
     * 메인 & 로그인
     */
    @GetMapping({"/", "/index"})
    @Secured("permitAll")
    public String main() {
        log.info("========================================index===================================");
        return "index";
    }

}
