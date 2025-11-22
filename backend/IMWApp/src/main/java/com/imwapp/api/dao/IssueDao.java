package com.imwapp.api.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.imwapp.api.constant.IssuePriority;
import com.imwapp.api.constant.IssueStatus;
import com.imwapp.api.entity.Issue;

@Repository
public class IssueDao {

	private final SessionFactory sessionFactory;

	IssueDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Issue createIssue(Issue issue) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(issue); // save() returns Long, but we don't cast it
			tx.commit();
			return issue; // return the same object (now with ID)
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public Issue findById(long id) {
		Session session	=sessionFactory.openSession();
		Issue searchedIssue= session.get(Issue.class, id);	
		session.close();
		return searchedIssue;
	}

	public List<Issue> findAll() {
		 Session session = sessionFactory.openSession();
	        List<Issue> issueList = session.createQuery("from Issue", Issue.class).list();
	        session.close();
	        return issueList;
	}

	public List<Issue> findByPriority(IssuePriority priority) {
		Session session = sessionFactory.openSession();
		List<Issue> issuesList = session.createQuery("from Issue where priority = :priority", Issue.class)
				.setParameter("priority", priority).list();
		session.close();
		return issuesList;
	
	}

	public List<Issue> findByStatus(IssueStatus status) {
		
		 Session session = sessionFactory.openSession();
	        List<Issue> issuesList = session
	                .createQuery("from Issue where status = :status", Issue.class)
	                .setParameter("status", status)
	                .list();
	        session.close();
	        return issuesList;
		
	}

	public List<Issue> findByPriorityAndStatus(IssuePriority priority,IssueStatus status) {
		 Session session = sessionFactory.openSession();
	        List<Issue> issuesList = session
	                .createQuery("from Issue where priority = :priority and status = :status", Issue.class)
	                .setParameter("priority", priority)
	                .setParameter("status", status)
	                .list();
	        session.close();
	        return issuesList;
	}
	


	public Issue updateIssue(Issue existingIssue) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(existingIssue);
			tx.commit();
			return existingIssue;
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}
	
	public Issue deleteById(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Issue issueToDelete = session.get(Issue.class, id);
				session.delete(issueToDelete);
			tx.commit();
			return issueToDelete;
			
		} catch (Exception e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}
		
	}



}
