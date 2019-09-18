package com.tpparking.model;

import java.util.ArrayList;
import java.util.List;

public class Parking {
	
	private int id;
	private String name;
	private List<Car> cars = new ArrayList<>();
	
	public Parking(int id, String name, List<Car> cars) {
		super();
		this.id = id;
		this.name = name;
		this.cars = cars;
	}
	public Parking(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public void addCar(Car c) {
		this.cars.add(c);
	}
	public Parking() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	@Override
	public String toString() {
		return "Parking [id=" + id + ", name=" + name + "]";
	}
}