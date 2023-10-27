import { Component, OnInit } from '@angular/core';
import { TrackerServicesService } from '../tracker-services.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-tracker',
  templateUrl: './tracker.component.html',
  styleUrls: ['./tracker.component.css']
})
export class TrackerComponent implements OnInit {
  clinics: any[] | undefined;
  doctors: any[] | undefined;
  detailsFound: boolean = true;

  constructor(private trackerService: TrackerServicesService, private router: Router) {}

  ngOnInit() {
    this.trackerService.getHospital().subscribe(
      (data) => {
        this.clinics = data;
        console.log(data)

      },
      (error) => {
        console.error('Error fetching hospital names: ', error);
      }
    );

    this.trackerService.getDoctors().subscribe(
      (data) => {
        this.doctors = data;
        console.log(data)
      },
      (error) => {
        console.error('Error fetching doctors: ', error);
      }
    );
  }
  onSearch(event: any) {
    if (event && event.target && event.target.value) {
      const searchTerm = event.target.value.trim().toLowerCase(); 
      console.log(searchTerm);
  
      const filteredClinics = this.clinics
        ? this.clinics.filter((clinic) =>
            clinic && typeof clinic.id === 'string' && clinic.id.toLowerCase().includes(searchTerm)
          )
        : [];
  
      const filteredDoctors = this.doctors
        ? this.doctors.filter((doctor) => {
            if (Array.isArray(doctor.doctorName)) {
              return doctor.doctorName.some((name: string) =>
                typeof name === 'string' && name.toLowerCase().includes(searchTerm)
              );
            } else if (typeof doctor.doctorName === 'string') {
              return doctor.doctorName.toLowerCase().includes(searchTerm);
            }
            return false;
          })
        : [];
  
      this.clinics = filteredClinics;
      this.doctors = filteredDoctors;
  
      this.detailsFound = filteredClinics.length > 0 || filteredDoctors.length > 0;
      console.log('Filtered Clinics:', filteredClinics);
      console.log('Filtered Doctors:', filteredDoctors);
  
      if (this.detailsFound) {
        this.router.navigate(['/details'], { queryParams: { type: filteredClinics.length > 0 ? 'clinic' : 'doctor' ,searchTerm: searchTerm} });
      }
    } else {
      this.trackerService.getHospitalNames().subscribe((data) => {
        this.clinics = data;
      });
  
      this.trackerService.getDoctors().subscribe((data) => {
        this.doctors = data;
      });
      console.log(this.detailsFound);
      
  
      this.detailsFound = true;
    }
  }
  
  }
