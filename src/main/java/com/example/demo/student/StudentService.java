package com.example.demo.student;

import com.example.demo.common.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends CrudService<Student> {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        super(studentRepository);
        this.studentRepository = studentRepository;
    }
}
