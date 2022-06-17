package com.SpringDev.Taha.SpringBoot.data.jpa.course.repository;

import com.SpringDev.Taha.SpringBoot.data.jpa.course.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
     List<Student> findByFirstName(String firsName);
     List<Student> findByFirstNameContaining(String name);

     List<Student> findByLastNameNotNull(String name);
     List<Student> findByGuardianName(String guardianName);

     Student findByFirstNameAndLastName(String firstName,String lastName);

     //JPQL
     @Query("SELECT s FROM Student s WHERE s.emailId = ?1") //?1 that is mean a first Parameter
     Student getStudentByEmailAddress(String emailId);

     @Query("SELECT s.firstName FROM Student s WHERE s.emailId = ?1") //?1 that is mean a first Parameter
     String getStudentFirstNameByEmailAddress(String emailId);

     @Query(
             value = "select * from tbl_student s where s.email_address = ?1",
             nativeQuery = true
     )
     Student getStudentByEmailAddressNative(String emailId);

     //Native Named Param
     @Query(
             value = "SELECT * FROM tbl_student WHERE s.email_address = :emailId",
             nativeQuery = true
     )
     Student getStudentByEmailAddressNamedParam(
             @Param("emailId") String emailId
     );

     @Modifying
     @Transactional
     @Query(
             value = "UPDATE tbl_student set(first_name = ?1 ) WHERE email_address = ?2",
             nativeQuery = true
     )
     int updateStudentNameByEmailId(String firstName,String emailId);
}
