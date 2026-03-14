package com.spring.autowire;

import org.springframework.stereotype.Component;

@Component
public class Certification {

    private int id = 201;
    private String name = "Java Spring Certification";
    private String dateOfCompletion = "2026";

    public void displayCertification() {
        System.out.println("--- Certification Details ---");
        System.out.println("Certification ID: " + id);
        System.out.println("Certification Name: " + name);
        System.out.println("Completion Date: " + dateOfCompletion);
    }
}
