package com.illiapinchuk.carrentalsystem.controller;

import com.illiapinchuk.carrentalsystem.model.Car;
import com.illiapinchuk.carrentalsystem.service.interfaces.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarsFilterController {

    @Autowired
    private CarService carService;

    @GetMapping("/colors")
    public List<String> getCarColors(){
        return carService.getColorList();
    }

    @GetMapping("/byLocation")
    public List<Car> getCarsByLocation(@RequestParam(name = "country", defaultValue = "") String country,
                                       @RequestParam(name = "city", defaultValue = "") String city){
        return carService.getAvailableCarListForLocation(country, city);
    }

    @GetMapping("/brands")
    public List<String> getBrandList() {
        return carService.getBrandList();
    }

    @GetMapping("/models")
    public List<String> getModelListForBrand(@RequestParam(name = "brand") String brand) {
        return carService.getModelListForBrand(brand);
    }

    @GetMapping("/body-types")
    public List<String> getBodTypeList() {
        return carService.getBodTypeList();
    }

    @GetMapping(value = "/cities")
    public List<String> vehicleSearchGetCityList() {
        return carService.getCityList();
    }
}
