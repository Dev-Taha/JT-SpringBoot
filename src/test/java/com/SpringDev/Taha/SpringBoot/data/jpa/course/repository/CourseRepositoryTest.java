package com.SpringDev.Taha.SpringBoot.data.jpa.course.repository;

import com.SpringDev.Taha.SpringBoot.data.jpa.course.entity.Course;
import com.SpringDev.Taha.SpringBoot.data.jpa.course.entity.Student;
import com.SpringDev.Taha.SpringBoot.data.jpa.course.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;


    @Test
    public void printCourses(){
        List<Course> courses =
                courseRepository.findAll();
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher
                .builder()
                .firstName("Tamer")
                .lastName("Abo Ras")
                .build();

        Course course = Course
                .builder()
                .title("python")
                .credits(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords =
                (Pageable) PageRequest.of(0,3);

        Pageable secondPageWithThreeRecords =
                (Pageable) PageRequest.of(1,2);

        List<Course> courses =
                courseRepository.findAll((Sort) firstPageWithThreeRecords);

        Long totalElements =
                courseRepository.findAll((Sort) firstPageWithThreeRecords).stream().count();

//        Long totalPages =
//                courseRepository.findAll((Sort) firstPageWithThreeRecords).getTotalPages();

        System.out.println("totalElements = " + totalElements);

        System.out.println("courses = " + courses);
    }
    @Test
    public void findAllSorting(){
        Pageable sortByTitle =
                (Pageable) PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                );
        Pageable sortByCreditDes =
                (Pageable) PageRequest.of(
                        0,
                        2,
                        Sort.by("credit").descending()
                );
        Pageable sortByCreditAndTitle =
                (Pageable) PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                                .descending()
                                .and(Sort.by("credit"))
                );
        List<Course> courses =
                courseRepository.findAll((Sort) sortByTitle);

        System.out.println("courses = " + courses);
    }

    @Test
    public void printfindByTitleContaing(){
        Pageable firstPageTenRecords =
                (Pageable) PageRequest.of(0,10);
        List<Course> courses =
                courseRepository.findByTitleContaining(
                        "D"
                        ,firstPageTenRecords).getContent();

        System.out.println("courses = " + courses);
    }
    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher
                .builder()
                .firstName("Taha")
                .lastName("Ahmed")
                .build();

        Student student = Student
                .builder()
                .firstName("Omar")
                .lastName("Ali")
                .emailId("am12ali@gamil.com")
                .build();

        Course course = Course
                .builder()
                .title("AIE")
                .credits(12)
                .teacher(teacher)
                .build();
        course.addStudents(student);

        courseRepository.save(course);

    }
}