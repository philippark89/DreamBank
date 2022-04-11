package com.taejupark.dreambank.model;

import javax.persistence.Entity;
import java.util.Objects;

public class Login {
    private long customer_id;
    private String emailAddress;
    private String password;

    public Login() {}

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login = (Login) o;
        return customer_id == login.customer_id && Objects.equals(emailAddress, login.emailAddress) && Objects.equals(password, login.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer_id, emailAddress, password);
    }
}
