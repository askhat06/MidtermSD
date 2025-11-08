package com.example.university.service;

import com.example.university.dto.StudentDto;
import java.util.List;

public interface StudentService {
    List<StudentDto> getAll();
    StudentDto getById(Long id);
    StudentDto create(StudentDto dto);
    void delete(Long id);
    StudentDto update(Long id, StudentDto dto);
}