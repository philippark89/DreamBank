package com.taejupark.dreambank.bankAccount;

import com.taejupark.dreambank.customer.Customer;
import com.taejupark.dreambank.transaction.Transaction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private double balance;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bankAccountId", referencedColumnName = "id")
    private List<Transaction> transaction;

    public BankAccount() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return id == that.id && Double.compare(that.balance, balance) == 0 && Objects.equals(transaction, that.transaction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balance, transaction);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", balance=" + balance +
                ", transaction=" + transaction +
                '}';
    }


//    @Override
//    public String toString() {
//        return "BankAccount{" +
//                "id=" + id +
//                ", balance=" + balance +
//                '}';
//    }
}
