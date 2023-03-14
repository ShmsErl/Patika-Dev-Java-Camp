package com.kodlama.io.RentACar.dataAccess.concretes;




import org.springframework.data.jpa.repository.JpaRepository;


import com.kodlama.io.RentACar.entities.concretes.Brand;

public interface IBrandRepository extends JpaRepository<Brand, Integer>  {
	
	 boolean existsByName(String name); //spring jpa keyword araştır.
	

}
