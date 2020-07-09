package com.ihason.lean.jpa.query.test.dao;

import com.ihason.learn.jpa.querydsl.QueryDslApplication;
import com.ihason.learn.jpa.querydsl.dao.StudentDao;
import com.ihason.learn.jpa.querydsl.entity.QClasses;
import com.ihason.learn.jpa.querydsl.entity.QStudent;
import com.ihason.learn.jpa.querydsl.entity.Student;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = QueryDslApplication.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentDaoTest {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private EntityManager entityManager;

    /** QueryDSL 查询工厂 */
    private JPAQueryFactory queryFactory;

    @Before
    public void setup() {
        queryFactory = new JPAQueryFactory(entityManager);
    }

    @Test
    public void findAll() {
        List<Student> students = studentDao.findAll();
    }

    @Test
    public void dslFindByProperty() {
        QStudent student = QStudent.student;
        Student fromDB = queryFactory.selectFrom(student).where(student.id.eq(1)).fetchOne();
        assertThat(fromDB).isNotNull();
    }

    @Test
    public void dslJoin() {
        QStudent student = QStudent.student;
        QClasses classes = QClasses.classes;
        List<Student> lists = queryFactory.select(
                Projections.bean(Student.class, student.id, student.classId, student.name)
                )
                .from(student, classes)
                .leftJoin(student.classes, classes)
//                .where(student.classId.eq(classes.id))
                .where(classes.id.eq(1))
                .fetch();

        assertThat(lists).isNotEmpty();
    }

}
