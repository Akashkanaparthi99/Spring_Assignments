package com.mobileapp.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.mobileapp.exceptions.MobileNotFoundException;
import com.mobileapp.model.Mobile;

public class MobileServiceImpl implements IMobileService {

	Mobile mobile = null;
	public Mobile getById(int mobileId) throws MobileNotFoundException {
		mobile = showMobiles()
				.stream().filter(mob -> mob.getId().equals(mobileId))
				.findFirst()
				.orElseThrow(()->new MobileNotFoundException("Incorrect Id"));
//		if (mobile == null) {
//			throw new MobileNotFoundException("Incorrect Id");
//		}
		return mobile;
//				return null;
	}

	public List<Mobile> getByBrand(String brand) throws MobileNotFoundException {
		List<Mobile> mobiles =	showMobiles()
				.stream()
				.filter(t -> t.getBrand().equals(brand))
				.sorted((o1, o2) -> o1.getBrand().compareTo(o2.getBrand()))
				.collect(Collectors.toList());
		if(mobiles.isEmpty())
			throw new MobileNotFoundException("Incorrect Brand Name");
	return mobiles;
//		return null;
	}

	public List<Mobile> showMobiles() {
		List<Mobile> mobileList = Arrays.asList(new Mobile(101,"IPhone","13 Pro Max",155999),
				new Mobile(102, "IPhone", "13", 75999),
				new Mobile(103, "Samsung", "S22", 75000),
				new Mobile(104, "Samsung", "S22 Ultra", 115000));
		return mobileList;
		
	}

}
