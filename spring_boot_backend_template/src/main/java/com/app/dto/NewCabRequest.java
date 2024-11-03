package com.app.dto;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewCabRequest {
    private String licensePlate;
    private String model;
    private String location;
    private String status;

    // Getters and Setters
}

