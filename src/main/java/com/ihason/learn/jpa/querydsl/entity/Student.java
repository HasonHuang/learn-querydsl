package com.ihason.learn.jpa.querydsl.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student")
@Data
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @Column(name = "class_id", insertable=false, updatable=false)
    private Integer classId;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private Classes classes;
}
