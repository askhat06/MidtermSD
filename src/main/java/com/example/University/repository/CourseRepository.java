package com.example.University.repository;

import com.example.University.model.Course;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CourseRepository extends JpaRepository <Course, Long>{
}
