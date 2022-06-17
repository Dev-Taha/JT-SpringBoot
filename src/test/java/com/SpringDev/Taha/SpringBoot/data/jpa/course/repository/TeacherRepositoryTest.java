package com.SpringDev.Taha.SpringBoot.data.jpa.course.repository;

import com.SpringDev.Taha.SpringBoot.data.jpa.course.entity.Course;
import com.SpringDev.Taha.SpringBoot.data.jpa.course.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

        Course courseWeb = Course.builder()
                .title("Web Programing")
                .credits(5)
                .build();

        Course courseJava = Course.builder()
                .title("Spring Boot")
                .credits(9)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Ohaqq")
                .lastName("SHam")
//                .courses(List.of(courseWeb,courseJava))
                .build();

        teacherRepository.save(teacher);
    }
}