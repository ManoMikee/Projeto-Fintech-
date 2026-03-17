package br.com.fintechDeQuebraeconomy.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Teste {
    static void main(String[] args) {
        LocalDate bday = LocalDate.of(1994,9,27);
        LocalDate vence = LocalDate.of(2026,12,12);
        User usuario = new User("nico","445855","nicolasAlbuquerque@gmail.com", "827941",bday);
        LocalDate hoje = LocalDate.of(2025,12,12);


        //UTILIZAÇÃO DE POLIMORFISMO
        Transaction investimento2 = new Investment(hoje, new BigDecimal("1000"),"Cdb",vence,"tesouro","itau",true, new BigDecimal("20"));

        Transaction gasto2 = new Expense(hoje,new BigDecimal("3211"),"Gastei", "Crédito", true,false);
        Transaction goal2 = new Goal("Tete",hoje,new BigDecimal("200"),hoje);

        //DEFININDO TIPOS PARA TESTE DE METODOS.
        Investment investimento = new Investment(hoje, new BigDecimal("1000"),"Cdb",vence,"tesouro","itau",true, new BigDecimal("20"));

        Expense gasto = new Expense(hoje,new BigDecimal("3211"),"Gastei", "Crédito", true,false);
        Goal goal = new Goal("Tete",hoje,new BigDecimal("200"),hoje);


        usuario.addTransaction(investimento);
        usuario.addTransaction(gasto);
        usuario.addTransaction(goal);
        usuario.addTransaction(investimento2);
        usuario.addTransaction(gasto2);
        usuario.addTransaction(goal2);

        usuario.showTransactions();


        System.out.println("Rendimento bruto "+ investimento.calculateGrossReturn());
        System.out.println("Rendimento Líquido: "+ investimento.calculateNetReturn());
        System.out.println("Total ao recebimento: "+ investimento.calculateTotalAtMaturity());
        System.out.println("Taxa: " + investimento.calculateIncomeTax());
        System.out.println(goal.percentage());
        goal.setCurrentValue(new BigDecimal("100"));
        System.out.println(goal.percentage());
        System.out.println(gasto.getPaymentMethod());
        System.out.println(gasto.showTransaction());







    }
}
