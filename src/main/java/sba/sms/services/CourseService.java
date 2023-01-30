package sba.sms.services;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import sba.sms.dao.CourseI;
import sba.sms.models.Course;
import sba.sms.utils.HibernateUtil;

public class CourseService implements CourseI {

	@Override
	public void createCourse(Course course) {
		
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(course);
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
	public Course getCourseById(int courseId) {
		
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		Course course = new Course();
		
		try {
			tx = session.beginTransaction();
			Query<Course> query = session.createQuery("FROM Course WHERE id =:id", Course.class);
			query.setParameter("id", courseId);
			
			course = query.getSingleResult();
			tx.commit();
			
		} catch (HibernateException exception) {
			tx.rollback();
			exception.printStackTrace();
		}finally {
			session.close();
		}
		return course;
	}

	@Override
	public List<Course> getAllCourses() {
		
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		List<Course> result = null;
		
		try {
			tx = session.beginTransaction();
			Query<Course> query = session.createQuery("FROM Course", Course.class);
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
}
