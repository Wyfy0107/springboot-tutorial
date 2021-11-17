package com.example.demo.course;

import com.example.demo.common.CrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/course")
public class CourseController extends CrudController<Course> {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        super(courseService);
        this.courseService = courseService;
    }
}
