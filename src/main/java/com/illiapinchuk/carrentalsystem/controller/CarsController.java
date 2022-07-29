package com.illiapinchuk.carrentalsystem.controller;

import com.illiapinchuk.carrentalsystem.dto.CarDto;
import com.illiapinchuk.carrentalsystem.model.Car;
import com.illiapinchuk.carrentalsystem.service.interfaces.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarsController {

    @Autowired
    private CarService carService;

    @PostMapping("/addCar")
    public Car addCar(@ModelAttribute CarDto carDto){
        return carService.addCar(carDto);
    }

    @PutMapping("/updateCar")
    public Car updateCar(@ModelAttribute CarDto carDto){
        return carService.updateCar(carDto);
    }

    @GetMapping("/{carId}")
    public Car getCarById(@PathVariable Long carId){
        return carService.getCarById(carId);
    }


}
