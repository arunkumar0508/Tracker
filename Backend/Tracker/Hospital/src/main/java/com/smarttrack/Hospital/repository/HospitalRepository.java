package com.smarttrack.Hospital.repository;

import com.smarttrack.Hospital.domain.Hospital;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends MongoRepository<Hospital,String> {
    Hospital findByhName(String hName);
}
