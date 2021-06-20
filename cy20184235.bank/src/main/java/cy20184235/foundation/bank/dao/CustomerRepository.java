package cy20184235.foundation.bank.dao;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cy20184235.foundation.bank.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>{
	
	Customer findByName(String name);
	Customer findByPan(String pan);
	Customer findByAccountNumber(String accountNumber);
	
	@Query("SELECT currentBalance FROM Customer c WHERE c.accountNumber = :account")
	int findAccBalance(@Param("account") String account);
	
	@Modifying
	@Transactional
	@Query("UPDATE Customer c SET c.name = :name WHERE c.pan = :pan")
	int updateNameUsingPan(@Param("pan") String pan,@Param("name") String name);
	
	@Modifying
	@Transactional
	@Query("UPDATE Customer c SET c.email = :email WHERE c.pan = :pan")
	int updateEmailUsingPan(@Param("pan") String pan,@Param("email") String email);
	
	@Modifying
	@Transactional
	@Query("UPDATE Customer c SET c.accountType = :type, c.accountSubType = :subtype WHERE c.pan = :pan")
	int updateAccountTypeUsingPan(@Param("pan") String pan,@Param("type") String type, @Param("subtype") String subtype);
	
	@Modifying
	@Transactional
	@Query("UPDATE Customer c SET c.currentBalance = :balance WHERE c.pan = :pan")
	int updateBalanceUsingPan(@Param("pan") String pan,@Param("balance") double balance);
	
//	@Modifying
//	@Transactional
//	@Query("UPDATE Customer c SET c.currentBalance = (c.currentBalance+:balance) WHERE c.accountNumber = :account")
//	int updateBalanceInc(@Param("account") String account,@Param("balance") double balance);
//	
//	@Modifying
//	@Transactional
//	@Query("UPDATE Customer c SET c.currentBalance = (c.currentBalance-:balance) WHERE c.accountNumber = :account")
//	int updateBalanceDec(@Param("account") String account,@Param("balance") double balance);
	
	@Modifying
	@Transactional
	@Query("DELETE Customer c WHERE c.pan = :pan")
	int deleteCustomerByPan(@Param("pan") String pan);
	
	
	
}
