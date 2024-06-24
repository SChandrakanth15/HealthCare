package com.theelixrlabs.healthcare.model;

import com.theelixrlabs.healthcare.constants.DoctorConstants;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.UUID;

@Data
@Document(collection = DoctorConstants.DOCTOR_COLLECTION_NAME)
public class Doctor {
    @Id
    private UUID id;
    @NotBlank(message = DoctorConstants.FIRST_NAME_SHOULD_BE_MANDATORY)
    private String firstName;
    @NotBlank(message = DoctorConstants.LAST_NAME_SHOULD_BE_MANDATORY)
    private String lastName;
    @NotBlank(message = DoctorConstants.DEPARTMENT_SHOULD_BE_MANDATORY)
    private String department;
    @NotBlank(message = DoctorConstants.AADHAAR_NUMBER_SHOULD_BE_MANDATORY)
    @Pattern(regexp = DoctorConstants.AADHAAR_NUMBER_PATTERN, message = DoctorConstants.INVALID_AADHAAR_NUMBER_FORMAT)
    private String aadhaarNumber;
    @DBRef
    private List<Patient> patients;

    public Doctor() {
        this.id = UUID.randomUUID();
    }

}
