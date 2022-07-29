package com.illiapinchuk.carrentalsystem.repository;

import com.illiapinchuk.carrentalsystem.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
