package com.smarttrack.Doctor.repository;

import com.smarttrack.Doctor.domain.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends MongoRepository<Doctor,String> {

    List<Doctor> findByDoctorName(String doctorName);
}
