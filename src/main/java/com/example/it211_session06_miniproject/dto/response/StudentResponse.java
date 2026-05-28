package com.example.it211_session06_miniproject.dto.response;

import com.example.it211_session06_miniproject.entity.Student;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "StudentResponse")
public class StudentResponse {
    private Long   id;
    private String fullName;
    private String email;
    private Double gpa;

    public StudentResponse() {}
    public static StudentResponse fromEntity(Student student) {
        StudentResponse res = new StudentResponse();
        res.id       = student.getId();
        res.fullName = student.getFullName();
        res.email    = student.getEmail();
        res.gpa      = student.getGpa();
        return res;
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
}