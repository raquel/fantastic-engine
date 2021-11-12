package com.raquel.fantasticengine.accounts.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {

    @JsonProperty("account_id")
    private String accountId;

    @JsonProperty("document_number")
    private String documentNumber;

}
