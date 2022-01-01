package com.sdp3.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp3.main.entity.Loan;
import com.sdp3.main.entity.User;
import com.sdp3.main.repository.LoanRepo;
import com.sdp3.main.repository.UserRepo;

@Service
public class LoanService {
	@Autowired
	private LoanRepo loanRepo;
	
	public Loan saveLoan(Loan loan) {
		return loanRepo.save(loan);
	}
	

}
