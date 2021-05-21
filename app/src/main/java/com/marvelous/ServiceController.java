package com.marvelous;

import com.marvelous.api.APIDefinition;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    @GetMapping(path = "/")
    public String index() {

        return "index";
    }

}
