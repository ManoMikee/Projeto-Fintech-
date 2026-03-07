package br.com.fintechDeQuebraeconomy.model;

// Importações
import java.math.RoundingMode;
import java.time.LocalDate;
import java.math.BigDecimal;

public class Goal extends Transaction {

    // Atributos
    private BigDecimal stipulatedAmount;
    private LocalDate endDate;
    private BigDecimal currentValue;

    // Construtor Vazio
    public Goal() {super();}

    // Construtor Cheio
    public Goal(String description, LocalDate date, BigDecimal stipulatedAmount, LocalDate endDate) {
        super(date, BigDecimal.ZERO , description);
        this.stipulatedAmount = stipulatedAmount;
        this.endDate = endDate;
        this.currentValue = BigDecimal.ZERO;
    }

    // Getters e Setters
    public BigDecimal getStipulatedAmount() {return stipulatedAmount;}

    public void setStipulatedAmount(BigDecimal stipulatedAmount) {
        if (stipulatedAmount == null) {
            System.out.println("Forneça um valor válido para seu Objetivo.");
        }

        if (stipulatedAmount.scale() <= 2 && stipulatedAmount. precision() <= 10 ){
            this.stipulatedAmount = stipulatedAmount;
        }
        else {
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
    @Override
    public void setAmount(BigDecimal amount){this.amount = amount; }

    @Override
    public String showTransaction(){
        return String.format("""
                Descrição: %s
                Valor: %.2f
                Data: %s
                Acumulado: %.2f
                Concluído: %b
                """,getDescription(), getAmount().negate(), getDate(), getCurrentValue(), goalAchieved());

    }

    public String showGoal() {
        return String.format("""
                Descrição: %s
                Meta: R$%s
                Concluído: %b
                Acumulado: R$%s
                Data Final: %s
                """, getDescription(), getStipulatedAmount(), goalAchieved(), getCurrentValue(), getEndDate());
    }

    public void addValue(BigDecimal amount){

        if (amount.compareTo(BigDecimal.ZERO) <= 0 ){
            System.out.println("Forneça um valor válido");
            return;
        }

            currentValue = currentValue.add(amount);

    }

    public BigDecimal surplus(){
        return currentValue.subtract(stipulatedAmount);
    }

    public boolean goalAchieved(){
        return currentValue.compareTo(stipulatedAmount) >= 0;
    }

    public BigDecimal percentage(){
        BigDecimal hundred = BigDecimal.valueOf(100);
        BigDecimal percent = currentValue.multiply(hundred).divide(stipulatedAmount,2, RoundingMode.HALF_UP);
        return percent;
    }

    // Cópia | Registro
    public Goal(Goal other) {
        super(LocalDate.now(), other.amount, other.description);
        this.stipulatedAmount = other.stipulatedAmount;
        this.endDate = other.endDate;
        this.currentValue = other.currentValue;
    }

}
