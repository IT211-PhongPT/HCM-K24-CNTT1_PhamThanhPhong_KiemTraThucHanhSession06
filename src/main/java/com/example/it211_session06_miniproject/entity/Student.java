package com.example.it211_session06_miniproject.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.persistence.*;

@JacksonXmlRootElement(localName = "Student")
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Double gpa;

    public Student() {}

    public Student(String fullName, String email, Double gpa) {
        this.fullName = fullName;
        this.email    = email;
        this.gpa      = gpa;
    }

    public Long getId(){
        return id;
    }

    public String getFullName(){
        return fullName;
    }

    public String getEmail(){
        return email;
    }

    public Double getGpa(){
        return gpa;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setFullName(String name){
        this.fullName = name;
    }
    public void setEmail(String email) {
        this.email= email;
    }
    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }
}