package com.sdp3.main.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdp3.main.entity.Loan;
import com.sdp3.main.entity.User;
import com.sdp3.main.repository.LoanRepo;
import com.sdp3.main.repository.UserRepo;
import com.sdp3.main.service.LoanService;
import com.sdp3.main.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserService service;
	
	@Autowired
	private LoanService loanservice;
	
	@Autowired
	private UserRepo urepo;
	
	@Autowired
	private LoanRepo lrepo;
	

	@ModelAttribute
	public void addCommonData(Model model, Principal principal) {
		String userName = principal.getName();
		User user = service.getEmail(userName);
		model.addAttribute("user",user);
	}
	
	@GetMapping("/adminProfile")
	public String userProfile(Model model){
		model.addAttribute("title","This is Profile");
		return "admin/admin_profile";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, Principal principal) {
		model.addAttribute("title","This is Dashboard");
		String username = principal.getName();
		
		return "admin/admin_dashboard";
	}
	
	@RequestMapping("/addLoan")
	public String addLoan(Model model) {
		
		model.addAttribute("title","Add Loan");
		return "admin/add_loan";
	}
	
	@RequestMapping("/loans")
	public String loans(Model model,Principal principal) {
		String userName = principal.getName();
		User user = this.urepo.findByEmail(userName);
		List<Loan> loanslist = this.lrepo.findAll();
		model.addAttribute("loanslist","loanslist");
		model.addAttribute("title","Loans");
		return "admin/loans";
	}
	
	@PostMapping("/addLoanSave")
	public String addLaonSave(@ModelAttribute("Loan") Loan loan,Model model,HttpSession session) {
		
		try {
			this.loanservice.saveLoan(loan);
			model.addAttribute("course",new Loan());
			model.addAttribute("title","This is Course page");
			return "admin/loans";
		}catch(Exception e) {
			model.addAttribute("Loan",new Loan());
			model.addAttribute("title","Loans");
			return "admin/add_loan";
		}
		
	}
	
}