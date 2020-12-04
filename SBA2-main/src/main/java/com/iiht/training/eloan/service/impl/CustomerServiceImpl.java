package com.iiht.training.eloan.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.eloan.dto.LoanDto;
import com.iiht.training.eloan.dto.LoanOutputDto;
import com.iiht.training.eloan.dto.UserDto;
import com.iiht.training.eloan.entity.Loan;
import com.iiht.training.eloan.entity.Users;
import com.iiht.training.eloan.repository.LoanRepository;
import com.iiht.training.eloan.repository.ProcessingInfoRepository;
import com.iiht.training.eloan.repository.SanctionInfoRepository;
import com.iiht.training.eloan.repository.UsersRepository;
import com.iiht.training.eloan.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	private ProcessingInfoRepository pProcessingInfoRepository;
	
	@Autowired
	private SanctionInfoRepository sanctionInfoRepository;
	
	@Override
	public UserDto register(UserDto userDto) {
		Users users = this.convertRegisterCustomer(userDto);
		
		// save to DB
		Users newCustomer = this.usersRepository.save(users);
		// convert to output entity
		UserDto userDto1 =	this.convertAllcustomerDto(newCustomer);
		return userDto1;
	}
	
	private Users convertRegisterCustomer (UserDto userDto) {
		Users users = new Users();
		users.setEmail(userDto.getEmail());
		users.setFirstName(userDto.getFirstName());
		users.setLastName(userDto.getLastName());
		users.setMobile(userDto.getMobile());
		users.setRole(userDto.getRole());
		return users;		
	}
	
		
	// Utility Methods for new register
	public List<UserDto> getAllCustomers() {
		// TODO Auto-generated method stub
	//	org.hibernate.dialect.MySQL8Dialect
		List<Users> getAllCustomers = this.usersRepository.findAll();
		List<UserDto> userDtos = new ArrayList<UserDto>();
		
		for(Users users : getAllCustomers) {
		UserDto	convertAllcustomerDto = this.convertAllcustomerDto(users);
		userDtos.add(convertAllcustomerDto);
				
		}
		return userDtos;
	}

	
	// Utility Method
	private UserDto convertAllcustomerDto(Users users) {
		UserDto customeroutputDto = new UserDto();
		customeroutputDto.setFirstName(users.getFirstName());
		customeroutputDto.setLastName(users.getFirstName());
		customeroutputDto.setEmail(users.getEmail());
		customeroutputDto.setMobile(users.getMobile());
		customeroutputDto.setId(users.getId());
		customeroutputDto.setRole(users.getRole());
		return customeroutputDto;
		
	}
	
	
	
	@Override
	public LoanOutputDto applyLoan(Long customerId, LoanDto loanDto) {
		// TODO Auto-generated method stub
		
		//LoanOutputDto loanDto1 = this.convertAllLoanDetails(loanDto);
		
		
		@SuppressWarnings("unchecked")
		Loan newloanOutputDto = this.loanRepository.save(null);
		
		//LoanOutputDto loanOutputDto1 = this.convertAllLoanDetails(newloanOutputDto);
		return null;
	}

	//utility method
	
	
	
	
	@Override
	public LoanOutputDto getStatus(Long loanAppId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoanOutputDto> getStatusAll(Long customerId) {
		
	List<LoanOutputDto> getAllLoans = (List<LoanOutputDto>) this.loanRepository.findById(customerId).orElse(null);
	List<LoanOutputDto> getallLoansOutput = new ArrayList<LoanOutputDto>();	
	
	for(LoanOutputDto loanOutputDto : getAllLoans) {
		LoanOutputDto	converAllLoanDetails = this.convertAllLoanDetails(loanOutputDto);
		getallLoansOutput.add(converAllLoanDetails);
				
		}
		return getallLoansOutput;
		
		
	}
	
	//utility methods to get all loans
	
	private LoanOutputDto convertAllLoanDetails(LoanOutputDto loanOutputDto) {
		
		LoanOutputDto loanOutputDto1 =  new LoanOutputDto();
		loanOutputDto1.setCustomerId(loanOutputDto.getCustomerId());
		loanOutputDto1.setLoanAppId(loanOutputDto.getLoanAppId());
		loanOutputDto1.setRemark(loanOutputDto.getRemark());
		loanOutputDto1.setStatus(loanOutputDto.getStatus());
		
		
		return loanOutputDto1;
		
	
	}
	

}
