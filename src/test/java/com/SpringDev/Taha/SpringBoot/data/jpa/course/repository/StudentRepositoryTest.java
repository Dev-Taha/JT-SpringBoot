package com.SpringDev.Taha.SpringBoot.data.jpa.course.repository;

import com.SpringDev.Taha.SpringBoot.data.jpa.course.entity.Guardian;
import com.SpringDev.Taha.SpringBoot.data.jpa.course.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("taha@gamil.com")
                .firstName("Taha")
                .lastName("Y.Shorafa")
                //.guardianName("Ahmed")
                //.guardianEmail("Ahmed@gamil.com")
                //.guardianMobile("0599411845")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .email("Ahmed@gamil.com")
                .name("Ahmed")
                .mobile("958559894")
                .build();

        Student student = Student.builder()
                .firstName("Ahmed")
                .lastName("Shen")
                .emailId("ahmadSh@gamil.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList =
                studentRepository.findAll();

        System.out.println("student List : "+ studentList);
    }

    @Test
    public void findByFirstName(){
        List<Student> student =
                studentRepository.findByFirstName("ahmed");
        System.out.println("student = " + student);
    }

    @Test
    public void findByFirstNameContaining(){
        List<Student> student =
                studentRepository.findByFirstNameContaining("Ah");
        System.out.println("students = " + student);
    }

    @Test
    public void findByGuardianName(){
        List<Student> students =
                studentRepository.findByGuardianName("Ahmed");
        System.out.println("students = " + students);
    }

    @Test
    public void findByFirstNameAndLastName(){
        Student student = studentRepository.findByFirstNameAndLastName("Osama"
                ,"Alaa");
        System.out.println("student = " + student);
    }

    @Test
    public void printgetStudentByEmailAddress(){
        Student student =
                studentRepository.getStudentByEmailAddress(
                        "ahmad@gamil.com"
                );
        System.out.println("student = " + student);
    }

    @Test
    public void printgetStudentFirstNameByEmailAddress(){
        String firstName =
                studentRepository.getStudentFirstNameByEmailAddress(
                        "taha@gamil.com"
                );
        System.out.println("firstName = " + firstName);
    }

    @Test
    public void getStudentByEmailAddressNative(){
        Student student =
                studentRepository.getStudentByEmailAddressNative(
                        "taha@gamil.com"
                );
        System.out.println("student = " + student);
    }

    @Test
    public void getStudentByEmailAddressNamedParam(){
        Student student =
                studentRepository.getStudentByEmailAddressNative(
                        "ahmed@gamil.com"
                );
        System.out.println("student = " + student);
    }

    @Test
    public void getupdateStudentNameByEmailId(){
        studentRepository.updateStudentNameByEmailId(
                "Taha Ahmed",
                "ahmed@gamil.com");
    }
}