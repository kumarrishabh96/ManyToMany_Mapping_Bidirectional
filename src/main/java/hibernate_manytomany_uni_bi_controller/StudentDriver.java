package hibernate_manytomany_uni_bi_controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hibernate_manytomany_uni_bi_dto.Student;
import hibernate_manytomany_uni_bi_dto.Teacher;

public class StudentDriver {
public static void main(String[] args) {
		
		Teacher teacher1= new Teacher();
		teacher1.setId(1);
		teacher1.setName("Abhishek Kumar");
		teacher1.setNumber(12345);
		teacher1.setAddress("Patna");
		
		Teacher teacher2 = new Teacher();
		teacher2.setId(2);
		teacher2.setName("Kartik");
		teacher2.setNumber(67890);
		teacher2.setAddress("Bangalore");
		
		Teacher teacher3 = new Teacher();
		teacher3.setId(3);
		teacher3.setName("Kumar Rishabh");
		teacher3.setNumber(34567);
		teacher3.setAddress("Patna");
		
		Student student1 = new Student();
		student1.setId(101);
		student1.setName("Anunay");
		student1.setPhone(98765);
		student1.setAddress("Patna");
		
		Student student2 = new Student();
		student2.setId(102);
		student2.setName("Ashutosh");
		student2.setPhone(23456);
		student2.setAddress("Patna");
		
		Student student3 = new Student();
		student3.setId(103);
		student3.setName("Shashank");
		student3.setPhone(87654);
		student3.setAddress("Bangalore");
		
		List<Teacher>tl1 = new ArrayList<Teacher>();
		tl1.add(teacher1);
		tl1.add(teacher2);
		student1.setList(tl1);
		
		List<Teacher>tl2 = new ArrayList<Teacher>();
		tl2.add(teacher1);
		tl2.add(teacher3);
		student2.setList(tl2);
		
		List<Teacher>tl3 = new ArrayList<Teacher>();
		tl3.add(teacher1);
		tl3.add(teacher2);
		tl3.add(teacher3);
		student3.setList(tl3);
		
		List<Student> sl1= new ArrayList<Student>();
		sl1.add(student1);
		sl1.add(student2);
		teacher1.setStudents(sl1);
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("emp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(teacher1);
		entityManager.persist(teacher2);
		entityManager.persist(teacher3);
		entityManager.persist(student1);
		entityManager.persist(student2);
		entityManager.persist(student3);
		entityTransaction.commit();
}
}