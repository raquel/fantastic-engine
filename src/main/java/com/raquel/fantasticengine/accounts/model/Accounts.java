package com.raquel.fantasticengine.accounts.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@NoArgsConstructor
@RedisHash("Account")
public class Accounts implements Serializable {

    @Id
    private String account_id; //Account_ID|1
    private String document_number; //Document_Number|12345678900

}

