package com.smarttrack.Doctor.proxy;

import com.smarttrack.Doctor.domain.Doctor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import com.smarttrack.Hospital.domain.Hospital;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@FeignClient(name="user-hospital-service", url="http://localhost:8081")
public interface HospitalProxy {
    @PutMapping("/api/hospitals/add-doctor/{hName}")
    public ResponseEntity<Hospital> updateHospital( @RequestBody Doctor doctor,@PathVariable String hName);

}
