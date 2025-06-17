package com.actuator_app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logtest")
public class LogTestController {

    private static final Logger logger = LoggerFactory.getLogger(LogTestController.class);

    @GetMapping("/info")
    public String logInfo() {
        logger.info("This is an INFO log");
        return "Info logged";
    }

    @GetMapping("/error")
    public String logError() {
        logger.error("This is an ERROR log");
        return "Error logged";
    }
}

