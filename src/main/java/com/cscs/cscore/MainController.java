package com.cscs.cscore;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String heartbeat() {
        return "server is alive";
    }
}
