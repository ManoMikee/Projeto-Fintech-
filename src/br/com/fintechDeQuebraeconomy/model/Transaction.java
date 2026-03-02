package br.com.fintechDeQuebraeconomy.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Transaction {
    protected LocalDate date;
    protected BigDecimal amount;
    protected String description;

    public Transaction() {

    }

    public Transaction(LocalDate date, BigDecimal amount, String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }


    public abstract void setAmount(BigDecimal amount);


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (this.description.length() <= 150) {
            this.description = description;
        } else {
            System.out.println("Descrição muito longa.");
        }
    }


}
