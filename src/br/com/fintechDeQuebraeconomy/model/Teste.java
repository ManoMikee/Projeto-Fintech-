package br.com.fintechDeQuebraeconomy.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Teste {
    static void main() {
        LocalDate bday = LocalDate.of(1994,9,27);
        User usuario = new User("nico","44605025855","Contact.nicolasAlbuquerque@gmail.com", "826487941",bday);
        LocalDate hoje = LocalDate.of(2025,12,12);

        LocalDate vence = LocalDate.of(2026,12,12);
        Transaction investimento = new Investment(hoje, new BigDecimal("1000"),"Cdb",vence,"tesouro","itau",true, new BigDecimal("20"));
        Transaction investimento2 = new Investment(hoje, new BigDecimal("1000"),"Cdb",vence,"tesouro","itau",true, new BigDecimal("20"));
        Transaction investimento3 = new Investment(hoje, new BigDecimal("1000"),"Cdb",vence,"tesouro","itau",true, new BigDecimal("20"));
        Transaction investimento4 = new Investment(hoje, new BigDecimal("1000"),"Cdb",vence,"tesouro","itau",true, new BigDecimal("20"));
        Transaction investimento5 = new Investment(hoje, new BigDecimal("1000"),"Cdb",vence,"tesouro","itau",true, new BigDecimal("20"));


        usuario.addTransaction(investimento);
        usuario.addTransaction(investimento2);
        usuario.addTransaction(investimento3);
        usuario.addTransaction(investimento4);
        usuario.addTransaction(investimento5);


        usuario.showTransactions();

    }
}
