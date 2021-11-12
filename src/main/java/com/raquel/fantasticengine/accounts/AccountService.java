package com.raquel.fantasticengine.accounts;

import com.raquel.fantasticengine.accounts.pojo.AccountRequest;
import com.raquel.fantasticengine.accounts.pojo.AccountResponse;
import com.raquel.fantasticengine.accounts.model.Accounts;
import com.raquel.fantasticengine.accounts.model.AccountsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountService {

    private final ModelMapper modelMapper;
    private final AccountsRepository repository;

    public AccountService(ModelMapper modelMapper, AccountsRepository repository) {
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    public String createAccount(AccountRequest request) {
        Accounts account = convertToEntity(request);
        Accounts saved = repository.save(account);
        if (saved.getAccount_id() != null)
            return saved.getAccount_id();
        return null;
    }

    public AccountResponse retrieveAccount(String accountId) {
        Accounts account = null;
        if (repository.findById(accountId).isPresent())
            account = repository.findById(accountId).get();
        return convertToResponse(account);
    }

    private Accounts convertToEntity(AccountRequest request) {
        //FIXME modelmapper not working properly
        String newId = UUID.randomUUID().toString();
        Accounts account = new Accounts();
        account.setAccount_id(newId);
        account.setDocument_number(request.getDocumentNumber());
        return account;
//        return modelMapper.map(request, Accounts.class);
    }

    private AccountResponse convertToResponse(Accounts entity) {
        //FIXME modelmapper not working properly
        if (entity == null)
            return new AccountResponse();
        AccountResponse account = new AccountResponse();
        account.setAccountId(entity.getAccount_id());
        account.setDocumentNumber(entity.getDocument_number());
        return account;
//        return modelMapper.map(entity, AccountResponse.class);
    }

}
