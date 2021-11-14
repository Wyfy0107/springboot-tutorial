package com.example.demo.student;

import com.example.demo.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        Optional<Student> existingStudent =
                studentRepository.getByEmail(student.getEmail());

        if (existingStudent.isPresent()) {
            throw new IllegalStateException("Email exist");
        }

        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Long id, Student student) {
        boolean existingStudent = studentRepository.existsById(id);

        if (!existingStudent) {
            throw new IllegalStateException("Student does not exist");
        }

        Student studentToUpdate = studentRepository.getById(id);
        studentToUpdate.setEmail(student.getEmail());
        studentToUpdate.setDob(student.getDob());
        studentToUpdate.setName(student.getName());

        return studentRepository.saveAndFlush(studentToUpdate);
    }

    public Student getOne(Long id) {
        Student foundStudent = studentRepository.findById(id).orElse(null);

        if (foundStudent == null) {
            throw new NotFoundException("Student not found");
        }

        return foundStudent;
    }
}
