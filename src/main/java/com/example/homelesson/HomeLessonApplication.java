package com.example.homelesson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.homelesson.entity")
public class HomeLessonApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeLessonApplication.class, args);
    }

}
