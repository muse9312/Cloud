package com.example.basic.repository;

import java.util.List;

import com.example.basic.model.Demo;
import com.example.basic.model.HolidayParking;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HolidayParkingRepository 
        extends JpaRepository<HolidayParking, Integer> {

    List<HolidayParking> findByAddressContaining(String address);

}
