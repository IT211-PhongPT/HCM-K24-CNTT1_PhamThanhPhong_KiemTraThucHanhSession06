package com.example.it211_session06_miniproject.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class StudentRequest {
    @NotBlank(message = "Họ tên không được để trống")
    private String fullName;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;

    @NotNull(message = "GPA không được để trống")
    @Min(value = 0, message = "GPA không được nhỏ hơn 0")
    @Max(value = 4, message = "GPA không được lớn hơn 4")
    private Double gpa;

    public StudentRequest() {}

    public String getFullName() {
        return fullName;
    }

    public String getEmail(){
        return email;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }
}