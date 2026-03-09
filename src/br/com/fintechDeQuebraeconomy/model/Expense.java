package br.com.fintechDeQuebraeconomy.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
        setAmount(amount);
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
        this.amount = amount.abs().negate();
    }

    @Override
        public String showTransaction(){
            return  String.format("""
                Descrição: %s
                Valor:  %.2f
                Data: %s
                Metodo de pagamento: %s
                Status do pagamento: %b
                Gasto Recorrente: %b
                """,getDescription(), getAmount().abs().setScale(2, RoundingMode.HALF_UP), getDate(), getPaymentMethod(),isPaymentStatus(), isRecurringPayment());
    }
}
