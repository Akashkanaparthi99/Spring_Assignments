package com.testcases.mobileapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mobileapp.exceptions.MobileNotFoundException;
import com.mobileapp.model.Mobile;
import com.mobileapp.service.IMobileService;
import com.mobileapp.service.MobileServiceImpl;

class MobileTest {
	IMobileService mobileService;
	List<Mobile> mobilesByBrand = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	mobileService = new MobileServiceImpl();
	mobilesByBrand = Arrays.asList(new Mobile(101,"IPhone","13 Pro Max",155999),
			new Mobile(102, "IPhone", "13", 75999),
			new Mobile(103, "Samsung", "S22", 75000),
			new Mobile(104, "Samsung", "S22 Ultra", 115000));
	}

	@AfterEach
	void tearDown() throws Exception {
		mobileService = null;
	}

	@Test
	@DisplayName("Testing id available")
	void testGetById() throws MobileNotFoundException {
		Mobile mobile = mobileService.getById(101);
		assertNotNull(mobile);
	}
	
	@Test
	@DisplayName("Testing invalid id available")
	void testGetInvalidId() throws MobileNotFoundException {
		assertThrows(MobileNotFoundException.class, ()-> mobileService.getById(5));
	}
	
	@Test
	@DisplayName("Testing same object")
	void testGetByIdEquals() throws MobileNotFoundException {
		Mobile mobile1 = new Mobile(101,"IPhone","13 Pro Max",155999);
		Mobile mobile = mobileService.getById(101);
		assertEquals(mobile1.toString(),mobile.toString());
	}
	
	@Test
	@DisplayName("Testing invalid brand name available")
	void testGetInvalidBrand() throws MobileNotFoundException {
		assertThrows(MobileNotFoundException.class, ()-> mobileService.getByBrand("Apple"));
	}
	
	@Test
	@DisplayName("Testing correct brand name available")
	void testGetBrand() throws MobileNotFoundException {
		List<Mobile> mobileList = mobileService.getByBrand("S22");
		assertNotNull(mobileList);

	}
	@Test
	@DisplayName("Testing brand values available")
	void testGetByBrandAvailble() throws MobileNotFoundException{
		List<Mobile> mobileList = mobileService.getByBrand("Samsung");
		assertEquals(mobilesByBrand.toString(),mobileList.toString());
	}


}
