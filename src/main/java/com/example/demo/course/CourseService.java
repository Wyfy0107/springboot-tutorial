package com.example.demo.course;

import com.example.demo.common.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService extends CrudService<Course> {
    private CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        super(courseRepository);
        this.courseRepository = courseRepository;
    }
}
