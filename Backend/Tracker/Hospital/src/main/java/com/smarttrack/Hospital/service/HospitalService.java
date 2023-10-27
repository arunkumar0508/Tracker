package com.smarttrack.Hospital.service;

import com.smarttrack.Hospital.domain.Hospital;

import java.util.List;

public interface HospitalService {
    Hospital addHospital(Hospital hospital);
    List<String> getAllHospitalNames();
    Hospital findByName(String hName);
    Hospital addDoctorToHospital(Hospital hospital, String hName);
    List<Hospital> getAllHospitalInfo();
}
