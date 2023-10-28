import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TrackerServicesService } from '../tracker-services.service';
import { clinic } from '../models/clinic';
import { Router } from '@angular/router'; 
import { MatSnackBar } from '@angular/material/snack-bar'; 


@Component({
  selector: 'app-tracker-form',
  templateUrl: './tracker-form.component.html',
  styleUrls: ['./tracker-form.component.css']
})
export class TrackerFormComponent {
  myForm: FormGroup;

  constructor(private fb: FormBuilder, private router: Router,private _snackBar: MatSnackBar,private trackService: TrackerServicesService) {
    this.myForm = this.fb.group({
      hName: ['', [Validators.required]],
      address: ['', [Validators.required]]
    });
  }

  
  onSubmit() {
    if (this.myForm && this.myForm.valid) {
      const formData: clinic = {
        hName:this.myForm.get('hName')?.value,
        address: this.myForm.get('address')?.value
      };
      this.trackService.saveHospitalData(formData).subscribe(
        (response) => {
          this.openSnackBar('Details submitted successfully');
          setTimeout(() => {
            this.router.navigate(['/']); 
          }, 2000);
          console.log('Data saved successfully:', response);
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
