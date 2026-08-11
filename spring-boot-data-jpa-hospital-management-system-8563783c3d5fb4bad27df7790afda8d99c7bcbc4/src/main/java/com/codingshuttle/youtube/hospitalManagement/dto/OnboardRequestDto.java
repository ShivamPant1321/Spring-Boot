package com.codingshuttle.youtube.hospitalManagement.dto;


import lombok.Data;

@Data
public class OnboardRequestDto {
    private Long userId;
    private String specialization;
    private String name;
}
