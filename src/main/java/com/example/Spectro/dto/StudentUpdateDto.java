package com.example.Spectro.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentUpdateDto {

    private String firstName;

    private String lastName;

    private String email;

    //for date of birth i assumed it cant be changed
}
