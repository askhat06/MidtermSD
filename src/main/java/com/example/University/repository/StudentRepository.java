package com.example.University.repository;

import com.example.University.model.Student;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository <Student, Long> {
    Optional<Student> findById();
}
