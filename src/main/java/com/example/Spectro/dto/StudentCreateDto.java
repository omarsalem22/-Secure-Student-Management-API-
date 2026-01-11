package com.example.Spectro.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
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

    @Size(min = 2, max = 50, message = "firstName should be more than 2 chars")
    private String firstName;

    @Size(min = 2, max = 50, message = "lastName should be more than 2 chars")

    private String lastName;

    @NotBlank(message = "Email is required")
    @Email  (message = "Please provide a valid email address")
    private String email;

    @Past(message = "Date of birth must be in the past")  // to  ensure the stdent was born in past date
    private LocalDate dateOfBirth;
}
