import { Component, OnInit } from '@angular/core';
import { Student } from '../student';
import { StudentService } from '../student.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrls: ['./create-student.component.css'],
})
export class CreateStudentComponent implements OnInit {
  employee: Student = new Student();
  constructor(private studentService: StudentService, private router: Router) {}

  ngOnInit(): void {}

  saveTeacher() {
    this.studentService.createTeacher(this.teacher).subscribe(
      (data) => {
        console.log(data);
        this.goToTeacherList();
      },
      (error) => console.log(error)
    );
  }

  goToTeacherList() {
    this.router.navigate(['/teacher']);
  }

  onSubmit() {
    console.log(this.teacher);
    this.saveStudent();
  }
}
