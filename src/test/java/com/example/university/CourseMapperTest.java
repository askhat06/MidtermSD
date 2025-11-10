package com.example.university;

import com.example.university.dto.CourseDto;
import com.example.university.mapper.CourseMapper;
import com.example.university.model.Course;
import com.example.university.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CourseMapperTest {

    @Autowired
    private CourseMapper courseMapper;

    @Test
    void convertEntityToDtoTest(){

        // entity
        Course course = new Course();
        course.setId(1L);
        course.setTitle("Java Backend");
        course.setInstructor("Askhat Akylbek");

        List<Student> students = new ArrayList<>();
        students.add(new Student(10L, "John Doe", 20, course));
        students.add(new Student(11L, "Jane Roe", 21, course));
        course.setStudents(students);

        // map
        CourseDto dto = courseMapper.toDto(course);

        // asserts
        Assertions.assertNotNull(dto);

        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getTitle());
        Assertions.assertNotNull(dto.getInstructor());
        Assertions.assertNotNull(dto.getStudentIds());

        Assertions.assertEquals(course.getId(), dto.getId());
        Assertions.assertEquals(course.getTitle(), dto.getTitle());
        Assertions.assertEquals(course.getInstructor(), dto.getInstructor());
        Assertions.assertEquals(course.getStudents().size(), dto.getStudentIds().size());
    }

    @Test
    void convertDtoToEntityTest(){

        CourseDto dto = new CourseDto();
        dto.setId(2L);
        dto.setTitle("Spring Boot");
        dto.setInstructor("Instructor X");

        Course entity = courseMapper.toEntity(dto);

        Assertions.assertNotNull(entity);

        Assertions.assertNotNull(entity.getId());
        Assertions.assertNotNull(entity.getTitle());
        Assertions.assertNotNull(entity.getInstructor());

        Assertions.assertEquals(dto.getId(), entity.getId());
        Assertions.assertEquals(dto.getTitle(), entity.getTitle());
        Assertions.assertEquals(dto.getInstructor(), entity.getInstructor());
    }

    @Test
    void convertListEntityCourseToListDtoCourseTest(){

        // part 1
        List<Course> entityList = new ArrayList<>();

        Course c1 = new Course();
        c1.setId(1L);
        c1.setTitle("Course A");
        c1.setInstructor("I1");

        Course c2 = new Course();
        c2.setId(2L);
        c2.setTitle("Course B");
        c2.setInstructor("I2");

        Course c3 = new Course();
        c3.setId(3L);
        c3.setTitle("Course C");
        c3.setInstructor("I3");

        entityList.add(c1);
        entityList.add(c2);
        entityList.add(c3);

        List<CourseDto> dtoList = courseMapper.toDtoList(entityList);

        // part 2
        Assertions.assertNotNull(dtoList);

        // part 3
        Assertions.assertNotEquals(0, dtoList.size());

        // part 4
        Assertions.assertEquals(entityList.size(), dtoList.size());

        // part 5
        for (int i = 0; i < entityList.size(); i++) {
            Course entity = entityList.get(i);
            CourseDto dto = courseMapper.toDto(entity);

            Assertions.assertNotNull(dto);

            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getTitle());
            Assertions.assertNotNull(dto.getInstructor());

            Assertions.assertEquals(entity.getId(), dto.getId());
            Assertions.assertEquals(entity.getTitle(), dto.getTitle());
            Assertions.assertEquals(entity.getInstructor(), dto.getInstructor());
        }
    }
}
