package com.SpringDev.Taha.SpringBoot.data.jpa.course.repository;

import com.SpringDev.Taha.SpringBoot.data.jpa.course.entity.Course;
import com.SpringDev.Taha.SpringBoot.data.jpa.course.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void SaveCourseMaterial(){
        Course course =
                Course.builder()
                        .credits(20)
                        .title(".net")
                        .build();

        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("google.com")
                        .course(course)
                        .build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourses(){
        List<CourseMaterial> course =
                courseMaterialRepository.findAll();
        System.out.println("course = " + course);
    }
}