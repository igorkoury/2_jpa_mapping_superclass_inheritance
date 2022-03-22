package org.ac.argicultores.mapped_superclass_inheritance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import java.sql.Date;

public class Test {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("mapped_superclass_inheritance");

    public static void main(String[] args) {

        Account account = new Account();
        Customer customer = new Customer();

        account.setId(1);
        account.setBalance(500.00);
        account.setCreationTime(new Date(System.currentTimeMillis()));
        account.setUpdateTime(new Date(System.currentTimeMillis()));
        account.setVersion(1);

        customer.setName("Igor");
        customer.setCreationTime(new Date(System.currentTimeMillis()));
        customer.setId(1);
        customer.setUpdateTime(new Date(System.currentTimeMillis()));
        customer.setVersion(1);

        Test test = new Test();

        test.save(account);
        test.save(customer);

        System.out.println(test.fetch(1).toString());
    }

    public void save(AbstractModel instance) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(instance);
            em.getTransaction().commit();

        } catch (RollbackException ex) {
            em.getTransaction().rollback();

        } finally {
            em.close();
        }
    }

    public AbstractModel fetch(Integer id) {

        EntityManager em = emf.createEntityManager();

        try{

            return em.find(AbstractModel.class,id);

        } finally {

            em.close();
        }
    }
}