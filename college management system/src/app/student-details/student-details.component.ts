import { Component, OnInit } from '@angular/core';
import { Student } from '../student';
import { ActivatedRoute } from '@angular/router';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css'],
})
export class EmployeeDetailsComponent implements OnInit {
  id: number;
  employee: Student;
  constructor(
    private route: ActivatedRoute,
    private employeService: StudentService
  ) {}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.employee = new Student();
    this.employeService.getEmployeeById(this.id).subscribe((data) => {
      this.employee = data;
    });
  }
}
