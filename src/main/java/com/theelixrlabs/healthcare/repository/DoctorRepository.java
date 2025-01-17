package com.theelixrlabs.healthcare.repository;

import com.theelixrlabs.healthcare.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface DoctorRepository extends MongoRepository<Doctor, UUID> {
    Doctor getDoctorById(UUID id);
}
