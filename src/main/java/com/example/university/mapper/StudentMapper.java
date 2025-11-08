package com.example.university.mapper;

import com.example.university.dto.StudentDto;
import com.example.university.model.Course;
import com.example.university.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentDto toDto(Student s) {
        StudentDto dto = new StudentDto();
        dto.setId(s.getId());
        dto.setFullName(s.getFullName());
        dto.setAge(s.getAge());

        if (s.getCourse() != null) {
            dto.setCourseId(s.getCourse().getId());
        }

        return dto;
    }

    public Student toEntity(StudentDto dto, Course course) {
        Student s = new Student();
        s.setId(dto.getId());
        s.setFullName(dto.getFullName());
        s.setAge(dto.getAge());
        s.setCourse(course);
        return s;
    }
}
