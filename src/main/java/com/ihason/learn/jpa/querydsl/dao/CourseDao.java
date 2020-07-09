package com.ihason.learn.jpa.querydsl.dao;

import com.ihason.learn.jpa.querydsl.entity.Course;
import com.ihason.learn.jpa.querydsl.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CourseDao extends JpaRepository<Course, Integer>, JpaSpecificationExecutor<Course> {
}
