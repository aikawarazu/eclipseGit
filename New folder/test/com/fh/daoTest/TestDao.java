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
		student.setBirthday(birthday); // ��commit֮�󣬶���״̬��Ϊ����̬���ٶԶ�����в����������ᷴӳ�����ݿ����档
		// �־�̬������ʾ���̾������ݿ��ﷴӦ��update���
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
		// ʹ��������update���,��ֻ�����һ��update�ġ�
		// ������д��дupdate��ʵЧ��һ������Ϊ�Ѿ��ǳ־�̬�ˡ�
		transaction.commit();

	}

	@Test
	public void testGet() {
		Session session = HibernateSessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Student student = session.get(Student.class, 1);// studentûȡ�������ᱨ��
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
		session.update(student);// studentΪnull������
		transaction.commit();

	}

	@Test
	public void testChangeId() {
		Session session = HibernateSessionUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Student student = session.get(Student.class, 10);// studentûȡ�������ᱨ��
		student.setName("aaafuhaoChanged");
		student.setGender("aaa");
		student.setPassword("fffff");
		student.setHobbies("java");

		student.setBirthday(new GregorianCalendar(2016, 1, 2).getTime());

		// ����student��id
		student.setStuId(1111);
		// �ᱨ��
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
		session.save(stu2); // insert �������save��ͬʱ�������ݿ�ġ�

		Student stu1 = session.get(Student.class, 10);// get������̷���select���
		stu1.setName("asdsada");
		stu1.setGender("aaa");
		stu1.setPassword("fffff");
		stu1.setHobbies("java");

		stu1.setBirthday(new GregorianCalendar(2016, 1, 2).getTime());

		Student stu3 = session.get(Student.class, 10);// ������ͬһ������������û���ύ����˲�������select���󣬶���ֱ���ڻ������ҡ��ҷ��صĶ����stu1��ͬһ����

		System.out.println("stu1:" + stu1);
		System.out.println("stu3:" + stu3);

		transaction.commit();// ��commitʱ������update���
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
		session.save(stu2); // insert �������save��ͬʱ�������ݿ�ġ�

		Student stu1 = session.get(Student.class, 10);// get������̷���select���
		stu1.setName("fffffffg");
		stu1.setGender("aaa");
		stu1.setPassword("fffff");
		stu1.setHobbies("java");

		stu1.setBirthday(new GregorianCalendar(2016, 1, 2).getTime());

		Student stu3 = session.get(Student.class, 10);// ������ͬһ������������û���ύ����˲�������select���󣬶���ֱ���ڻ������ҡ��ҷ��صĶ����stu1��ͬһ����

		System.out.println("stu1:" + stu1);
		System.out.println("stu3:" + stu3);

		session.flush();

		transaction.commit();// ��commitʱ������update���
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

		session.update(stu1); // ��update��ʱ�򣬻���selectһ���� �𰸣����ᣬ��������ݿ����Ƿ�����Ӧ�����ݡ�

		Student stu3 = session.get(Student.class, 10);// ��update
														// stu1֮������idΪ10�Ķ��󣬻ᷢ��select����𣿲��ᣬ��update��ʱ��Ҳ���ᷢ��update��䡣update����flush֮�����ġ�

		System.out.println("stu1:" + stu1);
		System.out.println("stu3:" + stu3);

		session.flush();

		transaction.commit();// ��commitʱ������update���
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

		session.saveOrUpdate(stu1);// ��saveOrUpdate��ʱ�򣬻���selectһ���𣿴𰸣�����

		Student stu3 = session.get(Student.class, 10);// ��update
														// stu1֮������idΪ10�Ķ��󣬻ᷢ��select����𣿲��ᣬ��update��ʱ��Ҳ���ᷢ��update��䡣update����flush֮�����ġ�

		System.out.println("stu1:" + stu1);
		System.out.println("stu3:" + stu3);

		session.flush();

		transaction.commit();// ��commitʱ������update���
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

		session.saveOrUpdate(stu1);// ��saveOrUpdate��ʱ�򣬻���selectһ���𣿴𰸣�����

		session.flush();
		stu1.setEmail("fdsfsd");

		transaction.commit();// ��commitʱ������update���
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
