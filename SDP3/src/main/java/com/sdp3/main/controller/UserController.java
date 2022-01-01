package com.sdp3.main.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sdp3.main.entity.Loan;
import com.sdp3.main.entity.User;
import com.sdp3.main.repository.LoanRepo;
import com.sdp3.main.repository.UserRepo;
import com.sdp3.main.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
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
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model,Principal principal) {
		String userName = principal.getName();
		User user = this.urepo.findByEmail(userName);
	
	
		model.addAttribute("title","This is Dashboard");
		return "user/user_dashboard";
	}
	
	@RequestMapping("/loans")
	public String loans(Model model,Principal principal) {
		String userName = principal.getName();
		User user = this.urepo.findByEmail(userName);
		List<Loan> l = this.lrepo.findAll();
		model.addAttribute("l","loanslist");
		model.addAttribute("title","Loans");
		return "user/user_loan";
	}
	
	
	@GetMapping("/userProfile")
	public String userProfile(Model model){
		model.addAttribute("title","This is Profile");
		return "user/user_profile";
	}
	
	
	
	
	
}