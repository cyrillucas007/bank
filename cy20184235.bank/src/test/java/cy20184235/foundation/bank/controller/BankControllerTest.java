package cy20184235.foundation.bank.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import cy20184235.foundation.bank.entity.Customer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BankControllerTest {

//	private static Customer c1 = new Customer("SRL123456789","Individual","Current","S123456789","s1@gmail.com","Sharon",800);
//	private static Customer c2 = new Customer("SSV123456789","Joint","Saving","M123456789","m1@gmail.com","Sherly",1500);

	
	@Autowired
	TestRestTemplate rest;
	
	@LocalServerPort
	int randomPort;
	
	String URI;

	@Test
	void testGetMessage() {
		fail("Not yet implemented");
	}

	@Test
	void testCreate() {
		URI="http://localhost:"+randomPort+"/bank/";
		
		HttpEntity<Customer> request=new HttpEntity(new Customer("SRL123456789","Individual","Current","S123456789","s1@gmail.com","Sharon",800));
		ResponseEntity<Customer> response=rest.postForEntity(URI, request, Customer.class);
		
		assertThat(response.getStatusCode(),equalTo(HttpStatus.CREATED));
		assertThat(response.getBody().getName(),is("mob"));		
		assertThat(response.getBody().getBrand(),is("apple"));	
		assertThat(response.getBody().getId(),is(1));	
	}


	@Test
	void testReadCustomers() {
		fail("Not yet implemented");
	}

	@Test
	void testReadByName() {
		fail("Not yet implemented");
	}

	@Test
	void testReadByPan() {
		URI="http://localhost:"+randomPort+"/product-mgmt/";
		
		HttpEntity<Product> request=new HttpEntity(new Product("tv",5454.5f,"lg","korea"));;
		ResponseEntity<Product> savedProduct=rest.postForEntity(URI, request, Product.class);
		int freshRecordId=savedProduct.getBody().getId();
		
		URI="http://localhost:"+randomPort+"/product-mgmt/read/"+freshRecordId;
		
		ResponseEntity<Product> findByIdRequest=rest.getForEntity(URI, Product.class);
		assertThat(findByIdRequest.getBody().getName(),is("tv"));
		assertThat(findByIdRequest.getBody().getId(),is(freshRecordId));
	}

	@Test
	void testReadByAccount() {
		fail("Not yet implemented");
	}

	@Test
	void testBalance() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateName() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateEmail() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateBalance() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateAccount() {
		fail("Not yet implemented");
	}

	@Test
	void testTransaction() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteByPan() {
		fail("Not yet implemented");
	}

}
