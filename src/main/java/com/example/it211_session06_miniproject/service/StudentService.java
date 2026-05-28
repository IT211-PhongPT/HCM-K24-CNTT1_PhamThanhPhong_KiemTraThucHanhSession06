package com.example.it211_session06_miniproject.service;

import com.example.it211_session06_miniproject.dto.request.*;
import com.example.it211_session06_miniproject.dto.response.StudentResponse;
import com.example.it211_session06_miniproject.entity.Student;
import com.example.it211_session06_miniproject.exception.StudentNotFoundException;
import com.example.it211_session06_miniproject.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(StudentResponse::fromEntity)
                .collect(Collectors.toList());
    }

    public StudentResponse getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
        return StudentResponse.fromEntity(student);
    }

    public StudentResponse createStudent(StudentRequest request) {
        Student student = new Student(
                request.getFullName(),
                request.getEmail(),
                request.getGpa()
        );
        return StudentResponse.fromEntity(studentRepository.save(student));
    }

    public StudentResponse updateStudent(Long id, StudentRequest request) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));

        student.setFullName(request.getFullName());
        student.setEmail(request.getEmail());
        student.setGpa(request.getGpa());

        return StudentResponse.fromEntity(studentRepository.save(student));
    }

    public StudentResponse patchStudent(Long id, StudentPatchRequest request) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));

        if (request.getFullName() != null) student.setFullName(request.getFullName());
        if (request.getEmail()    != null) student.setEmail(request.getEmail());
        if (request.getGpa()      != null) student.setGpa(request.getGpa());

        return StudentResponse.fromEntity(studentRepository.save(student));
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException(id);
        }
        studentRepository.deleteById(id);
    }
}