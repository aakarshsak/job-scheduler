package com.zoroapp.job_scheduler.user_security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/views")
public class ViewController {


    @GetMapping("")
    public String hello() {
        return "HEllo World";
    }
}
