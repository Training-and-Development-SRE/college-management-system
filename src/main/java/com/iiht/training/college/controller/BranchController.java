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

import com.iiht.training.college.dto.BranchDto;
import com.iiht.training.college.service.BranchService;

@RestController
@RequestMapping("/api/branches")
@CrossOrigin("*")
public class BranchController {

	@Autowired
	private BranchService branchService;

	@PostMapping
	public ResponseEntity<BranchDto> registerBranch(@RequestBody BranchDto branchDto) {
		branchService.registerBranch(branchDto);
		return ResponseEntity.ok(branchDto);
	}

	@PutMapping
	public ResponseEntity<BranchDto> updateBranch(@RequestBody BranchDto branchDto) {
		branchService.updateBranch(branchDto);
		return ResponseEntity.ok(branchDto);
	}

	@DeleteMapping("/{branchId}")
	public ResponseEntity<Boolean> deleteBranch(@PathVariable Long branchId) {
		branchService.deleteBranch(branchId);
		return ResponseEntity.ok(true);
	}

	@GetMapping("/{branchId}")
	public ResponseEntity<BranchDto> getBranchById(@PathVariable Long branchId) {
		BranchDto branchDto = branchService.getBranchById(branchId);
		return ResponseEntity.ok(branchDto);
	}

	@GetMapping
	public ResponseEntity<List<BranchDto>> getAllBranches() {
		List<BranchDto> branchs = branchService.getAllBranchs();
		return ResponseEntity.ok(branchs);
	}
}
