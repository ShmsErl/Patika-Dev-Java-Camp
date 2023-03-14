package com.kodlama.io.RentACar.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "cars")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "plate")
	private String plate;
	@Column(name = "dailyPrice")
	private double dailyPrice;
	@Column(name = "modelYear")
	private int modelYear;
	@Column(name = "state")
	private int state;
	@ManyToOne()
	@JoinColumn(name = "model_id")
	private Model model;
	

}
