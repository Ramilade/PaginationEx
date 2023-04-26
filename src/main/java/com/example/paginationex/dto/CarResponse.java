package com.example.paginationex.dto;

import com.example.paginationex.entity.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CarResponse {

    private int id;
    private String brand;
    private String model;
    private String color;
    private int kilometers;

    public CarResponse(Car car) {
        this.id = car.getId();
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.color = car.getColor();
        this.kilometers = car.getKilometers();
    }

}