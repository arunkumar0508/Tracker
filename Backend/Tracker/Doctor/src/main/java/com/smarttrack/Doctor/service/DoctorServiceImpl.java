package com.smarttrack.Doctor.service;

import com.smarttrack.Doctor.domain.Doctor;
import com.smarttrack.Doctor.proxy.HospitalProxy;
import com.smarttrack.Doctor.repository.DoctorRepository;
import com.smarttrack.Hospital.domain.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class DoctorServiceImpl implements DoctorService{

    private DoctorRepository doctorRepository;
    private HospitalProxy hospitalProxy;
    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository, HospitalProxy hospitalProxy) {

        this.doctorRepository = doctorRepository;
        this.hospitalProxy=hospitalProxy;
    }

    @Override
    public Doctor addDoctor(Doctor doctor) {

        doctorRepository.save(doctor);
        ResponseEntity<Hospital> responseEntity = hospitalProxy.updateHospital(doctor, doctor.gethName());
        System.out.println("Proxy error");
        return doctor;

    }

    @Override
    public List<Doctor> getDoctor(String doctorName) {

        return doctorRepository.findByDoctorName(doctorName);
    }

    @Override
    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }


}
