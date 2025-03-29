package com.k21cnt.dxt.lesson04.service;

import com.k21cnt.dxt.lesson04.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {
    List<Student> students = new ArrayList<Student>();
    public StudentService(){
        students.addAll(Arrays.asList(new Student(1L,"Devmaster 1",20,"Non","Số 25 VNP","0978611889","chungtrinhj@gmail.com"),new Student(2L,"Devmaster 2",25,"Non","Số 25 VNP","0978611889","chun@gmail.com"),new Student(3L,"Devmaster 3",22,"Non","Số 25 VNP","0978611889","chuinhj@gmail.com")));
    }
    public List<Student> getStudents(){
        return students;
    }
    public Student getStudent (Long id){
        return students.stream().filter(student -> student.getId().equals(id)).findFirst().orElse(null);
    }
    public Student addStudent (Student student){
        students.add(student);
        return student;
    }
    public Student updateStudent (Long id, Student student){
        Student check = getStudent(id);
        if (check == null){
            return null;
        }
        students.forEach(item -> {
            if (item.getId() == id){
                item.setName(student.getName());
                item.setAddress(student.getAddress());
                item.setEmail(student.getEmail());
                item.setPhone(student.getPhone());
                item.setAge(student.getAge());
                item.setGender(student.getGender());

            }
        });
        return check; // ✅ Trả về đối tượng đã được cập nhật trong danh sách
    }
    public boolean deleteStudent (Long id){
        Student check = getStudent(id);
        return students.remove(check);
    }
}
