package com.storozh.SpringExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.storozh.SpringExample.controller.StudentController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SpringExampleApplication {

    private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringExampleApplication.class, args);
        LOG.info("Application started");
    }
}