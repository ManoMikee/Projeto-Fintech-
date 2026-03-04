import br.com.fintechDeQuebraeconomy.model.Expense;
import br.com.fintechDeQuebraeconomy.model.Income;
import br.com.fintechDeQuebraeconomy.model.Transaction;
import br.com.fintechDeQuebraeconomy.model.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public  class Main {
        public  static void main(String []args){
                Scanner sc = new Scanner (System.in);
                User user1 = null;
                Transaction gasto1 = null;
                int op;


                do{
                        System.out.println(String.format("""
                                Selecione a opção:
                                1- Cadastro:
                                2- Adicionar Gasto:
                                3- Exibir Transações:
                                4- Adicionar Receita
                                0- Sair.
                                """));



                        op = sc.nextInt();
                        sc.nextLine();

                        switch (op){
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
                                        String  email = sc.nextLine();
                                        System.out.println("Digite a senha: ");
                                        String senha = sc.nextLine();

                                         user1 = new User(name,cpf,email,senha,birthDay);

                                        System.out.println("Cadastrado com Sucesso.");
                                        break;

                                case 2:
                                        if(user1 == null){
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
                                        LocalDate transactionDay =  LocalDate.of(yearT,monthT,dayT);
                                        sc.nextLine();
                                        System.out.println("Metodo de pagamento: ");
                                        String paymentMethod = sc.nextLine();
                                        System.out.println("Status do do pagamento: ");
                                        boolean paymentStatus = sc.nextBoolean();
                                        System.out.println("Gasto recente: ");
                                        boolean recurringPayment = sc.nextBoolean();
                                         gasto1 = new Expense(transactionDay,amount,description,paymentMethod,paymentStatus,recurringPayment);
                                         user1.addTransaction(gasto1);
                                        break;

                                case 3:
                                        if(user1 == null){
                                                System.out.println("Cadastre um Usuário! ");
                                                break;
                                        }


                                        if(user1.getTransactions().isEmpty()){
                                                System.out.println("Cadastre uma transação!");
                                                break;
                                        }
                                        for(Transaction t : user1.getTransactions() ){
                                                System.out.println(t.showTransaction());
                                        }
;                                        break;

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

                        }
                }while(op != 0);
        }
}