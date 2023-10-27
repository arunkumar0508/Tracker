package com.smarttrack.Doctor.controller;

import com.smarttrack.Doctor.domain.Doctor;
import com.smarttrack.Doctor.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/apii/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/add")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        Doctor doc= doctorService.addDoctor(doctor);
        return ResponseEntity.ok(doctor);
    }
    @GetMapping("/search/{doctorName}")
    public List<Doctor> searchDoctorsByName(@PathVariable String doctorName) {
        return doctorService.getDoctor(doctorName);
    }

    @GetMapping("/all")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAll();
    }


}
