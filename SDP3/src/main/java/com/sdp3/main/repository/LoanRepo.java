package com.sdp3.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdp3.main.entity.Loan;

public interface LoanRepo extends JpaRepository<Loan, Integer>{

}
