package com.kodlama.io.RentACar.dataAccess.concretes;




import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.RentACar.entities.concretes.Model;

public interface IModelRepository extends JpaRepository<Model, Integer>  {
	

}
