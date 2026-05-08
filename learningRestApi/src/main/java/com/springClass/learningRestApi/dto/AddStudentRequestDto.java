package com.springClass.learningRestApi.dto;

//import lombok.AllArgsConstructor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
//import lombok.NoArgsConstructor;

// Way 2
@Data
public class AddStudentRequestDto {

    @Size(min = 3, max = 50, message = "Name Should be between length 3 to 50")
    private String name;

    @Email
    @NotBlank(message = "Email is Required")
    private String email;
}
