package com.springClass.learningRestApi.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Way 2
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private long id;

    @Size(min = 3, max = 50, message = "Name Should be between length 3 to 50")
    private String name;

    @Email
    @NotBlank(message = "Email is Required")
    private String email;

//    Way 1.
//    public StudentDTO(long id, String name, String email) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//    }
//
//    public StudentDTO() {
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
}
