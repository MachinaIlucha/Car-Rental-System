package com.illiapinchuk.carrentalsystem.controller;

import com.illiapinchuk.carrentalsystem.dto.CarDto;
import com.illiapinchuk.carrentalsystem.model.Car;
import com.illiapinchuk.carrentalsystem.service.interfaces.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
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
    @Transactional
    public String getCarById(@PathVariable Long carId, ModelMap model){
        model.addAttribute("car", carService.getCarById(carId));
        return "car-details";
    }

    @GetMapping
    public String getListOfCars(ModelMap model){
        model.addAttribute("cars", carService.getAllCars());
        return "cars";
    }


}
