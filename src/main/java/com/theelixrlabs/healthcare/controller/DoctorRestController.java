package com.theelixrlabs.healthcare.controller;

import com.theelixrlabs.healthcare.constants.StatusConstants;
import com.theelixrlabs.healthcare.model.Doctor;
import com.theelixrlabs.healthcare.service.DoctorService;
import com.theelixrlabs.healthcare.utility.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/doctor")
@RestController
public class DoctorRestController {
    @Autowired
    private DoctorService service;

    @PostMapping("/save")
    public CommonResponse addAllDoctor(@RequestBody Doctor doctor) {
        try {
            Doctor doctor1 = service.addAllDoctor(doctor);
            return new CommonResponse<>(StatusConstants.SUCCESS, StatusConstants.OK, doctor1);
        } catch (IllegalArgumentException exception) {
            List<String> errors = List.of(exception.getMessage().split(", "));
            return new CommonResponse(StatusConstants.FAILED, StatusConstants.BAD_REQUEST, errors);

        }
    }

    @GetMapping(value = "/listall")
    public CommonResponse listAllDoctors() {
        List<Doctor> doctorList = service.listAllDoctors();
        if (doctorList.size() > 0) {
            return new CommonResponse(StatusConstants.SUCCESS, StatusConstants.OK, doctorList);
        } else {
            return new CommonResponse(StatusConstants.FAILED, StatusConstants.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/getbyid")
    public CommonResponse getByDoctorId(@RequestParam("searchid") UUID id) {
        Doctor doctor = service.getDoctorById(id);
        if (doctor != null) {
            return new CommonResponse(StatusConstants.SUCCESS, StatusConstants.OK, doctor);
        } else {
            return new CommonResponse(StatusConstants.FAILED, StatusConstants.BAD_REQUEST);
        }
    }
}
