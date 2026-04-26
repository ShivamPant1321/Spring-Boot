package com.springClass.learningRestApi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

// Way 2
@Data
@AllArgsConstructor
public class StudentDTO {
    private long id;
    private String name;
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
