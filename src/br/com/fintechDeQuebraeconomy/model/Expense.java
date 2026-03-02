package br.com.fintechDeQuebraeconomy.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Expense extends Transaction {
    private String paymentMethod;
    private boolean paymentStatus;
    private boolean recurringPayment;


    public Expense() {
        super();
    }

    public Expense(LocalDate date, BigDecimal amount, String description, String paymentMethod, boolean paymentStatus, boolean recurringPayment) {
        super(date, amount, description);
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.recurringPayment = recurringPayment;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public boolean isRecurringPayment() {
        return recurringPayment;
    }

    public void setRecurringPayment(boolean recurringPayment) {
        this.recurringPayment = recurringPayment;
    }

    @Override
    public void setAmount(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            this.amount = amount.negate();
        } else {
            this.amount = amount;
        }

    }
}
