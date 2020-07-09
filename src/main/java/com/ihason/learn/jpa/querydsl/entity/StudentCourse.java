package com.ihason.learn.jpa.querydsl.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student_course_relation")
@Data
public class StudentCourse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer studentId;

    private Integer courseId;

}
