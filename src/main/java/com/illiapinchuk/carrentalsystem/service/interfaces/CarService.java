package com.illiapinchuk.carrentalsystem.service.interfaces;

import com.illiapinchuk.carrentalsystem.dto.CarDto;
import com.illiapinchuk.carrentalsystem.model.Car;

import java.util.List;

public interface CarService {

    List<Car> getAllCars();

    List<Car> getAvailableCarListForLocation(String country, String city);

    Car getCarById(Long id);

    List<String> getBrandList();

    List<String> getModelListForBrand(String brand);

    List<String> getBodTypeList();

    List<String> getCityList();

    List<String> getColorList();

    Car updateCar(CarDto carDto);

    Car addCar(CarDto carDto);
}
