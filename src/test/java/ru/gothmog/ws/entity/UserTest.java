package ru.gothmog.ws.entity;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserTest {
    Logger log = Logger.getLogger(this.getClass().getName());
    private EntityManagerFactory emf;

    @Before
    public void init() {
        emf = Persistence.createEntityManagerFactory("BookStoreWebsite");
    }

    @After
    public void close() {
        emf.close();
    }
    @Test
    public void persistUser(){
        log.info("... persistUser ...");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // create a new User entity
        User user = new User();
        user.setEmail("test@gmail.com");
        user.setFirstName("Test");
        user.setLastName("Test");
        user.setPassword("Admin_123");
       // persist the user entity
        em.persist(user);

        em.getTransaction().commit();
        em.close();
    }

    @Test
    public void findUser() {
        log.info("... findUser ...");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // get the primary key of a course
        Long userId = createUser();

        // load Course entity by primary key
        User user = em.find(User.class, userId);

        log.info(user);

        em.getTransaction().commit();
        em.close();
    }

    private Long createUser() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User user = new User();
        user.setEmail("test1@gmail.com");
        user.setFirstName("Test1");
        user.setLastName("Test1");
        user.setPassword("Admin_123");
        // persist the user entity
        em.persist(user);

        em.getTransaction().commit();
        em.close();
        return user.getId();
    }
}
