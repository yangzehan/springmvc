package com.yangzehan.dao;

import com.yangzehan.domaim.Student;

import java.util.List;

public interface Studentdao {
    int insert(Student student);
    List<Student>select();
}
