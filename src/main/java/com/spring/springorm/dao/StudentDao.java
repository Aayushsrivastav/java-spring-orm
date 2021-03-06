package com.spring.springorm.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.springorm.entities.Student;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	
	//save student
	@Transactional
	public int insert(Student student) {
		int i = (Integer) this.hibernateTemplate.save(student);
		return i;
	}
	
	//Get single object
	public Student getStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}
	
	//Get multiple object
	public List<Student> getAllStudents() {
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
	}
	
//	Delete method
	@Transactional
	public void deleteStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);
	}
	
//	Update student detail
	@Transactional
	public void updateStudent(Student student)
	{
		this.hibernateTemplate.update(student);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	
}
