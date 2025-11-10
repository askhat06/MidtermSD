package com.example.university;

import com.example.university.dto.StudentDto;
import com.example.university.mapper.StudentMapper;
import com.example.university.model.Course;
import com.example.university.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    void convertEntityToDtoTest(){

        Course course = new Course();
        course.setId(100L);
        course.setTitle("Algorithms and Data Str.");
        course.setInstructor("Some Instr");

        Student entity = new Student(1L, "Kuspan Dias", 20, course);

        StudentDto dto = studentMapper.toDto(entity);

        Assertions.assertNotNull(dto);

        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getFullName());
        Assertions.assertNotNull(dto.getAge());

        Assertions.assertEquals(entity.getId(), dto.getId());
        Assertions.assertEquals(entity.getFullName(), dto.getFullName());
        Assertions.assertEquals(entity.getAge(), dto.getAge());
        Assertions.assertEquals(entity.getCourse().getId(), dto.getCourseId());
    }

    @Test
    void convertDtoToEntityTest(){

        Course course = new Course();
        course.setId(200L);

        StudentDto dto = new StudentDto(2L, "Zhumabai Anas", 21, 200L);

        Student entity = studentMapper.toEntity(dto, course);

        Assertions.assertNotNull(entity);

        Assertions.assertNotNull(entity.getId());
        Assertions.assertNotNull(entity.getFullName());
        Assertions.assertNotNull(entity.getAge());
        Assertions.assertNotNull(entity.getCourse());

        Assertions.assertEquals(dto.getId(), entity.getId());
        Assertions.assertEquals(dto.getFullName(), entity.getFullName());
        Assertions.assertEquals(dto.getAge(), entity.getAge());
        Assertions.assertEquals(dto.getCourseId(), entity.getCourse().getId());
    }

    @Test
    void convertListEntityStudentToListDtoStudentTest(){

        // part 1
        List<Student> entityList = new ArrayList<>();

        Student s1 = new Student();
        s1.setId(1L);
        s1.setFullName("S1");
        s1.setAge(18);

        Student s2 = new Student();
        s2.setId(2L);
        s2.setFullName("S2");
        s2.setAge(19);

        Student s3 = new Student();
        s3.setId(3L);
        s3.setFullName("S3");
        s3.setAge(20);

        entityList.add(s1);
        entityList.add(s2);
        entityList.add(s3);

        List<StudentDto> dtoList = studentMapper.toDtoList(entityList);

        // part 2
        Assertions.assertNotNull(dtoList);

        // part 3
        Assertions.assertNotEquals(0, dtoList.size());

        // part 4
        Assertions.assertEquals(entityList.size(), dtoList.size());

        // part 5
        for (int i = 0; i < entityList.size(); i++) {
            Student entity = entityList.get(i);
            StudentDto dto = studentMapper.toDto(entity);

            Assertions.assertNotNull(dto);

            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getFullName());
            Assertions.assertNotNull(dto.getAge());
        }
    }
}