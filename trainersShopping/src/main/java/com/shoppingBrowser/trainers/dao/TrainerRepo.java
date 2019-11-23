package com.shoppingBrowser.trainers.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.shoppingBrowser.trainers.model.Trainer;


@RepositoryRestResource(collectionResourceRel ="trainers", path="trainers")
public interface TrainerRepo extends JpaRepository<Trainer, String> {
	 Trainer findByTrainerId(String trainerId);
	

}




	


