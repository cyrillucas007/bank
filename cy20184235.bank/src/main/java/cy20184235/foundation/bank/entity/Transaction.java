package cy20184235.foundation.bank.entity;

import java.io.Serializable;
import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="bank_transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Transaction_ID")
    int id;
	
	@Column(name = "Source")
	String sourceAccountNumber;

	@Column(name = "Target")
	String targetAccountNumber;
	
	@Column(name = "Amount")
	double amount;
	
	@Column(name = "Successful")
	String success;

	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)//mappedBy="transaction",
//    private Set<Customer> customers = new HashSet<Customer>();
	 private Set<Customer> customers = new HashSet<Customer>();
	
}
