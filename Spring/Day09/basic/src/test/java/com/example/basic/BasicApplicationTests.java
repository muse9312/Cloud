package com.example.basic;

import java.util.List;

import com.example.basic.mapper.DemoMapper;
import com.example.basic.model.HolidayParking;
import com.example.basic.repository.HolidayParkingRepository;
import com.example.basic.repository.JavaBoardRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootTest
class BasicApplicationTests {
	@Autowired
	DemoMapper demoMapper;

	@Test
	void contextLoads() {
		System.out.println(demoMapper.select());
	}

	@Autowired
	JavaBoardRepository javaBoardRepository;

	@Autowired
	HolidayParkingRepository holidayParkingRepository;

	@Test
	void paging() {
		PageRequest pageable = PageRequest.of(0, 30);

		javaBoardRepository.findAll(pageable);




		PageRequest pageRequest = PageRequest.of(1, 5);
		
		Page<HolidayParking> list = 
			holidayParkingRepository.findAll(pageRequest);
		
		System.out.println( list.getContent() );
	}

	@Test
	void search() {
		List<HolidayParking> list = 
			holidayParkingRepository.findByAddressContaining(
				"금천구");
		
		System.out.println( list );
	}

	@Test
	void abcd() {
		System.out.println(javaBoardRepository.findAll());
	}

}
