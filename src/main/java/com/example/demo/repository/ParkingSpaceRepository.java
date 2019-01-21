package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ParkingSpace;
@Repository
public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, Integer> {

}
