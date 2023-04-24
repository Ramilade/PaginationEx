package com.example.paginationex.service;

import com.example.paginationex.dto.CarDto;
import com.example.paginationex.entity.Car;
import com.example.paginationex.repository.CarRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<CarDto> getCars(Pageable pageable) {
        List<Car> cars = carRepository.findAll();
        return cars.stream()
                .map(car -> new CarDto(
                        car.getId(),
                        car.getBrand(),
                        car.getModel(),
                        car.getColor(),
                        car.getKilometers()
                ))
                .collect(Collectors.toList());
    }

    public Page<Car> getAllCars(Pageable pageable) {
        return (Page<Car>) carRepository.findAll((Sort) pageable);
    }

    public List<CarDto> getCarsByBrand(String brand, Pageable pageable) {
        List<Car> cars = carRepository.findByBrand(brand, pageable).getContent();
        return cars.stream()
                .map(car -> new CarDto(car.getId(), car.getBrand(), car.getModel(), car.getColor(), car.getKilometers()))
                .toList();
    }



}