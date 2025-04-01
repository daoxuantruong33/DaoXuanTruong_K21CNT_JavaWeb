package com.k21cnt.dxt.lesson09.repository;
import com.k21cnt.dxt.lesson09.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
}
