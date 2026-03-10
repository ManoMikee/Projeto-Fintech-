package br.com.fintechDeQuebraeconomy.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Income extends Transaction {

    private String source;

    public Income() {
        super();
    }

    public Income(LocalDate date, BigDecimal amount, String description, String source) {
        super(date, amount, description);
        this.source = source;
        setAmount(amount);
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public void setAmount(BigDecimal amount) {


        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            this.amount = amount.negate();
        } else {
            this.amount = amount;
        }
    }

    @Override
    public String showTransaction() {

        return String.format("""
                RECEITA:
                Descrição: %s
                Valor:  %.2f
                Data: %s
                Fonte: %s
                """,
                getDescription(),
                getAmount(),
                getDate(),
                getSource());
    }
}