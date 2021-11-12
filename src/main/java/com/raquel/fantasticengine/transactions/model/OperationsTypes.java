package com.raquel.fantasticengine.transactions.model;

import java.util.Arrays;
import java.util.Optional;

public enum OperationsTypes {
    //TODO Translate texts to english

    AVISTA(1, "COMPRA A VISTA"),
    PARCELADO(2, "COMPRA PARCELADA"),
    SAQUE(3, "SAQUE"),
    PAGAMENTO(4, "PAGAMENTO");

    private final Integer id;
    private final String description;

    OperationsTypes(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    private Integer id() {return id;}
    private String description() {return description;}

    public static Optional<OperationsTypes> valueOf(Integer id) {
            return Arrays.stream(values())
                .filter(opType -> opType.id == id)
                .findFirst();
        }
}
