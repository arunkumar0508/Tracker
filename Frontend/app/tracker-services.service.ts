import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { clinic } from './models/clinic';

@Injectable({
  providedIn: 'root'
})
export class TrackerServicesService {
  private baseUrl1 = 'http://localhost:9999/api/hospitals';
  private baseUrl2 = 'http://localhost:9999/apii/doctor';


  constructor(private http: HttpClient) { }

  saveHospitalData(data: any) {
    const url = `${this.baseUrl1}/clinic`;
    return this.http.post(url, data);
  }
  getHospitalNames() {
    const url = `${this.baseUrl1}/clinics`;
    return this.http.get<string[]>(url);
  }
  getHospital() {
    const url = `${this.baseUrl1}/details`;
    return this.http.get<clinic[]>(url);
  }
  saveDoctorData(data: any) {
    const url = `${this.baseUrl2}/add`;
    return this.http.post(url, data);
  }
  getDoctors() {
    const url = `${this.baseUrl2}/all`;
    return this.http.get<any[]>(url);
  }
}
