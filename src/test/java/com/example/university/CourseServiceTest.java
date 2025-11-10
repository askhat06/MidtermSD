package com.example.university;

import com.example.university.dto.CourseDto;
import com.example.university.service.CourseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class CourseServiceTest {

    @Autowired
    private CourseService courseService;

    @Test
    void getAllCourseService(){

        List<CourseDto> list = courseService.getAll();

        Assertions.assertNotNull(list);

        Assertions.assertNotEquals(0, list.size());

        for (int i = 0; i < list.size(); i++) {
            CourseDto dto = list.get(i);

            Assertions.assertNotNull(dto);

            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getTitle());
            Assertions.assertNotNull(dto.getInstructor());
        }
    }

    @Test
    void getByIdCourseTest(){
        Random random = new Random();

        int randomIndex = random.nextInt(courseService.getAll().size());

        Long someId = courseService.getAll().get(randomIndex).getId();

        CourseDto dto = courseService.getById(someId);

        Assertions.assertNotNull(dto);

        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getTitle());
        Assertions.assertNotNull(dto.getInstructor());

        CourseDto testNull = courseService.getById(-1L);
        Assertions.assertNull(testNull);
    }

    @Test
    void addCourseTest(){

        CourseDto dto = new CourseDto();
        dto.setTitle("New Course");
        dto.setInstructor("New Instructor");

        CourseDto created = courseService.create(dto);

        Assertions.assertNotNull(created);

        Assertions.assertNotNull(created.getId());
        Assertions.assertNotNull(created.getTitle());
        Assertions.assertNotNull(created.getInstructor());

        Assertions.assertEquals(dto.getTitle(), created.getTitle());
        Assertions.assertEquals(dto.getInstructor(), created.getInstructor());

        CourseDto check = courseService.getById(created.getId());

        Assertions.assertNotNull(check);

        Assertions.assertNotNull(check.getId());
        Assertions.assertNotNull(check.getTitle());
        Assertions.assertNotNull(check.getInstructor());

        Assertions.assertEquals(created.getId(), check.getId());
        Assertions.assertEquals(created.getTitle(), check.getTitle());
        Assertions.assertEquals(created.getInstructor(), check.getInstructor());
    }

    @Test
    void updateCourseTest(){
        Random random = new Random();

        int randomIndex = random.nextInt(courseService.getAll().size());

        Long someId = courseService.getAll().get(randomIndex).getId();

        CourseDto dto = new CourseDto();
        dto.setTitle("Updated");
        dto.setInstructor("UpdatedInstructor");

        CourseDto updated = courseService.update(someId, dto);

        Assertions.assertNotNull(updated);

        Assertions.assertNotNull(updated.getId());
        Assertions.assertNotNull(updated.getTitle());
        Assertions.assertNotNull(updated.getInstructor());

        Assertions.assertEquals(dto.getTitle(), updated.getTitle());
        Assertions.assertEquals(dto.getInstructor(), updated.getInstructor());

        CourseDto check = courseService.getById(someId);

        Assertions.assertNotNull(check);

        Assertions.assertNotNull(check.getId());
        Assertions.assertNotNull(check.getTitle());
        Assertions.assertNotNull(check.getInstructor());

        Assertions.assertEquals(updated.getId(), check.getId());
        Assertions.assertEquals(updated.getTitle(), check.getTitle());
        Assertions.assertEquals(updated.getInstructor(), check.getInstructor());
    }

    @Test
    void deleteCourseTest(){
        Random random = new Random();
        int randomIndex = random.nextInt(courseService.getAll().size());

        Long someId = courseService.getAll().get(randomIndex).getId();

        courseService.delete(someId);

        CourseDto dto = courseService.getById(someId); // должно быть null
        Assertions.assertNull(dto);
    }

}
