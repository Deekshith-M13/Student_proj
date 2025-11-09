package com.student_proj.student_proj.Repository;

import com.student_proj.student_proj.Entity.studentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepository extends JpaRepository<studentEntity, Integer> {

}
