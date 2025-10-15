package com.example.University.DTO;

import com.example.University.model.Course;
import com.example.University.model.Student;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourseDto {
    private Long id;
    private String title;
    private String instructor;
    private List<Long> studentIds;
}
