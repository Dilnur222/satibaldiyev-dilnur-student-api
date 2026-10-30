package com.satibaldiyev.studentapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentApiApplication {
    public static void main(String[] args) {
        System.out.println("Student: Dilnur Satibaldiyev");
        System.out.println("Group: IT2-2304");
        System.out.println("Student ID: 38036");
        SpringApplication.run(StudentApiApplication.class, args);
    }
}
