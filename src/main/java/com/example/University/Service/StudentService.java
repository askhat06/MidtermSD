package com.example.University.Service;

import com.example.University.model.Student;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface StudentService {
    List<Student> getAll();
    Student getById(Long id);
    Student create(Student student);
    void delete(Long id);
    void update(Student student, Long id);
}
