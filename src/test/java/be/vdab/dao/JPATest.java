package be.vdab.dao;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.vdab.entities.Brouwer;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/dao.xml") 
public class JPATest {
private EntityManager entityManager;
@PersistenceContext 
public void setEntityManager(EntityManager entityManager) { 
this.entityManager = entityManager;
}
@Test
public void test() {
entityManager.find(Brouwer.class, 1L); 
}
}
