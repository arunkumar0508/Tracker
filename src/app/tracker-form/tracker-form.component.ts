import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TrackerServicesService } from '../tracker-services.service';
import { clinic } from '../models/clinic';
@Component({
  selector: 'app-tracker-form',
  templateUrl: './tracker-form.component.html',
  styleUrls: ['./tracker-form.component.css']
})
export class TrackerFormComponent {
  myForm: FormGroup;

  constructor(private fb: FormBuilder, private trackService: TrackerServicesService) {
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
          console.log('Data saved successfully:', response);
        },
        (error) => {
          console.error('Error saving data:', error);
        }
      );
    }
  }

}
