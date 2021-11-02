package com.iiht.training.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.training.college.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
