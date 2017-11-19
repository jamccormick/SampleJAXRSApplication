package com.sample.dao;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Resource;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.sample.entity.GreetingEntity;

@Dependent
public class HelloDAO {
	
	private static final AtomicInteger COUNT = new AtomicInteger(0);
	
	@PersistenceContext(unitName="MyApplication")
	private EntityManager em;
	
	@Resource
	private UserTransaction ut;
	
	public String getGreeting() {
		GreetingEntity ge = em.find(GreetingEntity.class, 1);
		return ge.getGreeting();
	}
	
	public int postGreeting(String greeting) {
		GreetingEntity ge = new GreetingEntity();
		ge.setGreeting(greeting);
		ge.setId(COUNT.incrementAndGet());
		try {
			ut.begin();
			em.persist(ge);
			ut.commit();
		} catch (NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ge.getId();
	}

}
