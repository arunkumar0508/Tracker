package com.smarttrack.Hospital.controller;

import com.smarttrack.Hospital.domain.Hospital;
import com.smarttrack.Hospital.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospitals")
public class HospitalController {

    private HospitalService hospitalService;

    public HospitalController() {
    }

    @Autowired
    public HospitalController(HospitalService hospitalService){
        this.hospitalService=hospitalService;
    }

    @PostMapping("/clinic")
    public ResponseEntity<Hospital> addHospital(@RequestBody Hospital hospital) {
        Hospital addedHospital = hospitalService.addHospital(hospital);
        return new ResponseEntity<>(addedHospital, HttpStatus.CREATED);
    }

    @GetMapping("/clinics")
    public List<String> getHospitals(){
        return hospitalService.getAllHospitalNames();

    }
    @GetMapping("/details")
    public List<Hospital> getHospitalsInfo(){
        return hospitalService.getAllHospitalInfo();

    }
    @GetMapping("/{name}")
    public ResponseEntity<Hospital> findHospitalByName(@PathVariable String hName) {
        Hospital hospital = hospitalService.findByName(hName);
        if (hospital != null) {
            return new ResponseEntity<>(hospital, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/add-doctor/{hName}")
    public ResponseEntity<?> updateHospital(@RequestBody Hospital hospital, @PathVariable String hName) {
        Hospital update = hospitalService.addDoctorToHospital(hospital, hName);

        if (update != null) {
            return ResponseEntity.ok(update);
        } else {
            System.out.println("Not updating");
            return ResponseEntity.notFound().build();
        }
    }

}

