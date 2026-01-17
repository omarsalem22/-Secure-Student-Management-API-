package com.example.Spectro.repository;

import com.example.Spectro.entities.Student;
import com.example.Spectro.repositories.StudentRepository;

import org.junit.jupiter.api.Assertions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;


    @Test
    public void StudentRepository_SaveAll_ReturnSaved() {
        //arange
        Student student = Student.builder()
                .firstName("omar").lastName("salem").email("omar@gmail.com").build();

        //act
        Student savedStudent = studentRepository.save(student);

        //assert

        assertThat(savedStudent).isNotNull();
    }


}
