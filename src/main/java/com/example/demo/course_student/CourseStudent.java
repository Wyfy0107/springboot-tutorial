package com.example.demo.course_student;

import com.example.demo.course.Course;
import com.example.demo.student.Student;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table
public class CourseStudent {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @ManyToOne
    @JoinColumn
    private Course course;

    @ManyToOne
    @JoinColumn
    private Student student;
}
