package app.medrem.api.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import app.medrem.api.exception.ConflictException;
import app.medrem.api.exception.InvaliedRequestException;
import app.medrem.api.exception.RecordNotFound;
import app.medrem.api.model.Account;
import app.medrem.api.repository.AccountRepository;
import app.medrem.api.service.AccountService;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @MockBean
    private AccountRepository accountRepository;

    @Test
    public void getAccountTest() throws Exception {
	Account account = new Account("12we34567yt", null, null, null, null, null, "MR9454318045");
	when(this.accountService.getAccount(Mockito.anyString())).thenReturn(account);
	this.mockMvc.perform(get("/api/v1/account/MR9454318045")).andExpect(status().isOk())
		.andExpect(jsonPath("$.accountNumber", is(new String("MR9454318045"))));
    }

    @Test
    public void getAccountTest_ExceptionTest() throws Exception {
	when(this.accountService.getAccount(Mockito.anyString())).thenReturn(null);
	this.mockMvc.perform(get("/api/v1/account/MR9454318045").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isNotFound()).andExpect(result -> assertThat(result instanceof RecordNotFound));
    }

    @Test
    public void createAccountTest() throws Exception {
	Account account = new Account("6188d254ee97ed79200f1e37", "John", "Doe", "M", "dharmendra@gmail.com",
		"9454318045", "MR9454318045");
	String accountObject = new ObjectMapper().writeValueAsString(account);
	when(this.accountService.createAccount(Mockito.any())).thenReturn(account);
	this.mockMvc.perform(post("/api/v1/account").contentType(MediaType.APPLICATION_JSON).content(accountObject))
		.andExpect(status().isOk()).andExpect(jsonPath("$.accountNumber", is(new String("MR9454318045"))));
    }

    @Test
    public void createAccount_ExceptionTest() throws Exception {
	Account account = new Account("6188d254ee97ed79200f1e37", "John", "Doe", "", "dharmendra@gmail.com", "", "");
	String accountObject = new ObjectMapper().writeValueAsString(account);
	when(this.accountService.createAccount(Mockito.any())).thenReturn(account);
	this.mockMvc.perform(post("/api/v1/account").contentType(MediaType.APPLICATION_JSON).content(accountObject))
		.andExpect(status().isOk()).andExpect(result -> assertThat(result instanceof InvaliedRequestException));
    }

    @Test
    public void updateAccountTest() throws Exception {
	Account account = new Account("6188d254ee97ed79200f1e37", "John", "Doe", "M", "dharmendra@gmail.com",
		"9454318045", "MR9454318045");
	String accountObject = new ObjectMapper().writeValueAsString(account);
	when(this.accountService.updateAccount(account)).thenReturn(account);
	this.mockMvc
		.perform(put("/api/v1/account/MR9454318045").contentType(MediaType.APPLICATION_JSON)
			.content(accountObject))
		.andExpect(status().isOk()).andExpect(result -> assertThat(result.toString().equals(accountObject)));
    }

    @Test
    public void updateAccount_Exception() throws Exception {
	Account account = new Account("6188d254ee97ed79200f1e37", "John", "Doe", "M", "dharmendra@gmail.com",
		"9454318045", "MR9454318045");
	String accountObject = new ObjectMapper().writeValueAsString(account);
	when(this.accountService.getAccount(Mockito.anyString())).thenReturn(account);
	when(this.accountService.updateAccount(Mockito.any())).thenReturn(account);
	this.mockMvc
		.perform(put("/api/v1/account/MR9454318045").contentType(MediaType.APPLICATION_JSON)
			.content(accountObject))
		.andExpect(status().isConflict()).andExpect(result -> assertThat(result instanceof ConflictException));
    }

    @Test
    public void deleteAccountTest() throws Exception {
	Account account = new Account("6188d254ee97ed79200f1e37", "John", "Doe", "M", "dharmendra@gmail.com",
		"9454318045", "MR9454318045");
	when(this.accountService.getAccount(Mockito.anyString())).thenReturn(account);
	Mockito.doNothing().when(this.accountService).deleteAccount(Mockito.anyString());
	this.mockMvc.perform(delete("/api/v1/account/MR9454318045").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	verify(accountService, Mockito.times(1)).deleteAccount(new String("MR9454318045"));
    }

    @Test
    public void deleteAccountTest_Exception() throws Exception {
	when(this.accountService.getAccount(Mockito.anyString())).thenReturn(null);
	this.mockMvc.perform(delete("/api/v1/account/MR9454318045").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isNotFound()).andExpect(result -> assertThat(result instanceof RecordNotFound));
    }
}
