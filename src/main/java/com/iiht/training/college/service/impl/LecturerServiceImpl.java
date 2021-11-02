package com.iiht.training.college.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.college.dto.LecturerDto;
import com.iiht.training.college.entity.Lecturer;
import com.iiht.training.college.exceptions.LecturerNotFoundException;
import com.iiht.training.college.repository.LecturerRepository;
import com.iiht.training.college.service.LecturerService;

@Service
public class LecturerServiceImpl implements LecturerService {

	@Autowired
	private LecturerRepository lecturerRepository;

	@Override
	public LecturerDto registerLecturer(LecturerDto lecturerDto) {
		Lecturer lecturer = new Lecturer();
		BeanUtils.copyProperties(lecturerDto, lecturer);
		lecturerRepository.save(lecturer);
		return lecturerDto;
	}

	@Override
	public LecturerDto updateLecturer(LecturerDto lecturerDto) {
		Lecturer lecturer = new Lecturer();
		BeanUtils.copyProperties(lecturerDto, lecturer);
		lecturerRepository.save(lecturer);
		return lecturerDto;
	}

	@Override
	public Boolean deleteLecturer(Long lecturerId) {
		LecturerDto lecturerDto = getLecturerById(lecturerId);
		Lecturer lecturer = new Lecturer();
		BeanUtils.copyProperties(lecturerDto, lecturer);
		lecturerRepository.delete(lecturer);
		return true;
	}

	@Override
	public LecturerDto getLecturerById(Long lecturerId) {
		Optional<Lecturer> lecturer = lecturerRepository.findById(lecturerId);
		if (lecturer.isPresent()) {
			LecturerDto lecturerDto = new LecturerDto();
			BeanUtils.copyProperties(lecturer.get(), lecturerDto);
			return lecturerDto;
		} else {
			throw new LecturerNotFoundException("Lecturer with id " + lecturerId + " does not exists");
		}
	}

	@Override
	public List<LecturerDto> getAllLecturers() {
		List<Lecturer> lecturers = lecturerRepository.findAll();
		List<LecturerDto> lecturerDtos = new ArrayList<>();
		for (Lecturer lecturer : lecturers) {
			LecturerDto lecturerDto = new LecturerDto();
			BeanUtils.copyProperties(lecturer, lecturerDto);
			lecturerDtos.add(lecturerDto);
		}
		return lecturerDtos;
	}

}
