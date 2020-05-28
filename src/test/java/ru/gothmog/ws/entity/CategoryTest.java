package ru.gothmog.ws.entity;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CategoryTest {
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
    public void persistCategory(){
        log.info("... persistCategory ...");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        // create a new Category entity
        Category category = new Category("Java Core Vol 1");
        // persist the category entity
        em.persist(category);

        em.getTransaction().commit();
        em.close();
    }
    @Test
    public void findUser() {
        log.info("... findCategory ...");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // get the primary key of a course
        Long categoryId = createCategory();

        // load Course entity by primary key
        Category category = em.find(Category.class, categoryId);

        log.info(category);

        em.getTransaction().commit();
        em.close();
    }

    private Long createCategory() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Category category = new Category("Java Core Vol 2");
        // persist the category entity
        em.persist(category);

        em.getTransaction().commit();
        em.close();
        return category.getId();
    }
}
