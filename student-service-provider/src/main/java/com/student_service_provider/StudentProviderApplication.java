package com.student_service_provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("provider")
public class StudentProviderApplication {

    @Value("${server.port}")
    private String port;

    @GetMapping("show")
    public String showMsg(){
        System.out.println("port=======>"+port);
        return "Hello from Student Provider controller";
    }
}
