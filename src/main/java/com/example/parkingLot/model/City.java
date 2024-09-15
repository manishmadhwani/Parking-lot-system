package com.example.parkingLot.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "CITIES")
public class City {
	@Id
	@Column(name = "city_id")
	private String cityId;
	@Column(name = "name")
	private String cityName;

	@OneToMany(mappedBy = "city")
	private List<ParkingLot> parkingLots;
}
