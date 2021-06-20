package cy20184235.foundation.bank.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import cy20184235.foundation.bank.entity.Customer;
import cy20184235.foundation.bank.service.BankService;


@RestController
@RequestMapping("/bank")
public class BankController {
	
	@Autowired
	BankService service;
	

	@GetMapping("/getmessage")
	public ResponseEntity<String> getMessage(){
		return new ResponseEntity<String>("****** Welcome to Customer Account Tracker ******",HttpStatus.OK);
	}
	
	@PostMapping("/")
	public Customer create(@RequestBody Customer customer) {
		return service.saveCustomer(customer);
	}
	
//	@PostMapping("/")
//	public ResponseEntity<?>  create(@RequestBody Customer customer) {
//		ResponseEntity<?> response = new ResponseEntity<>("Create Error Message",HttpStatus.CONFLICT);
//		Customer savedCustomer=service.saveCustomer(customer);
//		response = new ResponseEntity<>(savedCustomer,HttpStatus.CREATED);
//		
//		return response;
//	}
	
	@GetMapping("/")
	public List<Customer> readCustomers() {
		return service.readAllCustomer();
	}
		
	@GetMapping("/searchbyname/{name}")
	public Customer readByName(@PathVariable String name) {
		return service.findCustomerByName(name);
	}
	
	@GetMapping("/searchbypan/{pan}")
	public Customer readByPan(@PathVariable String pan) {
		return service.findCustomerByPan(pan);
	}
	
	@GetMapping("/searchbyaccount/{accountNumber}")
	public Customer readByAccount(@PathVariable String accountNumber) {
		return service.findCustomerByAccountNum(accountNumber);
	}
	
	@GetMapping("/balance/{accountNumber}")
	public double Balance(@PathVariable String accountNumber) {
		return service.findBalance(accountNumber);
	}
	
	@PutMapping("/updateName/{pan}/{name}")
	public String updateName(@PathVariable String pan, @PathVariable String name) {
		return service.updateName(pan, name);
	}
	
	@PutMapping("/updateEmail/{pan}/{email}")
	public String updateEmail(@PathVariable String pan, @PathVariable String email) {
		return service.updateEmail(pan, email);
	}
	
	@PutMapping("/updateBalance/{pan}/{balance}")
	public String updateBalance(@PathVariable String pan, @PathVariable double balance) {
		return service.updateBalance(pan, balance);
	}
	
	@PutMapping("/updateAccount/{pan}/{accountType}/{accountSubType}")
	public String updateAccount(@PathVariable String pan, @PathVariable String accountType, @PathVariable String accountSubType) {
		return service.updateAccountType(pan, accountType, accountSubType);
	}
	
	@PostMapping("/transaction/{sourceAccountNumber}/{targetAccountNumber}/{amount}")
	public String transaction(@PathVariable String sourceAccountNumber, @PathVariable String targetAccountNumber, @PathVariable double amount) {
		return service.transaction(sourceAccountNumber, targetAccountNumber, amount);
	}
	

	@DeleteMapping("/{pan}")
	public String deleteByPan(@PathVariable String pan) {
		return service.deleteCustomerByPan(pan);	
	}
	
}
