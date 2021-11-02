package com.iiht.training.college.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.college.dto.BranchDto;
import com.iiht.training.college.entity.Branch;
import com.iiht.training.college.exceptions.BranchNotFoundException;
import com.iiht.training.college.repository.BranchRepository;
import com.iiht.training.college.service.BranchService;

@Service
public class BranchServiceImpl implements BranchService {

	@Autowired
	private BranchRepository branchRepository;

	@Override
	public BranchDto registerBranch(BranchDto branchDto) {
		Branch branch = new Branch();
		BeanUtils.copyProperties(branchDto, branch);
		branchRepository.save(branch);
		return branchDto;
	}

	@Override
	public BranchDto updateBranch(BranchDto branchDto) {
		Branch branch = new Branch();
		BeanUtils.copyProperties(branchDto, branch);
		branchRepository.save(branch);
		return branchDto;
	}

	@Override
	public Boolean deleteBranch(Long branchId) {
		BranchDto branchDto = getBranchById(branchId);
		Branch branch = new Branch();
		BeanUtils.copyProperties(branchDto, branch);
		branchRepository.delete(branch);
		return true;
	}

	@Override
	public BranchDto getBranchById(Long branchId) {
		Optional<Branch> branch = branchRepository.findById(branchId);
		if (branch.isPresent()) {
			BranchDto branchDto = new BranchDto();
			BeanUtils.copyProperties(branch.get(), branchDto);
			return branchDto;
		} else {
			throw new BranchNotFoundException("The Branch with id " + branchId + " does not exists");
		}
	}

	@Override
	public List<BranchDto> getAllBranchs() {
		List<Branch> branches = branchRepository.findAll();
		List<BranchDto> branchDtos = new ArrayList<>();
		for (Branch branch : branches) {
			BranchDto branchDto = new BranchDto();
			BeanUtils.copyProperties(branch, branchDto);
			branchDtos.add(branchDto);
		}
		return branchDtos;
	}

}
