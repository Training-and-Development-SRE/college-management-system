package com.iiht.training.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iiht.training.college.entity.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {

}
