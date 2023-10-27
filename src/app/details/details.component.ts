import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TrackerServicesService } from '../tracker-services.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {
  data: any[] = [];
  searchType: string = '';
  searchTerm: string = '';

  constructor(
    private trackerService: TrackerServicesService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.route.queryParams.subscribe((params) => {
      this.searchType = params['type'];
      this.searchTerm = params['searchTerm'];
      console.log(this.searchType);
      console.log(this.searchTerm);

      if (this.searchType === 'clinic') {
        this.trackerService.getHospital().subscribe((data) => {
          this.data = data.filter((clinic: any) => {
            return clinic && clinic['id'] && clinic['id'].toLowerCase().includes(this.searchTerm.toLowerCase());
          });
          console.log('Clinic data:', this.data);
        });
      } else if (this.searchType === 'doctor') {
        this.trackerService.getDoctors().subscribe((data) => {
          this.data = data.filter((doctor: any) => {
            return (
              doctor &&
              doctor.doctorName &&
              Array.isArray(doctor.doctorName) && 
              doctor.doctorName.some((name: string) =>
                name.toLowerCase().includes(this.searchTerm.toLowerCase())
              )
            );
          });
          console.log('Doctor data:', this.data);
        });
      }
    });
  }

  navigateBack() {
    this.router?.navigate(['/tracker']);
  }
}
