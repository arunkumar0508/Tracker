import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TrackerServicesService } from '../tracker-services.service';
import { MatSnackBar } from '@angular/material/snack-bar'; 
import { doctor } from '../models/doctor';
import { Router } from '@angular/router'; 


@Component({
  selector: 'app-doctor-form',
  templateUrl: './doctor-form.component.html',
  styleUrls: ['./doctor-form.component.css']
})
export class DoctorFormComponent {
  doctorForm: FormGroup;
  hospitals: string[] | undefined;

  constructor(private fb: FormBuilder, private router: Router,private _snackBar: MatSnackBar, private trackService: TrackerServicesService) {
    this.doctorForm = this.fb.group({
      name: ['', Validators.required],
      age: [''],
      specialization: [''],
      experience: [''],
      hospital: ['', Validators.required],
    });
  }

  ngOnInit() {
    this.trackService.getHospitalNames().subscribe((names) => {
      this.hospitals = names;
      console.log(names);
    });
  }

  onDoctorSubmit() {
    if (this.doctorForm.valid) {
      const doctorData: doctor = {
        doctorName: [this.doctorForm.get('name')?.value],
        age: this.doctorForm.get('age')?.value,
        specialization: this.doctorForm.get('specialization')?.value,
        experience: this.doctorForm.get('experience')?.value,
        hName: this.doctorForm.get('hospital')?.value,
      };

      console.log('Doctor form submitted with values:', doctorData);

      this.trackService.saveDoctorData(doctorData).subscribe(
        (response) => {
          this.openSnackBar('Details submitted successfully');
          console.log('Data Saved', response);
          setTimeout(() => {
            this.router.navigate(['/']); 
          }, 2000);
        },
        (error) => {
          console.error('Error saving data:', error);
        }
      );
    }
  }
  openSnackBar(message: string) {
    this._snackBar.open(message, 'Close', {
      duration: 2000, 
    });
  }
}
