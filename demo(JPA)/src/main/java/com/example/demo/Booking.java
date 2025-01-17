package com.example.demo;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {
	
	@Id
	@GeneratedValue
	private Integer id;
	private LocalDate date;
	private LocalTime time;
	
	@ManyToOne
	@JoinColumn(name = "costumer_id", referencedColumnName = "id")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "car_id", referencedColumnName = "id")
	private Car car;
	
	

	public Booking() {
	}
	

	public Booking(Customer customer, Car car) {
		this.date = LocalDate.now();
		this.time = LocalTime.now();
		this.customer = customer;
		this.car = car;
	}


	
	public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

	public LocalDate getDate() {return date;}
	public void setDate(LocalDate date) {this.date = date;}

	public LocalTime getTime() {return time;}
	public void setTime(LocalTime time) {this.time = time;}

	public Customer getCostumer() {return customer;}
    public void setCostumer(Customer costumer) {this.customer = costumer;}

	public Car getCar() {return car;}
	public void setCar(Car car) {this.car = car;}
	
	
}
