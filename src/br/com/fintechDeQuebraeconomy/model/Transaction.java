package br.com.fintechDeQuebraeconomy.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Transaction {
    private LocalDate date;
    private BigDecimal amount;
    private String description;
    private Category category;

    public Transaction() {

    }

    public Transaction(LocalDate date, BigDecimal amount, String description, Category category) {
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.category = category;
        if(category == Category.EXPENSE){
            this.amount = amount.abs().negate();
        }else {
            this.amount =   amount.abs();
        }
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


    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description != null && description.length() <= 150) {
            this.description = description;
        } else {
            System.out.println("Descrição muito longa.");
        }
    }

    public Category getCategory() {
        return category;
    }

    public abstract String showTransaction();




}
