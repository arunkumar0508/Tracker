package com.smarttrack.Doctor.service;

import com.smarttrack.Doctor.domain.Doctor;

import javax.print.Doc;
import java.util.List;

public interface DoctorService {

    Doctor addDoctor(Doctor doctor);
    List<Doctor> getDoctor(String doctorName);
    List<Doctor> getAll();
}
