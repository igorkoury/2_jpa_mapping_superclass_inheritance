package org.ac.argicultores.mapped_superclass_inheritance;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account extends AbstractModel {

    private Double balance;


    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
