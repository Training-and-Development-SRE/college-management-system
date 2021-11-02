package com.iiht.training.college.service;

import java.util.List;

import com.iiht.training.college.dto.BranchDto;

public interface BranchService {

	public BranchDto registerBranch(BranchDto branchDto);

	public BranchDto updateBranch(BranchDto branchDto);

	public Boolean deleteBranch(Long branchId);

	public BranchDto getBranchById(Long branchId);

	public List<BranchDto> getAllBranchs();
}
