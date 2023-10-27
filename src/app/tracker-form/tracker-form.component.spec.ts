import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrackerFormComponent } from './tracker-form.component';

describe('TrackerFormComponent', () => {
  let component: TrackerFormComponent;
  let fixture: ComponentFixture<TrackerFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TrackerFormComponent]
    });
    fixture = TestBed.createComponent(TrackerFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
