package com.taejupark.dreambank.transaction;

import com.taejupark.dreambank.bankAccount.BankAccount;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private double amount;
    @NotNull
    private String transactionType;
    @NotNull
    private Date transactionTime = new Date();
    @NotNull
    private String note;
//    @ManyToOne(cascade = CascadeType.ALL)
//    private BankAccount bankAccount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

//    public BankAccount getBankAccount() {
//        return bankAccount;
//    }
//
//    public void setBankAccount(BankAccount bankAccount) {
//        this.bankAccount = bankAccount;
//    }

        @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return id == that.id && Double.compare(that.amount, amount) == 0 && Objects.equals(transactionType, that.transactionType) && Objects.equals(transactionTime, that.transactionTime) && Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, transactionType, transactionTime, note);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", transactionType='" + transactionType + '\'' +
                ", transactionTime=" + transactionTime +
                ", note='" + note + '\'' +
                '}';
    }


//    @Override
//    public String toString() {
//        return "Transaction{" +
//                "id=" + id +
//                ", amount=" + amount +
//                ", transactionType='" + transactionType + '\'' +
//                ", transactionTime=" + transactionTime +
//                ", note='" + note + '\'' +
//                ", bankAccount=" + bankAccount +
//                '}';
//    }
}
