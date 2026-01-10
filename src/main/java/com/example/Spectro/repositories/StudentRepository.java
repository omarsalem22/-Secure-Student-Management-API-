package com.example.Spectro.repositories;

import com.example.Spectro.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Student,Long> {

}
