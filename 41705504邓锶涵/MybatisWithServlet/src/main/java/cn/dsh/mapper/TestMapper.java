package cn.dsh.mapper;

import cn.dsh.domain.Student;

import java.util.List;

public interface TestMapper {

    /*查询所有*/
    List<Student> findAll();

    /*根据id删除一条数据*/
    void deleteById(Integer id);

    /*插入一条数据*/
    void insertOne(Student student);

    /*通过id查询*/
    Student findById(Integer id);

    /*更改信息*/
    void updateStu(Student student);

    /*根据条件查询*/
    List<Student> findSomeByConditions(Student student);
}
