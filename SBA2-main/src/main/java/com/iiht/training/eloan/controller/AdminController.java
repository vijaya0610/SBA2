package com.iiht.training.eloan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.training.eloan.dto.UserDto;
import com.iiht.training.eloan.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/register-clerk")
	public UserDto registerClerk(@RequestBody UserDto userDto){
		
		UserDto userDtoClerk = 	this.adminService.registerClerk(userDto);
		
		return userDtoClerk;
	}
	
	@PostMapping("/register-manager")
	public UserDto registerManager(@RequestBody UserDto userDto){
		
		UserDto userDtomanager = this.adminService.registerManager(userDto);
		return userDtomanager;
	}
	
	//@SuppressWarnings("unchecked")
	@GetMapping("/all-clerks")
	public List<UserDto> getAllClerks(){
		
		List<UserDto> returnallClerks =  this.adminService.getAllClerks();
		return  returnallClerks;
	}
	
	@GetMapping("/all-managers")
	public List<UserDto> getAllManagers(){
		List<UserDto> returnallManager = this.adminService.getAllManagers();
		
		
		return returnallManager;
	}
	
	
}
