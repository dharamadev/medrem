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

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import app.medrem.api.constant.ErrorMessage;
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

    private static Account account;

    @BeforeAll
    static void init() {
	account = Account.builder().id("12we34567yt").firstName("Test").lastName("Test").contactNumber("9999999999")
		.accountNumber("MR9454318045").build();
    }

    @Test
    public void getAccountTest() throws Exception {

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
	String accountObject = new ObjectMapper().writeValueAsString(account);
	when(this.accountService.createAccount(Mockito.any())).thenReturn(account);
	this.mockMvc.perform(post("/api/v1/account").contentType(MediaType.APPLICATION_JSON).content(accountObject))
		.andExpect(status().isOk()).andExpect(jsonPath("$.accountNumber", is(new String("MR9454318045"))));
    }

    @Test
    public void createAccount_ExceptionTest() throws Exception {

	String accountObject = new ObjectMapper().writeValueAsString(account);
	when(this.accountService.createAccount(Mockito.any()))
		.thenThrow(new InvaliedRequestException(ErrorMessage.INVALID_REQUEST.value()));
	this.mockMvc.perform(post("/api/v1/account").contentType(MediaType.APPLICATION_JSON).content(accountObject))
		.andExpect(status().isInternalServerError())
		.andExpect(result -> assertThat(result instanceof InvaliedRequestException));
    }

    @Test
    public void updateAccount_01() throws Exception {
	String accountObject = new ObjectMapper().writeValueAsString(account);
	Account account1 = Account.builder().id("12we34567yt").firstName("Test1").lastName("Test1")
		.contactNumber("9999999999").accountNumber("MR9454318045").build();
	when(this.accountService.getAccount(Mockito.anyString())).thenReturn(account1);
	when(this.accountService.updateAccount(Mockito.any())).thenReturn(account);
	this.mockMvc
		.perform(put("/api/v1/account/MR9454318045").contentType(MediaType.APPLICATION_JSON)
			.content(accountObject))
		.andExpect(status().isOk()).andExpect(result -> assertThat(result instanceof ConflictException));
    }

    @Test
    public void updateAccountTest_02() throws Exception {
	String accountObject = new ObjectMapper().writeValueAsString(account);
	when(this.accountService.updateAccount(account)).thenReturn(account);
	this.mockMvc
		.perform(put("/api/v1/account/MR9454318045").contentType(MediaType.APPLICATION_JSON)
			.content(accountObject))
		.andExpect(status().isOk()).andExpect(result -> assertThat(result.toString().equals(accountObject)));
    }

    @Test
    public void updateAccount_Exception_01() throws Exception {
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
