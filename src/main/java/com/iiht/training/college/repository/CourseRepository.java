package com.iiht.training.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.training.college.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
