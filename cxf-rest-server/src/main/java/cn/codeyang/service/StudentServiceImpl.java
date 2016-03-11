package cn.codeyang.service;

import cn.codeyang.domain.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author YangZhongYang
 */
public class StudentServiceImpl implements StudentService {
    public Student query(long id) {
        Student student = new Student();
        student.setId(110);
        student.setName("zhangsan");
        student.setBirthday(new Date());
        return student;
    }

    public List<Student> queryList(String name) {
        Student student1 = new Student();
        student1.setId(110);
        student1.setName("zhangsan");
        student1.setBirthday(new Date());

        Student student2 = new Student();
        student2.setId(111);
        student2.setName("lisi");
        student2.setBirthday(new Date());

        List<Student> stuList = new ArrayList<Student>();
        stuList.add(student1);
        stuList.add(student2);
        return stuList;
    }
}
