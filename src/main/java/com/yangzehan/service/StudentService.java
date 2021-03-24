package com.yangzehan.service;

import com.yangzehan.domaim.Student;

import java.util.List;

public interface StudentService {
    int add(Student student);
    List<Student>find();
}
