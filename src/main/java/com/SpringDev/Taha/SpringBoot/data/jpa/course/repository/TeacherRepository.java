package com.SpringDev.Taha.SpringBoot.data.jpa.course.repository;

import com.SpringDev.Taha.SpringBoot.data.jpa.course.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {

}
