package com.raquel.fantasticengine.transactions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {

    @JsonProperty("account_id")
    private String accountId;

    @JsonProperty("operation_type_id")
    private Integer operationType;

    @JsonProperty("amount")
    private String amount;

}
