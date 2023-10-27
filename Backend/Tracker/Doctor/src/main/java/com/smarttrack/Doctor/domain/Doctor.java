package com.smarttrack.Doctor.domain;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Doctor {
    @Id
    private String id;
    private List<String> doctorName;
    private String age;
    private  String specialization;
    private String experience;
    private String hName;

    public Doctor() {
    }

    public Doctor(String id, List<String> doctorName, String age, String specialization, String experience, String hName) {
        this.id = id;
        this.doctorName = doctorName;
        this.age = age;
        this.specialization = specialization;
        this.experience = experience;
        this.hName = hName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(List<String> doctorName) {
        this.doctorName = doctorName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String gethName() {
        return hName;
    }

    public void sethName(String hName) {
        this.hName = hName;
    }
}
