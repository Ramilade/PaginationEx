package com.example.paginationex.api;

import com.example.paginationex.dto.CarResponse;
import com.example.paginationex.service.CarService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
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

    @GetMapping("/filter")
    public List<CarResponse> filterCars(@RequestParam String column, @RequestParam String val,
                                        Pageable pageable) {
        Sort sort = pageable.getSort().and(Sort.by("brand"));
        pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);

        return carService.filterCars(column, val, pageable);
    }




}
