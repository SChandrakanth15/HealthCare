package com.theelixrlabs.healthcare.serviceimp;

import com.theelixrlabs.healthcare.model.Doctor;
import com.theelixrlabs.healthcare.repository.DoctorRepository;
import com.theelixrlabs.healthcare.service.DoctorService;
import com.theelixrlabs.healthcare.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DoctorServiceImp implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private Validator validator;

    @Override
    public Doctor addAllDoctor(Doctor doctor) {
        List<String> errors = validator.validateDoctor(doctor);
        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> listAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctorById(UUID id) {
        return doctorRepository.getDoctorById(id);
    }
}
