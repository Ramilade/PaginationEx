package com.example.paginationex.api;

import com.example.paginationex.dto.CarResponse;
import com.example.paginationex.service.CarService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<CarResponse> getCars(Pageable pageable) {
        return carService.getCars(pageable);
    }

    @GetMapping("/brand/{brand}")
    public List<CarResponse> getCarsByBrand(@PathVariable String brand, Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("brand"));

        return carService.getCarsByBrand(brand, pageable);
    }



}
