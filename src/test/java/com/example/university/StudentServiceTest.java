package com.example.university;

import com.example.university.dto.StudentDto;
import com.example.university.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    void getAllStudentService(){

        List<StudentDto> list = studentService.getAll();

        Assertions.assertNotNull(list);

        Assertions.assertNotEquals(0, list.size());

        for (int i = 0; i < list.size(); i++) {
            StudentDto dto = list.get(i);

            Assertions.assertNotNull(dto);

            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getFullName());
            Assertions.assertNotNull(dto.getAge());
        }
    }

    @Test
    void getByIdStudentTest(){
        Random random = new Random();

        int randomIndex = random.nextInt(studentService.getAll().size());

        Long someId = studentService.getAll().get(randomIndex).getId();

        StudentDto dto = studentService.getById(someId);

        Assertions.assertNotNull(dto);

        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getFullName());
        Assertions.assertNotNull(dto.getAge());

        StudentDto testNull = studentService.getById(-1L);
        Assertions.assertNull(testNull);
    }

    @Test
    void addStudentTest(){

        StudentDto dto = new StudentDto();
        dto.setFullName("Test Student");
        dto.setAge(22);

        StudentDto created = studentService.create(dto);

        Assertions.assertNotNull(created);

        Assertions.assertNotNull(created.getId());
        Assertions.assertNotNull(created.getFullName());
        Assertions.assertNotNull(created.getAge());

        Assertions.assertEquals(dto.getFullName(), created.getFullName());
        Assertions.assertEquals(dto.getAge(), created.getAge());

        StudentDto check = studentService.getById(created.getId());

        Assertions.assertNotNull(check);

        Assertions.assertNotNull(check.getId());
        Assertions.assertNotNull(check.getFullName());
        Assertions.assertNotNull(check.getAge());

        Assertions.assertEquals(created.getId(), check.getId());
        Assertions.assertEquals(created.getFullName(), check.getFullName());
        Assertions.assertEquals(created.getAge(), check.getAge());
    }

    @Test
    void updateStudentTest(){
        Random random = new Random();

        int randomIndex = random.nextInt(studentService.getAll().size());

        Long someId = studentService.getAll().get(randomIndex).getId();

        StudentDto dto = new StudentDto();
        dto.setFullName("Updated Name");
        dto.setAge(99);

        StudentDto updated = studentService.update(someId, dto);

        Assertions.assertNotNull(updated);

        Assertions.assertNotNull(updated.getId());
        Assertions.assertNotNull(updated.getFullName());
        Assertions.assertNotNull(updated.getAge());

        Assertions.assertEquals(dto.getFullName(), updated.getFullName());
        Assertions.assertEquals(dto.getAge(), updated.getAge());

        StudentDto check = studentService.getById(someId);

        Assertions.assertNotNull(check);

        Assertions.assertNotNull(check.getId());
        Assertions.assertNotNull(check.getFullName());
        Assertions.assertNotNull(check.getAge());

        Assertions.assertEquals(updated.getId(), check.getId());
        Assertions.assertEquals(updated.getFullName(), check.getFullName());
        Assertions.assertEquals(updated.getAge(), check.getAge());
    }

    @Test
    void deleteStudentTest(){
        Random random = new Random();
        int randomIndex = random.nextInt(studentService.getAll().size());

        Long someId = studentService.getAll().get(randomIndex).getId();

        studentService.delete(someId);

        StudentDto dto = studentService.getById(someId);


        Assertions.assertNull(dto);
    }
}
