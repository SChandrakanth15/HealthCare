package com.theelixrlabs.healthcare.service;

import com.theelixrlabs.healthcare.model.Doctor;

import java.util.List;
import java.util.UUID;

public interface DoctorService {
    Doctor addAllDoctor(Doctor doctor);

    List<Doctor> listAllDoctors();

    Doctor getDoctorById(UUID id);


}
