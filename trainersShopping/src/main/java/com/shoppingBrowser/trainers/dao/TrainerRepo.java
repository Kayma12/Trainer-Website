package com.shoppingBrowser.trainers.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.shoppingBrowser.trainers.model.Trainer;


@RepositoryRestResource(collectionResourceRel ="trainers", path="trainers")
public interface TrainerRepo extends JpaRepository<Trainer, String> {
	 Optional<Trainer> findByTrainerId(String trainerId);
	 //Optional<Trainer findByTrainerId(String trainerId);
	

}




	


