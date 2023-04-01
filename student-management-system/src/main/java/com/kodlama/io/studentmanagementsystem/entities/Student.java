package com.kodlama.io.studentmanagementsystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "students")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "name" )
	private String name;
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "email")
	private String email;

}
