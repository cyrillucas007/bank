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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="bank_customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable{
	
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    int id;
	@Id
	@Size(max=10, min=10, message="PAN number should be not more than 10 digits")
	@Column(name ="PAN_Card",unique = true, updatable=false)
	String pan;
	
    @Column(name ="Name")
	String name;
	
	@Email(message="Email should be valid")
	@Column(name ="Email_ID")
	String email;
	
	
	@Size(min=12, max=12)
	@Column(name ="Account_No", unique=true, updatable=false)
	String accountNumber;
	
	String accountType;
	String accountSubType;
	
	double currentBalance;
	
//	@ToString.Exclude
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="Transaction_ID", nullable=false)
//	Transaction transaction;

		
//	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
////  private Set<Customer> customers = new HashSet<Customer>();
//	 private Set<Transaction> transactions = new HashSet<Transaction>();
	
//	@ManyToOne(optional = false)
//    @JoinColumn(name="Transaction_ID")
//    private Transaction transaction;
	
	

}
