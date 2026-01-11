package com.example.Spectro.services;

import com.example.Spectro.dto.StudentCreateDto;
import com.example.Spectro.dto.StudentResponseDto;
import com.example.Spectro.dto.StudentUpdateDto;
import com.example.Spectro.entities.Student;
import com.example.Spectro.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    public StudentResponseDto createStudent(StudentCreateDto dto) {
        Student student = new Student();
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setEmail(dto.getEmail());
        student.setDateOfBirth(dto.getDateOfBirth());

        Student saved = studentRepository.save(student);

        return mapToResponse(saved);
    }

    public List<StudentResponseDto> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public Optional<StudentResponseDto> getStudentById(Long id) {
        return studentRepository.findById(id)
                .map(this::mapToResponse);
    }

    public Optional<StudentResponseDto> updateStudent(Long id, StudentUpdateDto dto) {
        return studentRepository.findById(id)
                .map(student -> {
                    // Only update fields that were provided (partial update)
                    if (dto.getFirstName() != null) {
                        student.setFirstName(dto.getFirstName());
                    }
                    if (dto.getLastName() != null) {
                        student.setLastName(dto.getLastName());
                    }
                    if (dto.getEmail() != null) {
                        student.setEmail(dto.getEmail());
                    }
                 // i dont update birthdate

                    Student updated = studentRepository.save(student);
                    return mapToResponse(updated);
                });
    }

    public boolean deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Mapper To response also i can use mapStruct
    private StudentResponseDto mapToResponse(Student student) {
        StudentResponseDto dto = new StudentResponseDto();
        dto.setId(student.getId());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setEmail(student.getEmail());
        dto.setDateOfBirth(student.getDateOfBirth());
        return dto;
    }
}
