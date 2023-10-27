import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TrackerComponent } from './tracker/tracker.component';
import { TrackerFormComponent } from './tracker-form/tracker-form.component';
import { DoctorFormComponent } from './doctor-form/doctor-form.component';
import { DetailsComponent } from './details/details.component';

const routes: Routes = [
  { path: '', component: TrackerComponent },
  { path: 'details',component: DetailsComponent},
  { path: 'tracker-form', component: TrackerFormComponent },
  { path: 'doctor-form', component: DoctorFormComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
