package com.raquel.fantasticengine.accounts;

import com.raquel.fantasticengine.accounts.pojo.AccountRequest;
import com.raquel.fantasticengine.accounts.pojo.AccountResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/accounts")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> accountCreation(@RequestBody AccountRequest accountRequest) {
        log.info("Creating account for document {}", accountRequest.getDocumentNumber());
        String accountId = service.createAccount(accountRequest);
        if (accountId != null)
            return new ResponseEntity<>((accountId),HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountResponse> getAccountInformation(@PathVariable String accountId) {
        log.info("Retrieving info for account {}", accountId);
        AccountResponse accountInfo = service.retrieveAccount(accountId);
        if (accountInfo != null)
            return new ResponseEntity<>(accountInfo, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
