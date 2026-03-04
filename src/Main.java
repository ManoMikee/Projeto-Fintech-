import br.com.fintechDeQuebraeconomy.model.Expense;
import br.com.fintechDeQuebraeconomy.model.Goal;
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
                                3- Exibir Transações
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
                                                System.out.println("Cadastre um usu[ario primeiro.");
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
                                        System.out.println("Digite o mês do seu aniversário");
                                        int monthT = sc.nextInt();
                                        sc.nextLine();
                                        System.out.println("Digite o ano do seu aniversário");
                                        int yearT = sc.nextInt();
                                        LocalDate transactionDay = LocalDate.of(yearT, monthT, dayT);
                                        sc.nextLine();
                                        System.out.println("Metodo de pagamento: ");
                                        String paymentMethod = sc.nextLine();
                                        System.out.println("Statudo do pagamento: ");
                                        boolean paymentStatus = sc.nextBoolean();
                                        System.out.println("Gasto recente: ");
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
                                                                System.out.println("Digite um título para seu objetivo: ");
                                                                String title = sc.nextLine();
                                                                System.out.println("Digite o valor do Objetivo: ");
                                                                BigDecimal amount2 = sc.nextBigDecimal();
                                                                sc.nextLine();
                                                                System.out.println("Informe o dia final da seu objetivo: ");
                                                                int dayG = sc.nextInt();
                                                                sc.nextLine();
                                                                System.out.println("Informe o mês final da seu objetivo: ");
                                                                int monthG = sc.nextInt();
                                                                sc.nextLine();
                                                                System.out.println("Informe o ano final da seu objetivo: ");
                                                                int yearG = sc.nextInt();
                                                                LocalDate GoalDay = LocalDate.of(yearG, monthG, dayG);
                                                                sc.nextLine();
                                                                Goal newGoal = new Goal(title, amount2, GoalDay);
                                                                listGoals.add(newGoal);
                                                                System.out.println("Objetivo criado com sucesso!");
                                                                System.out.println(" ");

                                                                break;

                                                        case 2:
                                                                if (listGoals == null) {
                                                                        System.out.println("Você ainda não possui objetivos cadastrados.");
                                                                        System.out.println(" ");
                                                                        break;
                                                                }
                                                                else{
                                                                        System.out.println("ESCOLHA UM OBJETIVO: ");
                                                                        for (int i = 0; i < listGoals.size(); i++){
                                                                                Goal theGoal = listGoals.get(i);

                                                                              System.out.println((i + 1) + "- " + theGoal.getTitle()
                                                                                      + " = Meta: R$"
                                                                                      + theGoal.getStipulatedAmount()
                                                                                      + " | Conluído: "
                                                                                      + theGoal.goalAchieved()
                                                                                      + " | Acumulado: R$"
                                                                                      + theGoal.getCurrentValue()
                                                                                      + " | Data final: "
                                                                                      + theGoal.getEndDate());
                                                                        }
                                                                        System.out.println(" ");

                                                                        int op3 = sc.nextInt();
                                                                        sc.nextLine();

                                                                        Goal addTargetValue = listGoals.get(op3 -1);

                                                                        System.out.println("Digite o valor que deseja adicionar: ");
                                                                        BigDecimal amount3 = sc.nextBigDecimal();
                                                                        sc.nextLine();

                                                                        addTargetValue.addValue(amount3);

                                                                        if (addTargetValue.goalAchieved()){
                                                                                BigDecimal surplus = addTargetValue.surplus();

                                                                                if (surplus.compareTo(BigDecimal.ZERO) > 0){
                                                                                        System.out.println("Meta atingida!");
                                                                                        System.out.println("Você ultrapassou em R$" + surplus);
                                                                                } else{
                                                                                        System.out.println("Meta atingida com sucesso!");
                                                                                }

                                                                        }else{
                                                                                System.out.println("Valor adicionaldo com sucesso!");
                                                                                System.out.println("Total acumulado atual: R$" + addTargetValue.getCurrentValue() + " | Progresso: " + addTargetValue.percentage() + "%");
                                                                        }

                                                                }

                                                break;
                                                }


                                        }
                } while (op != 0);
        }
}