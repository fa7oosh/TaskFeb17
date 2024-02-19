package net.febWork.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.febWork.springboot.exception.ResourceNotFoundException;
import net.febWork.springboot.model.Student;
import net.febWork.springboot.repository.TeacherRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class StudentController {

	@Autowired
	private TeacherRepository TeacherRepository;

	// get all students
	@GetMapping("/students")
	public List<Student> getAllstudents() {
		return TeacherRepository.findAll();
	}

	// create student rest api
	@PostMapping("/students")
	public Student createstudent(@RequestBody Student student) {
		return TeacherRepository.save(student);
	}

	// get student by id rest api
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getstudentById(@PathVariable Long id) {
		Student student = TeacherRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("student not exist with id :" + id));
		return ResponseEntity.ok(student);
	}

	// update student rest api

	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updatestudent(@PathVariable Long id, @RequestBody Student studentDetails) {
		Student student = TeacherRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("student not exist with id :" + id));

		student.setFirstName(studentDetails.getFirstName());
		student.setLastName(studentDetails.getLastName());
		student.setEmailId(studentDetails.getEmailId());

		Student updatedstudent = TeacherRepository.save(student);
		return ResponseEntity.ok(updatedstudent);
	}

	// delete student rest api
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Map<String, Boolean>> deletestudent(@PathVariable Long id) {
		Student student = TeacherRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("student not exist with id :" + id));

		TeacherRepository.delete(student);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
