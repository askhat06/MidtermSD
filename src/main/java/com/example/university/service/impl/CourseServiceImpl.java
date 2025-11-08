package com.example.university.service.impl;

import com.example.university.dto.CourseDto;
import com.example.university.mapper.CourseMapper;
import com.example.university.model.Course;
import com.example.university.repository.CourseRepository;
import com.example.university.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repo;
    private final CourseMapper mapper;

    @Override
    public List<CourseDto> getAll() {
        List<Course> courses = repo.findAll();
        List<CourseDto> dtos = new ArrayList<>();
        for (Course c : courses) {
            dtos.add(mapper.toDto(c));
        }
        return dtos;
    }

    @Override
    public CourseDto getById(Long id) {
        Course c = repo.findById(id).orElse(null);
        if (c == null) return null;
        return mapper.toDto(c);
    }

    @Override
    public CourseDto create(CourseDto dto) {
        Course course = mapper.toEntity(dto);
        Course saved = repo.save(course);
        return mapper.toDto(saved);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
    @Override
    public CourseDto update(Long id, CourseDto dto) {
        Course course = repo.findById(id).orElse(null);
        if (course == null) return null;

        course.setTitle(dto.getTitle());
        course.setInstructor(dto.getInstructor());

        Course saved = repo.save(course);
        return mapper.toDto(saved);
    }

}
