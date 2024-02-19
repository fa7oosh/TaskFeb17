package net.febWork.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.febWork.springboot.model.Student;

@Repository
public interface TeacherRepository extends JpaRepository<Student, Long> {

}
