package com.example.demo.student;

import com.example.demo.common.CrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController extends CrudController<Student> {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        super(studentService);
        this.studentService = studentService;
    }
}
