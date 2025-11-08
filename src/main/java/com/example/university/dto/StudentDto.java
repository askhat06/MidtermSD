package com.example.university.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private Long id;
    private String fullName;
    private int age;
    private Long courseId;
}
