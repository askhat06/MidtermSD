package com.example.university.service;

import com.example.university.dto.CourseDto;
import java.util.List;

public interface CourseService {
    List<CourseDto> getAll();
    CourseDto getById(Long id);
    CourseDto create(CourseDto dto);
    void delete(Long id);
    CourseDto update(Long id, CourseDto dto);

}