package com.raquel.fantasticengine.transactions;

import com.raquel.fantasticengine.transactions.model.OperationsTypes;
import com.raquel.fantasticengine.transactions.model.Transactions;
import com.raquel.fantasticengine.transactions.model.TransactionsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Service
public class TransactionService {

    private final ModelMapper modelMapper;
    private final TransactionsRepository repository;

    public TransactionService(ModelMapper modelMapper, TransactionsRepository repository) {
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    public String createTransaction(TransactionRequest transaction) {
        Transactions transactions = convertToEntity(transaction);
        Transactions saved = repository.save(transactions);
        if (saved.getTransactionId() != null)
            return saved.getTransactionId();
        return null;
    }

    private Transactions convertToEntity(TransactionRequest request) {
        //FIXME modelmapper not working properly
        OperationsTypes operationsTypes = OperationsTypes.valueOf(request.getOperationType()).get();
        String newId = UUID.randomUUID().toString();

        Transactions transaction = new Transactions();
        transaction.setTransactionId(newId);
        transaction.setOperationsType(operationsTypes);
        transaction.setAccountId(request.getAccountId());
        transaction.setEventDate(Instant.now());
        transaction.setAmount(settingAmount(request.getAmount(), operationsTypes));
        return transaction;
//        return modelMapper.map(request, Transactions.class);
    }

    private BigDecimal settingAmount(String amount, OperationsTypes operationsTypes) {
        BigDecimal rightAmount = BigDecimal.valueOf(Double.parseDouble(amount));
        if (operationsTypes.equals(OperationsTypes.PAGAMENTO))
            return rightAmount;
        return rightAmount.negate();
    }

}
