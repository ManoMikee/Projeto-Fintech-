import br.com.fintechDeQuebraeconomy.model.Expense;
import br.com.fintechDeQuebraeconomy.model.Goal;
import br.com.fintechDeQuebraeconomy.model.Income;
import br.com.fintechDeQuebraeconomy.model.Transaction;
import br.com.fintechDeQuebraeconomy.model.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public  class Main {
        public  static void main(String []args) {
                Scanner sc = new Scanner(System.in);
                List<Goal> listGoals = new ArrayList<>();
                Goal goal = new Goal();
                User user1 = null;
                Transaction gasto1 = null;
                int op;


                do {
                        System.out.println(String.format("""
                                Selecione a opção:
                                1- Cadastro:
                                2- Adicionar Gasto:
                                3- Exibir Transações:
                                4- Adicionar Receita
                                5- Objetivos
                                0- Sair.
                                """));


                        op = sc.nextInt();
                        sc.nextLine();

                        switch (op) {
                                case 0:
                                        System.out.println("Finalizando.");
                                        break;
                                case 1:
                                        System.out.println("Informe seu nome: ");
                                        String name = sc.nextLine();
                                        System.out.println("Digite o dia do seu aniversário");
                                        int day = sc.nextInt();
                                        sc.nextLine();
                                        System.out.println("Digite o mês do seu aniversário");
                                        int month = sc.nextInt();
                                        sc.nextLine();
                                        System.out.println("Digite o ano do seu aniversário");
                                        int year = sc.nextInt();
                                        sc.nextLine();
                                        LocalDate birthDay = LocalDate.of(year, month, day);
                                        System.out.println("Digite seu cpf: ");
                                        String cpf = sc.nextLine();
                                        System.out.println("Digite seu email: ");
                                        String email = sc.nextLine();
                                        System.out.println("Digite a senha: ");
                                        String senha = sc.nextLine();

                                        user1 = new User(name, cpf, email, senha, birthDay);

                                        System.out.println("Cadastrado com Sucesso.");
                                        break;

                                case 2:
                                        if (user1 == null) {
                                                System.out.println("Cadastre um usuário primeiro.");
                                        }
                                        System.out.println("ADICIONAR GASTO");
                                        System.out.println("Digite o valor");
                                        BigDecimal amount = sc.nextBigDecimal();
                                        sc.nextLine();
                                        System.out.println("Descrição/ Nome: ");
                                        String description = sc.nextLine();
                                        System.out.println("Digite o dia: ");
                                        int dayT = sc.nextInt();
                                        sc.nextLine();
                                        System.out.println("Digite o mês: ");
                                        int monthT = sc.nextInt();
                                        sc.nextLine();
                                        System.out.println("Digite o ano: ");
                                        int yearT = sc.nextInt();
                                        LocalDate transactionDay = LocalDate.of(yearT, monthT, dayT);
                                        sc.nextLine();
                                        System.out.println("Metodo de pagamento: ");
                                        String paymentMethod = sc.nextLine();
                                        System.out.println("Status do do pagamento: true/false");
                                        boolean paymentStatus = sc.nextBoolean();
                                        System.out.println("Gasto recente: true/false");
                                        boolean recurringPayment = sc.nextBoolean();
                                        gasto1 = new Expense(transactionDay, amount, description, paymentMethod, paymentStatus, recurringPayment);
                                        user1.addTransaction(gasto1);
                                        break;

                                case 3:
                                        if (user1 == null) {
                                                System.out.println("Cadastre um Usuário! ");
                                                break;
                                        }
                         
                                        if (gasto1 == null) {
                                                System.out.println("Cadastre uma transação!");
                                                break;
                                        }
                                        for (Transaction t : user1.getTransactions()) {
                                                System.out.println(t.showTransaction());
                                        }
                                        break;
                          
                                case 4:
                                        if(user1 == null){
                                                System.out.println("Cadastre um usuário primeiro.");
                                                break;
                                        }

                                        System.out.println("ADICIONAR RECEITA");

                                        System.out.println("Digite o valor:");
                                        BigDecimal amountR = sc.nextBigDecimal();
                                        sc.nextLine();

                                        System.out.println("Descrição:");
                                        String descriptionR = sc.nextLine();

                                        System.out.println("Digite o dia:");
                                        int dayR = sc.nextInt();
                                        sc.nextLine();

                                        System.out.println("Digite o mês:");
                                        int monthR = sc.nextInt();
                                        sc.nextLine();

                                        System.out.println("Digite o ano:");
                                        int yearR = sc.nextInt();
                                        sc.nextLine();

                                        LocalDate dateR = LocalDate.of(yearR, monthR, dayR);

                                        System.out.println("Fonte da receita:");
                                        String source = sc.nextLine();

                                        Transaction receita = new Income(dateR, amountR, descriptionR, source);

                                        user1.addTransaction(receita);

                                        System.out.println("Receita adicionada com sucesso.");
                                        break;


                                        case 5:
                                               if (user1 == null) {
                                                       System.out.println("Cadastre um Usuário! ");
                                                       System.out.println(" ");
                                                        break;
                                               }

                                                System.out.println(String.format("""        
                                                               Selecione a opção:
                                                               1- Adicionar novo objetivo
                                                               2- Adicionar valor a um Objetivo
                                                        """));

                                                int op2 = sc.nextInt();
                                                sc.nextLine();

                                                switch (op2) {
                                                        case 1:
                                                                System.out.println("ADICIONAR NOVO OBJETIVO");
                                                                System.out.println("Descrição / Nome: ");
                                                                String description1 = sc.nextLine();
                                                                System.out.println("Digite o valor do Objetivo: ");
                                                                BigDecimal amount2 = sc.nextBigDecimal();
                                                                sc.nextLine();
                                                                System.out.println("Digite o Dia: ");
                                                                int day2 = sc.nextInt();
                                                                sc.nextLine();
                                                                System.out.println("Digite o Mês: ");
                                                                int month2 = sc.nextInt();
                                                                sc.nextLine();
                                                                System.out.println("Digite o Ano: ");
                                                                int year2 = sc.nextInt();
                                                                sc.nextLine();
                                                                System.out.println("Informe o dia final da seu objetivo: ");
                                                                int dayG = sc.nextInt();
                                                                sc.nextLine();
                                                                System.out.println("Informe o mês final da seu objetivo: ");
                                                                int monthG = sc.nextInt();
                                                                sc.nextLine();
                                                                System.out.println("Informe o ano final da seu objetivo: ");
                                                                int yearG = sc.nextInt();
                                                                LocalDate date2 = LocalDate.of(year2, month2, day2);
                                                                LocalDate GoalDay = LocalDate.of(yearG, monthG, dayG);
                                                                sc.nextLine();
                                                                Goal newGoal = new Goal(description1, date2, amount2, GoalDay);
                                                                listGoals.add(newGoal);
                                                                System.out.println("Objetivo criado com sucesso!");
                                                                System.out.println();

                                                                break;

                                                        case 2:
                                                                if (listGoals.isEmpty()) {
                                                                        System.out.println("Você ainda não possui objetivos cadastrados.");
                                                                        System.out.println(" ");
                                                                        break;
                                                                } else {
                                                                        System.out.println("ESCOLHA UM OBJETIVO: ");
                                                                        for (int i = 0; i < listGoals.size(); i++) {
                                                                                Goal theGoal = listGoals.get(i);
                                                                                System.out.printf("""
                                                                                        %d.
                                                                                        %s
                                                                                        
                                                                                        """, (i + 1), theGoal.showGoal());
                                                                        }

                                                                        int op3 = sc.nextInt();
                                                                        sc.nextLine();

                                                                        Goal addGoal = listGoals.get(op3 -1);

                                                                        System.out.println("Digite o valor que deseja adicionar: ");
                                                                        BigDecimal amount3 = sc.nextBigDecimal();
                                                                        sc.nextLine();

                                                                        addGoal.addValue(amount3);

                                                                        Goal transactionGoal = new Goal(addGoal);

                                                                        transactionGoal.setAmount(amount3);
                                                                        transactionGoal.setCurrentValue(addGoal.getCurrentValue());

                                                                        user1.addTransaction(transactionGoal);

                                                                        gasto1 = transactionGoal;


                                                                        if (addGoal.goalAchieved()){
                                                                                BigDecimal surplus = addGoal.surplus();

                                                                                if (surplus.compareTo(BigDecimal.ZERO) > 0){
                                                                                        System.out.printf("""
                                                                                               Meta atingida!
                                                                                               %s
                                                                                               Meta: R$%.2f | Progresso: 100%%
                                                                                               Você ultrapassou em R$%.2f
                                                                                               
                                                                                               """, addGoal.getDescription(), addGoal.getStipulatedAmount(), addGoal.surplus());

                                                                                } else{
                                                                                        System.out.printf("""
                                                                                               Meta atingida com sucesso!
                                                                                               %s
                                                                                               Meta: R$%.2f | Progresso: %.2f%%
                                                                                               
                                                                                                """, addGoal.getDescription(), addGoal.getStipulatedAmount() ,addGoal.percentage());
                                                                                }

                                                                        }else{
                                                                                System.out.printf("""
                                                                                        Valor adicionado com sucesso!
                                                                                        %s
                                                                                        Valor acumulado: R$%s | Progresso: %.2f%%
                                                                                        
                                                                                        """, addGoal.getDescription(), addGoal.getCurrentValue(), addGoal.percentage());
                                                                        }


                                                                }

                                                break;
                                                }


                                        }
                } while (op != 0);
        }
}
                                                                 