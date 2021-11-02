package com.iiht.training.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.training.college.entity.Lecturer;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Long>{

}
