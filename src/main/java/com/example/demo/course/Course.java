package com.example.demo.course;

import com.example.demo.common.BaseEntity;
import com.example.demo.student.Student;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Course extends BaseEntity {
    public Course() {
    }

    @NotBlank
    private String name;

    @NotBlank
    private LocalDate startDate;

    @NotBlank
    private LocalDate endDate;

    @OneToMany
    private List<Student> students;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
