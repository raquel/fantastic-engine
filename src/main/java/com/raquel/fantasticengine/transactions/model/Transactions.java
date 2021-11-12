package com.raquel.fantasticengine.transactions.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@RedisHash("Transactions")
public class Transactions implements Serializable {

    @Id
    private String transactionId;//Transaction_ID|1
    private String accountId;//Account_ID|1
    private OperationsTypes operationsType;//OperationType_ID|1

    private BigDecimal amount;//Amount
    private Instant eventDate;//EventDate|2020-01-01T10:32:07.7199222

}
