package sba.sms.services;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import sba.sms.dao.StudentI;
import sba.sms.models.Course;
import sba.sms.models.Student;
import sba.sms.utils.HibernateUtil;

public class StudentService implements StudentI {

	 private static final CourseService courseService = new CourseService();
	
	@Override
	public List<Student> getAllStudents() {
		
		// TODO Auto-generated method stub
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		List<Student> result = null;
		
		try {
			
			tx = session.beginTransaction();
			Query<Student> query = session.createQuery("FROM Student", Student.class);
			result = query.getResultList();
			tx.commit();
			
		} catch (HibernateException exception) {
				tx.rollback();
				exception.printStackTrace();
		} finally {
			session.close();
		}

		return result;
	}

	@Override
	public void createStudent(Student student) {
		
		// TODO Auto-generated method stub
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction tx = null;
				try {
					
					tx = session.beginTransaction();
					session.persist(student);
					tx.commit();
					
				} catch (HibernateException exception) {
					if (tx != null) {
						tx.rollback();
						exception.printStackTrace();
					}
				} finally {
					session.close();
				}
		
	}

	@Override
	public Student getStudentByEmail(String email) {
		
		// TODO Auto-generated method stub
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction tx = null;
				
				Student student = new Student();
				
				try {
					tx = session.beginTransaction();
					Query<Student> query = session.createQuery("FROM Student WHERE email = :email", Student.class);
					query.setParameter("email", email);
					
					student = query.getSingleResult();
					tx.commit();
					
				} catch (HibernateException exception) {
					if (tx != null) {
						tx.rollback();
					}
					exception.printStackTrace();
				}finally {
					session.close();
				}
				return student;
	}

	@Override
	public boolean validateStudent(String email, String password) {
		
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		boolean result = false;
		
		try {
			
			Student student = getStudentByEmail(email);
			if (student != null) {
				if (student.getEmail().equals(email)
				&& student.getPassword().equals(password)) {
					result = true;
				}
			}
			else {
				result = false;
			}
			
		} catch (HibernateException exception) {
			result = false;
		} finally {
			session.close();
		}
	
		return result;
	}

	@Override
	public void registerStudentToCourse(String email, int courseId) {
		
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;	
		
		try {
			
			tx = session.beginTransaction();
			Student student = getStudentByEmail(email);
			student.addCourse(courseService.getCourseById(courseId));
			session.merge(student);
			tx.commit();
		} catch(HibernateException exception) {
			tx.rollback();
			exception.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public List<Course> getStudentCourses(String email) {
		
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;	
		
		
		List<Course> result = null;
		Student student = new Student();
		
		try {
			
			tx = session.beginTransaction();
			student = session.get(Student.class, email);
			result = student.getCourses();
			tx.commit();
			
		} catch (HibernateException exception) {
			if (tx != null) {
				tx.rollback();
				exception.printStackTrace();
			}

		} finally {
			session.close();
		}
		
		
		return result;
	}

}
