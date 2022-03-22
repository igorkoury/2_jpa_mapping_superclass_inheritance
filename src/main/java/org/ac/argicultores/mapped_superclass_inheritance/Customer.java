package org.ac.argicultores.mapped_superclass_inheritance;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer extends AbstractModel{

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
