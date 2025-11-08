package com.example.university.service.impl;

import com.example.university.dto.StudentDto;
import com.example.university.mapper.StudentMapper;
import com.example.university.model.Course;
import com.example.university.model.Student;
import com.example.university.repository.CourseRepository;
import com.example.university.repository.StudentRepository;
import com.example.university.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;
    private final StudentMapper mapper;

    @Override
    public List<StudentDto> getAll() {
        List<Student> students = studentRepo.findAll();
        List<StudentDto> dtos = new ArrayList<>();
        for (Student s : students) {
            dtos.add(mapper.toDto(s));
        }
        return dtos;
    }

    @Override
    public StudentDto getById(Long id) {
        Student s = studentRepo.findById(id).orElse(null);
        if (s == null) return null;
        return mapper.toDto(s);
    }

    @Override
    public StudentDto create(StudentDto dto) {
        Course course = null;
        if (dto.getCourseId() != null) {
            course = courseRepo.findById(dto.getCourseId()).orElse(null);
        }
        Student s = mapper.toEntity(dto, course);
        Student saved = studentRepo.save(s);
        return mapper.toDto(saved);
    }

    @Override
    public void delete(Long id) {
        studentRepo.deleteById(id);
    }

    @Override
    public StudentDto update(Long id, StudentDto dto) {
        Student s = studentRepo.findById(id).orElse(null);
        if (s == null) return null;

        s.setFullName(dto.getFullName());
        s.setAge(dto.getAge());

        if (dto.getCourseId() != null) {
            Course c = courseRepo.findById(dto.getCourseId()).orElse(null);
            s.setCourse(c);
        }

        Student saved = studentRepo.save(s);
        return mapper.toDto(saved);
    }

}
