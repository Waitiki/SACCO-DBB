package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository StudentRepository;

    @Autowired
    public StudentService(com.example.demo.student.StudentRepository studentRepository) {
        StudentRepository = studentRepository;
    }

    public List<Student> getStudent()
    {
        return StudentRepository.findAll();
    }

    public void addNewStudent(Student student)
    {
        Optional<Student> studentOptional = StudentRepository
                .findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent())
        {
            throw new IllegalStateException("email taken");
        }
        StudentRepository.save(student);
    }

    public void deleteStudent(Long studentId)
    {
        boolean exists = StudentRepository.existsById(studentId);
        if (!exists)
        {
            throw new IllegalStateException("student with id " + studentId + " does not exists");
        }
        StudentRepository.deleteById(studentId);

    }

    @Transactional
    public void updateStudent(Long studentId,
                              String name,
                              String email) {
        Student student = StudentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + studentId + " does not exists")
        );
                if(name != null &&
                name.length() > 0 &&
                !Objects.equals(student.getName(), name)){
                    student.setName(name);
        }

                if(email != null &&
                email.length() > 0 &&
                !Objects.equals(student.getEmail(), name)){
            Optional<Student> studentOptional = StudentRepository
                    .findStudentByEmail(email);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("Email taken");
            }
            student.setEmail(email);
        }




    }
}
