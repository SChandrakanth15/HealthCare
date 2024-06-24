package com.theelixrlabs.healthcare.validator;

import com.theelixrlabs.healthcare.constants.DoctorConstants;
import com.theelixrlabs.healthcare.model.Doctor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Validator {
    public List<String> validateDoctor(Doctor doctor) {
        List<String> errors = new ArrayList<>();
        if (doctor.getFirstName() == null || doctor.getFirstName().isEmpty()) {
            errors.add(DoctorConstants.FIRST_NAME_SHOULD_BE_MANDATORY);
        }
        if (doctor.getLastName() == null || doctor.getLastName().isEmpty()) {
            errors.add(DoctorConstants.LAST_NAME_SHOULD_BE_MANDATORY);
        }
        if (doctor.getDepartment() == null || doctor.getDepartment().isEmpty()) {
            errors.add(DoctorConstants.DEPARTMENT_SHOULD_BE_MANDATORY);
        }
        if (doctor.getAadhaarNumber() == null || doctor.getAadhaarNumber().isEmpty()) {
            errors.add(DoctorConstants.AADHAAR_NUMBER_SHOULD_BE_MANDATORY);
        }
        return errors;
    }
}

