package com.illiapinchuk.carrentalsystem.repository;

import com.illiapinchuk.carrentalsystem.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("select distinct car.brand from Car car")
    List<String> getBrandList();

    @Query("select distinct cp.color from Car car inner join CarParameters cp on car.carParameters = cp")
    List<String> getColorList();

    @Query("select distinct loc.city from Location loc")
    List<String> getCityList();

    @Query("select distinct cp.bodytype from Car car inner join CarParameters cp on car.id = cp.id")
    List<String> getBodTypeList();

    @Query("select distinct car.model from Car car where car.brand = :brand")
    List<String> getModelListForBrand(String brand);

    @Query("select car from Car car inner join Location loc on car.location = loc where loc.city = :city")
    List<Car> getCarListByCity(String city);

    @Query("select car from Car car inner join Location loc on car.location = loc where loc.country = :country")
    List<Car> getCarListByCountry(String country);

    @Query("select car from Car car inner join Location loc on car.location = loc where loc.country = :country and loc.city = :city")
    List<Car> getCarListByCountryAndCity(String country, String city);
}
