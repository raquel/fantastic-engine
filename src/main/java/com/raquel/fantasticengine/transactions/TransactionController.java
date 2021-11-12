package com.raquel.fantasticengine.transactions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/transactions")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> transactionCreation(@RequestBody TransactionRequest transaction) {
        log.info("Creating transaction {}", transaction.toString());
        String transactionId = service.createTransaction(transaction);
        if (transactionId != null)
            return new ResponseEntity<>((transactionId),HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

}
