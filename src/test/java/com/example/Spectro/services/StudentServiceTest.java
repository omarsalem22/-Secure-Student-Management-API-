package com.example.Spectro.services;

import com.example.Spectro.dto.StudentCreateDto;
import com.example.Spectro.dto.StudentResponseDto;
import com.example.Spectro.entities.Student;
import com.example.Spectro.repositories.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock  // -->>>>>>.. to get fake copy of th repostory
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentService studentService;

    private Student student;
    private StudentCreateDto createDto;
    @BeforeEach
    void setup(){
        student=new Student();
        student.setId(1L);
        student.setFirstName("omar");
        student.setLastName("moahmed");
        student.setEmail("salem@gmail.com");
        student.setDateOfBirth(LocalDate.of(2002, 1, 22));

        createDto = new StudentCreateDto();
        createDto.setFirstName("omar");
        createDto.setLastName("moahmed");
        createDto.setEmail("salem@gmail.com");
        createDto   .setDateOfBirth(LocalDate.of(2002, 1, 22));

    }

    @Test
    void testCreateStudent(){

        when(studentRepository.save(any(Student.class))).thenReturn(student) ;

        StudentResponseDto result = studentService.createStudent(createDto);

        assertNotNull(result);
        assertEquals("omar", result.getFirstName());
        assertEquals("moahmed", result.getLastName());
        assertEquals("salem@gmail.com", result.getEmail());
        assertEquals(LocalDate.of(2002, 1, 22), result.getDateOfBirth());

        verify(studentRepository).save(any(Student.class));

    }
}
