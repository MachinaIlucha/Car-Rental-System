package com.illiapinchuk.carrentalsystem.service;

import com.illiapinchuk.carrentalsystem.dto.CarDto;
import com.illiapinchuk.carrentalsystem.model.Car;
import com.illiapinchuk.carrentalsystem.model.CarParameters;
import com.illiapinchuk.carrentalsystem.repository.CarParametersRepository;
import com.illiapinchuk.carrentalsystem.repository.CarRepository;
import com.illiapinchuk.carrentalsystem.repository.LocationRepository;
import com.illiapinchuk.carrentalsystem.service.interfaces.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("carService")
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private CarParametersRepository carParametersRepository;

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> getAvailableCarListForLocation(String country, String city) {
        if (country.isEmpty() && !city.isEmpty())
            return carRepository.getCarListByCity(city);
        else if (!country.isEmpty() && city.isEmpty())
            return carRepository.getCarListByCountry(country);
        return carRepository.getCarListByCountryAndCity(country, city);
    }

    @Override
    public Car getCarById(Long id) {
        return carRepository.getReferenceById(id);
    }

    @Override
    public List<String> getBrandList() {
        return carRepository.getBrandList();
    }

    @Override
    public List<String> getModelListForBrand(String brand) {
        return carRepository.getModelListForBrand(brand);
    }

    @Override
    public List<String> getBodTypeList() {
        return carRepository.getBodTypeList();
    }

    @Override
    public List<String> getCityList() {
        return carRepository.getCityList();
    }

    @Override
    public List<String> getColorList() {
        return carRepository.getColorList();
    }

    @Override
    public Car updateCar(CarDto carDto) {
        return addCar(carDto);
    }

    @Override
    @Transactional
    public Car addCar(CarDto carDto) {
        Car car = new Car();
        car.setRegistration(carDto.getRegistration());
        car.setBrand(carDto.getBrand());
        car.setModel(carDto.getModel());
        car.setDailyFee(carDto.getDailyFee());
        car.setLocation(locationRepository.getReferenceById(carDto.getLocation()));
        car.setCarStatus(carDto.getVehicleStatus());
        carRepository.saveAndFlush(car);

        Long carId = car.getId();

        CarParameters carParameters = new CarParameters();
        carParameters.setId(carId);
        carParameters.setBodytype(carDto.getBodytype());
        carParameters.setProductionYear(carDto.getProductionYear());
        carParameters.setFuelType(carDto.getFuelType());
        carParameters.setPower(carDto.getPower());
        carParameters.setGearbox(carDto.getGearbox());
        carParameters.setFrontWheelDrive(carDto.getFrontWheelDrive());
        carParameters.setDoorsNumber(carDto.getDoorsNumber());
        carParameters.setSeatsNumber(carDto.getSeatsNumber());
        carParameters.setColor(carDto.getColor());
        carParameters.setMetallic(carDto.getMetallic());
        carParameters.setDescription(carDto.getDescription());
        carParametersRepository.save(carParameters);

        return carRepository.getReferenceById(carId);
    }
}
