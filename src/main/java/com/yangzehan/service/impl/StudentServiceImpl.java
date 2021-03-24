package com.yangzehan.service.impl;

import com.yangzehan.dao.Studentdao;
import com.yangzehan.domaim.Student;
import com.yangzehan.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private Studentdao studentdao;
    @Override
    public int add(Student student) {
        int num=studentdao.insert(student);
        return num;
    }

    @Override
    public List<Student> find() {
        List<Student> list=studentdao.select();
        return list;
    }
}
