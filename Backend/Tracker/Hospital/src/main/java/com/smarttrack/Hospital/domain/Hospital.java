package com.smarttrack.Hospital.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Hospital {
    @Id
    private String id;
    private String hName;
    private String address;
    private List<String> doctorName;

    public Hospital() {
    }

    public Hospital(String id, String hName, String address, List<String> doctorName) {
        this.id = id;
        this.hName = hName;
        this.address = address;
        this.doctorName = doctorName;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String gethName() {
        return hName;
    }

    public void sethName(String hName) {
        this.hName = hName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(List<String> doctorNames) {
        this.doctorName = doctorNames;
    }
}
