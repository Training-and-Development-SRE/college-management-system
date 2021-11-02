package com.iiht.training.college.service;

import java.util.List;

import com.iiht.training.college.dto.LecturerDto;

public interface LecturerService {

	public LecturerDto registerLecturer(LecturerDto lecturerDto);

	public LecturerDto updateLecturer(LecturerDto lecturerDto);

	public Boolean deleteLecturer(Long lecturerId);

	public LecturerDto getLecturerById(Long lecturerId);

	public List<LecturerDto> getAllLecturers();
}
