package cy20184235.foundation.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cy20184235.foundation.bank.dao.CustomerRepository;
import cy20184235.foundation.bank.dao.TransactionRepository;
import cy20184235.foundation.bank.entity.Customer;
import cy20184235.foundation.bank.entity.Transaction;
import cy20184235.foundation.bank.util.InsufficientBallanceException;
import cy20184235.foundation.bank.util.NoDataException;
import cy20184235.foundation.bank.util.UnableToCreateException;

@Service
public class BankService {

	@Autowired
	CustomerRepository repo;
	
	@Autowired
	TransactionRepository trans;

	
	public Customer saveCustomer(Customer customer) {
		String tempPan = customer.getPan();
		Customer saveCustomer=null;
		if (repo.findByPan(tempPan)==null ) {
			saveCustomer=repo.save(customer);
		}
		if(saveCustomer==null) {
            throw new UnableToCreateException(tempPan);
        }
        return saveCustomer;
	}
	
	public List<Customer> readAllCustomer() {
		List<Customer> foundCustomers=repo.findAll();
	    if(foundCustomers.isEmpty()) {
	    	throw new NoDataException(" No records exists");
	    }
	    return foundCustomers;
	}

	public Customer findCustomerByName(String searchName) {
		Customer foundCustomer = repo.findByName(searchName);
		if(foundCustomer==null) {
	    	throw new NoDataException(" No records exists");
	    }
	    return foundCustomer;
	}
	
	public Customer findCustomerByPan(String searchPan) {
		Customer foundCustomer = repo.findByPan(searchPan);
		if(foundCustomer==null) {
	    	throw new NoDataException(" No records exists");
	    }
	    return foundCustomer;
	}
	
	public Customer findCustomerByAccountNum(String searchAccount) {
		Customer foundCustomer = repo.findByAccountNumber(searchAccount);
		if(foundCustomer==null) {
	    	throw new NoDataException(" No records exists");
	    }
	    return foundCustomer;
	}
	
	public double findBalance(String accountNumber) {
		Customer foundCustomer = repo.findByAccountNumber(accountNumber);
		if(foundCustomer==null) {
	    	throw new NoDataException(" No records exists");
	    }
		return repo.findAccBalance(accountNumber);
	}
		
	public String updateEmail(String pan, String email) {
		Customer foundCustomer = repo.findByPan(pan);
		if(foundCustomer==null) {
	    	throw new NoDataException(" No records exists");
	    }
		repo.updateEmailUsingPan(pan, email);
		return "Successfully updated";
	}
	
	public String updateName(String pan, String name) {
		Customer foundCustomer = repo.findByPan(pan);
		if(foundCustomer==null) {
	    	throw new NoDataException(" No records exists");
	    }
		repo.updateEmailUsingPan(pan, name);
		return "Successfully updated";
	}
	
	public String updateAccountType(String pan, String type, String subType) {
		Customer foundCustomer = repo.findByPan(pan);
		if(foundCustomer==null) {
	    	throw new NoDataException(" No records exists");
	    }
		repo.updateAccountTypeUsingPan(pan, type, subType);
		return "Successfully updated";
	}
	
	public String updateBalance(String pan, double balance) {
		Customer foundCustomer = repo.findByPan(pan);
		if(foundCustomer==null) {
	    	throw new NoDataException(" No records exists");
	    }
		repo.updateBalanceUsingPan(pan, balance);
		return "Successfully updated";
	}
	
	public String deleteCustomerByPan(String pan) {
		Customer foundCustomer = repo.findByPan(pan);
		if(foundCustomer==null) {
	    	throw new NoDataException(" No records exists");
	    }
		repo.deleteCustomerByPan(pan);
		return "Successfully deleted";
	}

	public String transaction(String sourceAccountNumber, String targetAccountNumber, double amount) {
		Customer source = repo.findByAccountNumber(sourceAccountNumber);
		if(source==null) {
	    	throw new NoDataException(" No records exists");
	    }
		Transaction t1 = new Transaction();
		t1.setSuccess("Failed.");
		if (source.getCurrentBalance()>=500) {
			trans.updateBalanceInc(targetAccountNumber, amount);
			trans.updateBalanceDec(sourceAccountNumber, amount);
			t1.setSourceAccountNumber(sourceAccountNumber);
			t1.setTargetAccountNumber(targetAccountNumber);
			t1.setAmount(amount);
			t1.setSuccess("Sucess.");
			trans.save(t1);
		}
		else {
			throw new InsufficientBallanceException(sourceAccountNumber);
		}
		return t1.getSuccess();
	}

	
}
