package com.example.university.mapper;

import com.example.university.dto.CourseDto;
import com.example.university.model.Course;
import com.example.university.model.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseMapper {

    public CourseDto toDto(Course course) {
        CourseDto dto = new CourseDto();
        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setInstructor(course.getInstructor());

        if (course.getStudents() != null) {
            List<Long> ids = new ArrayList<>();
            for (Student s : course.getStudents()) {
                ids.add(s.getId());
            }
            dto.setStudentIds(ids);
        }

        return dto;
    }

    public Course toEntity(CourseDto dto) {
        Course c = new Course();
        c.setId(dto.getId());
        c.setTitle(dto.getTitle());
        c.setInstructor(dto.getInstructor());
        return c;
    }
}
