package cy20184235.foundation.bank.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cy20184235.foundation.bank.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	
	@Modifying
	@Transactional
	@Query("UPDATE Customer c SET c.currentBalance = (c.currentBalance+:balance) WHERE c.accountNumber = :account")
	int updateBalanceInc(@Param("account") String account,@Param("balance") double balance);
	
	@Modifying
	@Transactional
	@Query("UPDATE Customer c SET c.currentBalance = (c.currentBalance-:balance) WHERE c.accountNumber = :account")
	int updateBalanceDec(@Param("account") String account,@Param("balance") double balance);
}
