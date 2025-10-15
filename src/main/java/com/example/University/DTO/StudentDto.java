package com.example.University.DTO;

import com.example.University.model.Student;
import com.example.University.model.Course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentDto {
    private Long id;
    private String fullName;
    private int Age;
    private Long course_id;
}
