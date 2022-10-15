package edu.deakin.sit218.examgeneration.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import edu.deakin.sit218.examgeneration.entity.Exam;

public class ExamDAOImpl implements ExamDAO {

	SessionFactory factory;
	
	public ExamDAOImpl() {
		factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Exam.class)
				.buildSessionFactory();
	}
	
	
	@Override
	public void updateExam(Exam exam) {
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.update(exam);
			session.getTransaction().commit();
		}
		finally {
			session.close();
		}
	}

	@Override
	public void insertExam(Exam exam) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(exam);
			session.getTransaction().commit();
		}
		finally {
			session.close();
		}	
	}

	@Override
	public List<Exam> retrieveExam(String att) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		try {
			//use the session object to check for a client
			//start a transaction
			session.beginTransaction();
			
			//create the query
			String hql = "from Exam where attr = :att";
			Query<Exam> query = session.createQuery(hql);
			query.setParameter("att", att);
			//Obtain the query results
			List<Exam> exams = query.getResultList();

			return exams;
		}
		finally {
			session.close();
		}
	}

	@Override
	public boolean existsExam(Exam exam) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();		
		try {
			session.beginTransaction();
			//create the query
			String hql = "from Exam where ques = '"+
					exam.getQuestion()+"'";
			Query<Exam> query = session.createQuery(hql);
			//Obtain the query results
			List<Exam> exams = query.getResultList();
			return !exams.isEmpty();
		}
		finally {
			session.close();
		}
	}
}
