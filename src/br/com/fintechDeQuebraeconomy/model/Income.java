package br.com.fintechDeQuebraeconomy.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Income extends Transaction {

    private String source;

    public Income() {
        super();
    }

    public Income(LocalDate date, BigDecimal amount, String description, String source, Category category) {
        super(date, amount, description, category);
        this.source = source;

    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }



    @Override
    public String showTransaction() {

        return String.format("""
                %s:
                Descrição: %s
                Valor:  %.2f
                Data: %s
                Fonte: %s
                """,getCategory(),
                getDescription(),
                getAmount(),
                getDate(),
                getSource());
    }
}