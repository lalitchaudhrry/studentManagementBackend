package com.student.studentManagement.controller;

import com.student.studentManagement.model.Student;
import com.student.studentManagement.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")

public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // 1️⃣ Add Student
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student savedStudent = studentService.addStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    // 2️⃣ Get All Students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    // 3️⃣ Get Student by Admission No
    @GetMapping("/{admissionNo}")
    public ResponseEntity<Student> getStudentByAdmissionNo(@PathVariable String admissionNo) {
        return ResponseEntity.ok(
                studentService.getStudentByAdmissionNo(admissionNo)
        );
    }

    // 4️⃣ Delete Student by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.ok("Student deleted successfully");
    }
}
