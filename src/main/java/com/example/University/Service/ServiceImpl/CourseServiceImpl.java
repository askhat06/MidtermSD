package com.example.University.Service.ServiceImpl;

import com.example.University.Service.CourseService;
import com.example.University.model.Course;
import com.example.University.repository.CourseRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
public class CourseServiceImpl implements CourseService{
    private final CourseRepository courseRep;

    @Override
    public List<Course> getAll() {
        return List.of();
    }

    public Course getById(Long id){
        courseRep.findById(id);
        return null;
    }

    public Course create (Course course){
        return courseRep.save(course);
    }

    @Override
    public void delete(Long id) {
        courseRep.deleteById(id);
    }

    public void update(Course course, Long Id){


    }
}
