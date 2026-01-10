package com.example.Spectro.dto;
import com.example.Spectro.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {

    private String username;

    private String email;
    private String password;
    private Role role ;

}
