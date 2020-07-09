package com.ihason.learn.jpa.querydsl.dao;

import com.ihason.learn.jpa.querydsl.entity.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentCourseDao extends JpaRepository<StudentCourse, Integer>, JpaSpecificationExecutor<StudentCourse> {
}
