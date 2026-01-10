package com.example.Spectro.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentCreateDto {
    private String firstName;

    private String lastName;

    private String email;

    @Past(message = "Date of birth must be in the past")  // to  ensure the stdent was born in past date
    private LocalDate dateOfBirth;
}
