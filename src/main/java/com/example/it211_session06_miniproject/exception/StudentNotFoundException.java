package com.example.it211_session06_miniproject.exception;

public class StudentNotFoundException extends RuntimeException {
    private final Long studentId;

    public StudentNotFoundException(Long studentId) {
        super("Không tìm thấy sinh viên với ID: " + studentId);
        this.studentId = studentId;
    }

    public Long getStudentId() { return studentId; }
}