package com.example.University.Service;

import com.example.University.model.Course;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface CourseService {
    List<Course> getAll();
    Course create(Course course);
    void delete(Long id);
    void update(Course course, Long id);
    Course getById(Long id);
}
