package com.smarttrack.Hospital.service;

import com.smarttrack.Hospital.domain.Hospital;
import com.smarttrack.Hospital.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HospitalServiceImpl  implements HospitalService{

    private HospitalRepository hospitalRepository;


    @Autowired
    public HospitalServiceImpl(HospitalRepository hospitalRepository){
        this.hospitalRepository=hospitalRepository;
    }

    @Override
    public Hospital addHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    @Override
    public List<String> getAllHospitalNames() {
        List<Hospital> names=hospitalRepository.findAll();
        return names.stream()
                .map(Hospital::gethName)
                .collect(Collectors.toList());

    }
    @Override
    public List<Hospital> getAllHospitalInfo() {
        List<Hospital> hospitals = hospitalRepository.findAll();

        List<Hospital> hospitalInfoList = hospitals.stream()
                .map(hospital -> new Hospital(hospital.gethName(), hospital.getAddress(), hospital.getId(), hospital.getDoctorName()))
                .collect(Collectors.toList());

        return hospitalInfoList;
    }

    @Override
    public Hospital findByName(String hName) {
        return hospitalRepository.findByhName(hName);
    }

    @Override
    public Hospital addDoctorToHospital(Hospital hospital, String hName) {
        Optional<Hospital> hospitalOptional = Optional.ofNullable(hospitalRepository.findByhName(hName));

        if (hospitalOptional.isPresent()) {
            Hospital existingHospital = hospitalOptional.get();

            List<String> doctorNames = existingHospital.getDoctorName();
            if (doctorNames == null) {
                doctorNames = new ArrayList<>();
            }

            if (hospital.getDoctorName() != null) {
                doctorNames.addAll(hospital.getDoctorName());
            }

            existingHospital.setDoctorName(doctorNames);
            return hospitalRepository.save(existingHospital);
        }
        return null;
    }





}
