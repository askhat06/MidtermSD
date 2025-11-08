package com.example.university.controller;

import com.example.university.dto.CourseDto;
import com.example.university.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

    private final CourseService service;

    @GetMapping
    public List<CourseDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CourseDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public CourseDto create(@RequestBody CourseDto dto) {
        return service.create(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public CourseDto update(@PathVariable Long id, @RequestBody CourseDto dto) {
        return service.update(id, dto);
    }

}