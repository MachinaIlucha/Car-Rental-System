package com.illiapinchuk.carrentalsystem.repository;

import com.illiapinchuk.carrentalsystem.model.CarParameters;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarParametersRepository extends JpaRepository<CarParameters, Long> {
}
