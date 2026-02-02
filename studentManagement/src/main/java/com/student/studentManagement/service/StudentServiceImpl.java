package com.student.studentManagement.service;

import com.student.studentManagement.model.Student;
import com.student.studentManagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentByAdmissionNo(String admissionNo) {
        return studentRepository.findByAdmissionNo(admissionNo)
                .orElseThrow(() ->
                        new RuntimeException("Student not found with admission no: " + admissionNo)
                );
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
