package com.fh.daoTest;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fh.domain.Customer;
import com.fh.utils.HibernateSessionUtil;

public class TestHql {

	private Session session = null;
	private Transaction transaction = null;
	private int count;

	@Before
	public void init() {
		session = HibernateSessionUtil.getSession();
		transaction = session.beginTransaction();
		count = session.getStatistics().getEntityCount();
	}

	@Test
	public void testList() {

		Query query = session.createQuery("from Customer");
		// Iterator<Customer> iterate = query.iterate();
		// while (iterate.hasNext()) {
		// Customer customer = iterate.next();
		// System.out.println(customer.getCustomname());
		//
		// }
		List<Customer> list = query.list();

		for (Customer customer : list) {
			System.out.println(customer);
		}
	}

	@Test
	public void testList2() {
		
		Query query = session.createQuery("select new List(c.name,c.age) from Customer c");
		List<List> list= query.list();
		for (List cList : list) {
			
			System.out.println(cList.get(0));
			System.out.println(cList.get(1));
		}
	}
	@Test
	public void testMap() {
		
		Query query = session.createQuery("select new Map(c.name,c.age) from Customer c");
		List<Map> list= query.list();
		for (Map map: list) {
			
			System.out.println(map.get("0"));
			System.out.println(map.get("1"));
		}
	}
	@Test
	public void testMapWithAlias() {
		
		Query query = session.createQuery("select new Map(c.name as name ,c.age as age) from Customer c");
		List<Map> list= query.list();
		for (Map map: list) {
			
			System.out.println(map.get("name"));
			System.out.println(map.get("age"));
		}
	}
	
	@Test
	public void testHqlReturnCustomer() {
		
		Query query = session.createQuery("select new Customer(c.name as name ,c.age as age) from Customer c");
		List<Map> list= query.list();
		for (Map map: list) {
			
			System.out.println(map.get("name"));
			System.out.println(map.get("age"));
		}
	}

	
	@After
	public void destory() {
		System.out.println("count:" + count);
		transaction.commit();
		session.close();
	}

}
