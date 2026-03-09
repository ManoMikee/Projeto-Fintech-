package br.com.fintechDeQuebraeconomy.model;

// Importações
import java.math.RoundingMode;
import java.time.LocalDate;
import java.math.BigDecimal;

public class Goal extends Transaction{

    // Atributos
    private String title;
    private BigDecimal stipulatedAmount;
    private LocalDate endDate;
    private BigDecimal currentValue;

    // Construtor Vazio
    public Goal() {super();}

    @Override
    public void setAmount(BigDecimal amount) {

    }

    @Override
    public String showTransaction() {
        return "";
    }

    // Construtor Cheio
    public Goal(LocalDate date,BigDecimal amount, String description ,String title, BigDecimal stipulatedAmount, LocalDate endDate) {
        super(date, amount, description);
        this.title = title;
        this.stipulatedAmount = stipulatedAmount;
        this.endDate = endDate;
        this.currentValue = BigDecimal.ZERO;
    }


    // Getters e Setters
    public String getTitle(){return title;}

    public void setTitle(String title){
        if (title == null || title.trim().isEmpty()){
            System.out.println("Adicione um válido título ao seu objetivo.");
        }
        else{ this.title = title; }
    }

    public BigDecimal getStipulatedAmount() {return stipulatedAmount;}

    public void setStipulatedAmount(BigDecimal stipulatedAmount) {
        if (stipulatedAmount.scale() <= 2 && stipulatedAmount. precision() <= 10 ){
            this.stipulatedAmount = stipulatedAmount;
        }
        else if (stipulatedAmount == null){
            System.out.println("Forneça um valor válido para seu Objetivo.");
        }
        else if (stipulatedAmount.precision() > 10){
            System.out.println("Valor estipulado excede o limite permitido.");
        }

    }

    public LocalDate getEndDate() {return endDate;}

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getCurrentValue(){return currentValue;}

    public void setCurrentValue(BigDecimal currentValue){
        this.currentValue = currentValue;
    }

    // Outros Métodos

    public void addValue(BigDecimal amout){
        if (amout.compareTo(BigDecimal.ZERO) <= 0 ){
            System.out.println("O valor fornecido é menor ou igual a 0");
            System.out.println("Forneça um valor válido");
        }
        else {
            currentValue = currentValue.add(amout);
        }
    }

    public BigDecimal surplus(){
        return currentValue.subtract(stipulatedAmount);
    }

    public boolean goalAchieved(){
        boolean status = false;
        if (currentValue.compareTo(stipulatedAmount) >= 0){
            status = true;
        }
        return status;
    }

    public BigDecimal percentage(){
        BigDecimal hundred = new BigDecimal(100);
        BigDecimal percent = currentValue.multiply(hundred).divide(stipulatedAmount,2, RoundingMode.HALF_UP);
        return percent;
    }

}
