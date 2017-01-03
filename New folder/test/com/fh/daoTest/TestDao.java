package com.fh.daoTest;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Random;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.fh.dao.Dao;
import com.fh.dao.impl.StudentDaoImpl;
import com.fh.domain.Classes;
import com.fh.domain.Course;
import com.fh.domain.Student;
import com.fh.utils.HibernateSessionUtil;

public class TestDao {
	@Test
	public void testStuDao() {
		Dao<Student> stuDao = new StudentDaoImpl();
		Student stu = new Student();
		stu.setName("fuhao");
		stu.setBirthday(new Date());
		stu.setHobbies("fsafs,java,c");
		stu.setEmail("ssss@gmail.cm");
		stu.setGender("fsfds");
		stu.setPassword("fhfhfhfh");
		stuDao.save(stu);
	}

	@Test
	public void testSave() {
		Session session = HibernateSessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Student student = new Student();
		student.setName("fuhao1");
		student.setGender("aaa");
		student.setPassword("fffff");
		student.setHobbies("java");
		session.save(student);
		session.evict(student);

		Date birthday = new Date();
		student.setBirthday(birthday);
		session.update(student);
		transaction.commit();
		session.close();
	}

	@Test
	public void testCommit() {
		Session session = HibernateSessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Student student = new Student();
		student.setName("fuhao1");
		student.setGender("aaa");
		student.setPassword("fffff");
		student.setHobbies("java");
		session.save(student);
		transaction.commit();
		Date birthday = new Date();
		student.setBirthday(birthday); // 在commit之后，对象状态变为游离态，再对对象进行操作，并不会反映到数据库里面。
		// 持久态并不表示立刻就向数据库里反应。update语句
		session.close();
	}

	@Test
	public void testUpdate() {
		Session session = HibernateSessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Student student = new Student();
		student.setName("fuhaoUPdate");
		student.setGender("aaa");
		student.setPassword("fffff");
		student.setHobbies("java");

		session.save(student);

		student.setBirthday(new Date());
		session.update(student);

		student.setBirthday(new GregorianCalendar(2016, 1, 2).getTime());

		session.update(student);
		// 使用了两次update语句,但只会调用一次update文。
		// 在这里写不写update其实效果一样，因为已经是持久态了。
		transaction.commit();

	}

	@Test
	public void testGet() {
		Session session = HibernateSessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Student student = session.get(Student.class, 1);// student没取到，不会报错。
		// student.setName("fuhaoChanged");
		// student.setGender("aaa");
		// student.setPassword("fffff");
		// student.setHobbies("java");
		//
		//
		// student.setBirthday(new Date());
		// session.update(student);
		//
		// student.setBirthday(new GregorianCalendar(2016,1,2).getTime());
		//
		session.update(student);// student为null，报错
		transaction.commit();

	}

	@Test
	public void testChangeId() {
		Session session = HibernateSessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Student student = session.get(Student.class, 10);// student没取到，不会报错。
		student.setName("aaafuhaoChanged");
		student.setGender("aaa");
		student.setPassword("fffff");
		student.setHobbies("java");

		student.setBirthday(new GregorianCalendar(2016, 1, 2).getTime());

		// 更改student的id
		student.setStuId(1111);
		// 会报错
		transaction.commit();

	}

	@Test
	public void testFlush1() {
		Session session = HibernateSessionUtil.getSession();
		Transaction transaction = session.beginTransaction();

		Student stu2 = new Student();
		stu2.setName("sfssdfa");
		stu2.setGender("male");
		stu2.setPassword("fffff");
		session.save(stu2); // insert 语句是在save的同时发给数据库的。

		Student stu1 = session.get(Student.class, 10);// get语句立刻发出select语句
		stu1.setName("asdsada");
		stu1.setGender("aaa");
		stu1.setPassword("fffff");
		stu1.setHobbies("java");

		stu1.setBirthday(new GregorianCalendar(2016, 1, 2).getTime());

		Student stu3 = session.get(Student.class, 10);// 由于是同一个副本，而且没有提交，因此并不发出select请求，而是直接在缓存中找。且返回的对象和stu1是同一个。

		System.out.println("stu1:" + stu1);
		System.out.println("stu3:" + stu3);

		transaction.commit();// 在commit时，发出update语句
		session.close();

	}

	@Test
	public void testFlush2() {
		Session session = HibernateSessionUtil.getSession();
		Transaction transaction = session.beginTransaction();

		Student stu2 = new Student();
		stu2.setName("sfssdfa");
		stu2.setGender("male");
		stu2.setPassword("fffff");
		session.save(stu2); // insert 语句是在save的同时发给数据库的。

		Student stu1 = session.get(Student.class, 10);// get语句立刻发出select语句
		stu1.setName("fffffffg");
		stu1.setGender("aaa");
		stu1.setPassword("fffff");
		stu1.setHobbies("java");

		stu1.setBirthday(new GregorianCalendar(2016, 1, 2).getTime());

		Student stu3 = session.get(Student.class, 10);// 由于是同一个副本，而且没有提交，因此并不发出select请求，而是直接在缓存中找。且返回的对象和stu1是同一个。

		System.out.println("stu1:" + stu1);
		System.out.println("stu3:" + stu3);

		session.flush();

		transaction.commit();// 在commit时，发出update语句
		session.close();

	}

	@Test
	public void testUpdate1() {
		Session session = HibernateSessionUtil.getSession();
		Transaction transaction = session.beginTransaction();

		Student stu1 = new Student();
		stu1.setStuId(Integer.valueOf("10"));
		stu1.setName("fffffffg");
		stu1.setGender("aaa");
		stu1.setPassword("fffff");
		stu1.setHobbies("javaaaaa");

		stu1.setBirthday(new GregorianCalendar(2016, 1, 2).getTime());

		session.update(stu1); // 在update的时候，会先select一下吗？ 答案：不会，不检查数据库里是否有相应的数据。

		Student stu3 = session.get(Student.class, 10);// 在update
														// stu1之后，再找id为10的对象，会发出select语句吗？不会，在update的时候也不会发出update语句。update是在flush之后做的。

		System.out.println("stu1:" + stu1);
		System.out.println("stu3:" + stu3);

		session.flush();

		transaction.commit();// 在commit时，发出update语句
		session.close();

	}

	@Test
	public void testSaveOrUpdate() {
		Session session = HibernateSessionUtil.getSession();
		Transaction transaction = session.beginTransaction();

		Student stu1 = new Student();
		stu1.setStuId(Integer.valueOf("10"));
		stu1.setName("fffffffg");
		stu1.setGender("aaa");
		stu1.setPassword("fffff");
		stu1.setHobbies("javaaaaa");

		stu1.setBirthday(new GregorianCalendar(2016, 1, 2).getTime());

		session.saveOrUpdate(stu1);// 在saveOrUpdate的时候，会先select一下吗？答案：不会

		Student stu3 = session.get(Student.class, 10);// 在update
														// stu1之后，再找id为10的对象，会发出select语句吗？不会，在update的时候也不会发出update语句。update是在flush之后做的。

		System.out.println("stu1:" + stu1);
		System.out.println("stu3:" + stu3);

		session.flush();

		transaction.commit();// 在commit时，发出update语句
		session.close();

	}

	@Test
	public void testUpdate3() {
		Session session = HibernateSessionUtil.getSession();
		Transaction transaction = session.beginTransaction();

		Student stu1 = new Student();
		stu1.setStuId(Integer.valueOf("10"));
		stu1.setName("fffffffg");
		stu1.setGender("aaa");
		stu1.setPassword("fffff");
		stu1.setHobbies("javaaaaa");

		stu1.setBirthday(new GregorianCalendar(2016, 1, 2).getTime());

		session.saveOrUpdate(stu1);// 在saveOrUpdate的时候，会先select一下吗？答案：不会

		session.flush();
		stu1.setEmail("fdsfsd");

		transaction.commit();// 在commit时，发出update语句
		session.close();

	}

	@Test
	public void testCascade() {
		Session session = HibernateSessionUtil.getSession();
		Classes clazz = new Classes();
		clazz.setClassName("my class21312");
		Set<Student> student = clazz.getStudent();

		Student e = new Student();
		e.setName("xiaowang");
		e.setGender("boy");
		e.setPassword("asasas");
		e.setBirthday(new Date());
		student.add(e);

		Student e2 = new Student();
		e2.setName("xiaowang");
		e2.setGender("boy");
		e2.setPassword("asasas");
		student.add(e2);

		clazz.setStudent(student);
		Transaction transaction = session.beginTransaction();

		session.save(clazz);
		transaction.commit();
		session.close();
	}

	@Test
	public void testCascadeUpdate() {
		Session session = HibernateSessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Classes clazz = session.get(Classes.class, new Integer(1));
		System.out.println(clazz.getClassName());
		Set<Student> studentSet = clazz.getStudent();
		for (Student eachStudent : studentSet) {
			eachStudent.setName(eachStudent.getName() + eachStudent.getStuId());
		}
		session.flush();
		transaction.commit();
		session.close();

	}

	@Test
	public void testChangeClasses() {
		Session session = HibernateSessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Classes clazz1 = session.get(Classes.class, new Integer(1));
		Classes clazz2 = session.get(Classes.class, new Integer(2));
		Set<Student> studentSet = clazz1.getStudent();
		clazz2.getStudent().addAll(studentSet);
		session.flush();
		transaction.commit();
		session.close();
	}

	@Test
	public void testManytoMany() {
		Session session = HibernateSessionUtil.getSession();
		Transaction transaction = session.beginTransaction();

		Student stu = new Student();
		stu.setName("asan");
		stu.setGender("shengjian");
		stu.setPassword("fasfds");
		stu.setPassword("pppp");

		Set<Course> course = new HashSet<Course>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 7363720334664877596L;

			{
				Course c = new Course();
				c.setCourseName("afds111");
				add(c);
			}
		};
		Classes classes = new Classes();
		classes.setClassName("dsaf");
		classes.getStudent().add(stu);
		
		stu.setCourse(course);
		
		session.save(stu);
		
		transaction.commit();
		session.close();
	}

}
