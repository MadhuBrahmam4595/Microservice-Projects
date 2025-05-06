package com.provider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class DemoController {

    @GetMapping("/show")
    public String showMsg(){
        return "Hello from Demo Controller in Provider Application";
    }
}
