package com.iiht.training.college.controller;

import java.util.List;

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

import com.iiht.training.college.dto.LecturerDto;
import com.iiht.training.college.service.LecturerService;

@RestController
@RequestMapping("/api/lecturers")
@CrossOrigin("*")
public class LecturerController {

	@Autowired
	private LecturerService lecturerService;

	@PostMapping
	public ResponseEntity<LecturerDto> registerLecturer(@RequestBody LecturerDto lecturerDto) {
		lecturerService.registerLecturer(lecturerDto);
		return ResponseEntity.ok(lecturerDto);
	}

	@PutMapping
	public ResponseEntity<LecturerDto> updateLecturer(@RequestBody LecturerDto lecturerDto) {
		lecturerService.updateLecturer(lecturerDto);
		return ResponseEntity.ok(lecturerDto);
	}

	@DeleteMapping("/{lecturerId}")
	public ResponseEntity<Boolean> deleteLecturer(@PathVariable Long lecturerId) {
		lecturerService.deleteLecturer(lecturerId);
		return ResponseEntity.ok(true);
	}

	@GetMapping("/{lecturerId}")
	public ResponseEntity<LecturerDto> getLecturerById(@PathVariable Long lecturerId) {
		LecturerDto lecturerDto = lecturerService.getLecturerById(lecturerId);
		return ResponseEntity.ok(lecturerDto);
	}

	@GetMapping
	public ResponseEntity<List<LecturerDto>> getAllLecturers() {
		List<LecturerDto> lecturers = lecturerService.getAllLecturers();
		return ResponseEntity.ok(lecturers);
	}
}
