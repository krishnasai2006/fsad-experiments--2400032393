package com.spring.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private long id = 2400032393L;
    private String name = "Krishnasai";
    private String gender = "Male";

    @Autowired
    private Certification certification;

    public void displayStudent() {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println();

        certification.displayCertification();
    }
}