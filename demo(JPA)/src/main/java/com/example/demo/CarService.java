package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepository;

	
	
	public Car buyCar(Integer car_id, Customer customer) {
		Car currentCar = null;
	
		Optional<Car> optionalCar = carRepository.findById(car_id);
		if(optionalCar.isPresent()) {
			currentCar = optionalCar.get();
		}
		if (currentCar.getNumOfCars() > 0) {
			currentCar.setNumOfCars(currentCar.getNumOfCars()-1);
			carRepository.save(currentCar);
			return currentCar;
		}
		return currentCar;
	}

}
