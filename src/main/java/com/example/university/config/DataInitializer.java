package com.example.university.config;

import com.example.university.model.Course;
import com.example.university.model.Student;
import com.example.university.repository.CourseRepository;
import com.example.university.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner seedDatabase(CourseRepository courseRepository, StudentRepository studentRepository) {
        return args -> {
            if (courseRepository.count() > 0 || studentRepository.count() > 0) {
                return;
            }

            Course javaCourse = new Course();
            javaCourse.setTitle("Java Backend");
            javaCourse.setInstructor("Askhat Akylbek");
            courseRepository.save(javaCourse);

            Course springCourse = new Course();
            springCourse.setTitle("Spring Boot");
            springCourse.setInstructor("Instructor X");
            courseRepository.save(springCourse);

            Course algorithmsCourse = new Course();
            algorithmsCourse.setTitle("Algorithms and Data Structures");
            algorithmsCourse.setInstructor("Some Instr");
            courseRepository.save(algorithmsCourse);

            Student john = new Student();
            john.setFullName("John Doe");
            john.setAge(20);
            john.setCourse(javaCourse);

            Student jane = new Student();
            jane.setFullName("Jane Roe");
            jane.setAge(21);
            jane.setCourse(javaCourse);

            Student dias = new Student();
            dias.setFullName("Kuspan Dias");
            dias.setAge(20);
            dias.setCourse(algorithmsCourse);

            studentRepository.saveAll(List.of(john, jane, dias));
        };
    }
}
