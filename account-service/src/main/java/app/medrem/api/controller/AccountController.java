package app.medrem.api.controller;

import java.util.Optional;

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

import app.medrem.api.constant.ErrorMessage;
import app.medrem.api.entity.Account;
import app.medrem.api.exception.InvaliedRequestException;
import app.medrem.api.exception.ConflictException;
import app.medrem.api.exception.RecordNotFound;
import app.medrem.api.service.AccountService;
import app.medrem.api.util.ServiceMapUtil;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ServiceMapUtil serviceMapUtil;

    @GetMapping("/{contactNumber}")
    public ResponseEntity<Account> getAccount(@PathVariable("contactNumber") String accountNumber) {
	if (this.accountService.getAccount(accountNumber) != null) {
	    return ResponseEntity.status(HttpStatus.OK)
		    .body(Optional.of(this.accountService.getAccount(accountNumber)).orElseThrow());
	} else {
	    throw new RecordNotFound(ErrorMessage.ACCOUNT_NOT_FOUND.value());
	}
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
	return ResponseEntity.ok(Optional.of(this.accountService.createAccount(account))
		.orElseThrow(() -> new InvaliedRequestException(ErrorMessage.INVALID_REQUEST.value())));
    }

    @PutMapping("/{contactNumber}")
    public ResponseEntity<Account> updateAccount(@RequestBody Account account,
	    @PathVariable("contactNumber") String contactNumber) {

	if (this.accountService.getAccount(contactNumber) != null) {

	    Account acc1 = this.accountService.getAccount(contactNumber);
	    account.setId(acc1.getId());
	    account.setContactNumber(contactNumber);
	    account.setAccountNumber(acc1.getAccountNumber());

	    System.out.println(acc1.equals(account));
	    if (acc1.equals(account)) {
		throw new ConflictException(ErrorMessage.ACCOUNT_EXISTS.value());
	    } else {
		return ResponseEntity.status(HttpStatus.OK)
			.body(Optional.ofNullable(this.accountService.getAccount(contactNumber)).map(acc -> {
			    return this.accountService
				    .updateAccount(this.serviceMapUtil.updateAccountMap(account, acc));
			}).orElseThrow());
	    }

	} else {
	    account.setContactNumber(contactNumber);
	    return ResponseEntity.status(HttpStatus.OK).body(this.accountService.createAccount(account));
	}
    }

    @DeleteMapping("/{contactNumber}")
    public ResponseEntity<Account> deleteAccount(@PathVariable String contactNumber) {

	Account acc = this.accountService.getAccount(contactNumber);
	
	if (acc == null) {
	    throw new RecordNotFound(ErrorMessage.ACCOUNT_NOT_FOUND.value());
	}

	this.accountService.deleteAccount(contactNumber);
	return ResponseEntity.status(HttpStatus.OK).body(acc);
    }
}
