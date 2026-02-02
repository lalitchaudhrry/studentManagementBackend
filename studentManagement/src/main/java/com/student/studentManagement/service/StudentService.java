package com.student.studentManagement.service;

import com.student.studentManagement.model.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentByAdmissionNo(String admissionNo);

    void deleteStudentById(Long id);
}
