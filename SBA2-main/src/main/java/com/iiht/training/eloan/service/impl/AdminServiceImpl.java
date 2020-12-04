package com.iiht.training.eloan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.eloan.dto.UserDto;
import com.iiht.training.eloan.entity.Users;
import com.iiht.training.eloan.repository.UsersRepository;
import com.iiht.training.eloan.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public UserDto registerClerk(UserDto userDto) {
		// TODO Auto-generated method stub
		
		
		Users users = this.convertRegisterClerk(userDto);
		
		// save to DB
		Users newUsers = this.usersRepository.save(users);
		// convert to output entity
	UserDto userDto1 =	this.convertAllclerksDto(newUsers);
		return userDto1;
	}
	
	
	//utility method to create the clerk
	
	private Users convertRegisterClerk (UserDto userDto) {
		Users users = new Users();
		users.setEmail(userDto.getEmail());
		users.setFirstName(userDto.getFirstName());
		users.setLastName(userDto.getLastName());
		users.setMobile(userDto.getMobile());
		users.setRole(userDto.getRole());
		return users;
		
	}
	
		@Override
	public UserDto registerManager(UserDto userDto) {
Users users = this.convertRegisterClerk(userDto);
		
		// save to DB
		Users newUsers = this.usersRepository.save(users);
		// convert to output entity
	UserDto userDto1 =	this.convertAllclerksDto(newUsers);
		return userDto1;
	}
	
	
	@Override
	public List<UserDto> getAllClerks() {
		// TODO Auto-generated method stub
	//	org.hibernate.dialect.MySQL8Dialect
		List<Users> getallClerks = this.usersRepository.findAll();
		List<UserDto> userDtos = new ArrayList<UserDto>();
		
		for(Users users : getallClerks) {
		UserDto	convertAllclerksDto = this.convertAllclerksDto(users);
		userDtos.add(convertAllclerksDto);
				
		}
		return userDtos;
	}

	
	// Utility Method
	private UserDto convertAllclerksDto(Users users) {
		UserDto clerkoutputDto = new UserDto();
		clerkoutputDto.setFirstName(users.getFirstName());
		clerkoutputDto.setLastName(users.getFirstName());
		clerkoutputDto.setEmail(users.getEmail());
		clerkoutputDto.setMobile(users.getMobile());
		clerkoutputDto.setId(users.getId());
		clerkoutputDto.setRole(users.getRole());
		return clerkoutputDto;
		
	}
	
	@Override
	public List<UserDto> getAllManagers() {
		
		List<Users> getallManagers = this.usersRepository.findAll();
		
		List<UserDto> managerDtos = new ArrayList<UserDto>();		
		
		for(Users users : getallManagers) {
			UserDto	convertAllmanagersDto = this.convertAllclerksDto(users);
			managerDtos.add(convertAllmanagersDto);
					
			}
			return managerDtos;
		}	
		
	
	
	
	//utility method to fetch all Managers
	
	
	@SuppressWarnings("unused")
	private UserDto convertAllmanagersDto(Users users) {
		UserDto manageroutputDto = new UserDto();
		
		manageroutputDto.setFirstName(users.getFirstName());
		manageroutputDto.setLastName(users.getFirstName());
		manageroutputDto.setEmail(users.getEmail());
		manageroutputDto.setMobile(users.getMobile());
		manageroutputDto.setId(users.getId());
		String role =	manageroutputDto.setRole(users.getRole());	
		System.out.println(role);
		
		for (role = "manager"; ;) {
		
		return manageroutputDto;
		
	}

	}
	

	}
