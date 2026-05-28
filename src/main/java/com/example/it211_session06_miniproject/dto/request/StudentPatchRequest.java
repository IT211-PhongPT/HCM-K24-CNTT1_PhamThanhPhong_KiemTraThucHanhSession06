package com.example.it211_session06_miniproject.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class StudentPatchRequest {
    private String fullName;

    @Email(message = "Email không đúng định dạng")
    private String email;

    @Min(value = 0, message = "GPA không được nhỏ hơn 0")
    @Max(value = 4, message = "GPA không được lớn hơn 4")
    private Double gpa;

    public StudentPatchRequest(){}

    public String getFullName(){
        return fullName;
    }

    public String getEmail(){
        return email;
    }

    public Double getGpa(){
        return gpa;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setGpa(Double gpa){
        this.gpa = gpa;
    }
}