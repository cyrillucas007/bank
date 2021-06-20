package cy20184235.foundation.bank.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import cy20184235.foundation.bank.entity.Customer;

@SpringBootTest
@AutoConfigureMockMvc
class BankServiceTest {
	
	@Autowired
	MockMvc mockMvc;
	
//	private static Customer c1 = new Customer("LSM123456789","Individual","Current","L123456789","l1@gmail.com","Lucas",400);
//	private static Customer c2 = new Customer("CSL123456789","Joint","Saving","C123456789","c1@gmail.com","Cyril",1000);

	@Test
	@Order(1)
	@DisplayName("####### Testing create new record for valid inputs #######")
	void testSaveCustomer() throws Exception{
		
		Customer c1 = new Customer("L123456789","Lucas","l1@gmail.com","LSM123456789","Current","Individual",400);
		mockMvc.perform(
				post("/bank/")
				.content(asJsonString(c1))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}

//	@Test
//	@Order(2)
//	@DisplayName("####### Testing read all Customers #######")
//	void testReadAllCustomer() throws Exception {
//		mockMvc.perform(
//				get ("/bank")
//				.contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk())
//				.andExpect(MockMvcResultMatchers.jsonPath("$.pan").value("L123456789"))
//				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Lucas"))
//				.andExpect(MockMvcResultMatchers.jsonPath("$.email").value("l1@gmail.com"))
//				.andExpect(MockMvcResultMatchers.jsonPath("$.accountNumber").value("LSM123456789"))
//				.andExpect(MockMvcResultMatchers.jsonPath("$.accountType").value("Current"))
//				.andExpect(MockMvcResultMatchers.jsonPath("$.accountSubType").value("Individual"))
//				.andExpect(MockMvcResultMatchers.jsonPath("$.currentBalance").value(400));
//	}
//
//
//	@Test
//	@Order(3)
//	@DisplayName("####### Testing to find a record when exist #######")
//	void testFindCustomerByName() throws Exception {
//		mockMvc.perform(
//				get ("/bank/searchbyname/Lucas")
//				.contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isFound());
//	}
//	
//	@Test
//	@Order(4)
//	@DisplayName("####### Testing to find a record doesn't exist #######")
//	void testFindCustomerByName_when_NOT_FOUND() throws Exception {
//		mockMvc.perform(
//				get ("/bank/searchbyname/Simon")
//				.contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isNotFound());
//	}
//
//	@Test
//	@Order(5)
//	void testFindCustomerByPan() throws Exception {
//		mockMvc.perform(
//				get ("/searchbypan/L123456789")
//				.contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isFound())
//				.andExpect(MockMvcResultMatchers.jsonPath("$.pan").value("L123456789"));
//	}
//
//	@Test
//	@Order(6)
//	void testFindCustomerByPan_when_NOT_FOUND() throws Exception {
//		mockMvc.perform(
//				get ("/searchbypan/S123456789")
//				.contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isNotFound());
//	}
//
//	@Test
//	@Order(7)
//	void testFindCustomerByAccountNum() throws Exception {
//		mockMvc.perform(
//				get ("/searchbyaccount/LSM123456789")
//				.contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isFound())
//				.andExpect(MockMvcResultMatchers.jsonPath("$.accountNumber").value("LSM123456789"));
//	}
//	
//	@Test
//	@Order(8)
//	void testFindCustomerByAccountNum_when_NOT_FOUND() throws Exception {
//		mockMvc.perform(
//				get ("/searchbyaccount/SHR123456789")
//				.contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isNotFound());
//	}
//
//	@Test
//	@Order(9)
//	void testFindBalance() throws Exception {
//		mockMvc.perform(
//				get ("/balance/LSM123456789")
//				.contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isFound())
//				.andExpect(MockMvcResultMatchers.jsonPath("$.accountNumber").value("LSM123456789"))
//				.andExpect(MockMvcResultMatchers.jsonPath("$.currentBalance").value(400));
//	}
//	
//	@Test
//	@Order(10)
//	void testFindBalance_when_NOT_FOUND() throws Exception {
//		mockMvc.perform(
//				get ("/balance/SHR123456789")
//				.contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isNotFound());
//	}

//	@Test
//	@Order(11)
//	void testUpdateEmail(/bank/updateEmail/{pan}/{email}) {
//		mockMvc.perform(
//				get ("/bank/searchbyname/Lucas")
//				.contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk());
//	}
//
//	@Test
//	@Order(12)
//	void testUpdateName(/bank/updateName/{pan}/{name}) throws Exception {
//		mockMvc.perform(
//				get ("/bank/searchbyname/Lucas")
//				.contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk());
//	}
//
//	@Test
//	@Order(13)
//	void testUpdateAccountType(/bank/updateAccount/{pan}/{accountType}/{accountSubType}) throws Exception {
//		mockMvc.perform(
//				get ("/bank/searchbyname/Lucas")
//				.contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk());
//	}
//
//	@Test
//	@Order(14)
//	void testUpdateBalance(/bank/updateBalance/{pan}/{balance}) throws Exception {
//		mockMvc.perform(
//				get ("/bank/searchbyname/Lucas")
//				.contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk())
//				.andExpect(MockMvcResultMatchers.jsonPath("$.pan").value("L123456789"))
//				.andExpect(MockMvcResultMatchers.jsonPath("$.currentBalance").value(500));
//	}
//
//	@Test
//	@Order(15)
//	void testDeleteCustomerByPan(/bank/{pan}) throws Exception {
//		mockMvc.perform(
//				get ("/bank/searchbyname/Lucas")
//				.contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk());
//	}
//
//	@Test
//	@Order(16)
//	void testTransaction(/bank/transaction/{sourceAccountNumber}/{targetAccountNumber}/{amount}) throws Exception {
//		mockMvc.perform(
//				get ("/bank/searchbyname/Lucas")
//				.contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk());
//	}
	
	private static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

}
