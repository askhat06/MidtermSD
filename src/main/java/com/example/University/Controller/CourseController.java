package com.example.University.Controller;

import com.example.University.Service.CourseService;
import com.example.University.model.Course;
import com.example.University.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@AllArgsConstructor
public class CourseController {

    private final CourseService service;

    @GetMapping
    public List<Course> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Course create(@RequestBody Course course) {
        return service.create(course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
