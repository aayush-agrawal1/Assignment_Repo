package com.assignment.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.assignment.entity.AssignmentEntity;

public class AssignmentDAO implements AssignmentDAOInterface{

	@Override
	public int createProfileDAO(AssignmentEntity w) {
		// TODO Auto-generated method stub
		int i=0;
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		EntityTransaction et=ss.getTransaction();
		et.begin();
		ss.save(w);
		et.commit();
		i=1;
		return i;
	}

	@Override
	public boolean loginProfileDAO(AssignmentEntity m) {
		// TODO Auto-generated method stub
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		
		Query q=ss.createQuery("from com.assignment.entity.AssignmentEntity m where m.email=:em1 and m.password=:ps");
		q.setParameter("em1", m.getEmail());
		q.setParameter("ps", m.getPassword());
		
		List<AssignmentEntity> ll = q.getResultList();
		
		if(ll.size()>0) {
			return true;
		}
		return false;
	}

	@Override
	public AssignmentEntity viewprofileDAO(AssignmentEntity m) {
		// TODO Auto-generated method stub
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		
		Query q=ss.createQuery("from com.assignment.entity.AssignmentEntity m where m.email=:em1");
		q.setParameter("em1", m.getEmail());
		
		AssignmentEntity mb=(AssignmentEntity)q.getSingleResult();
		
		return mb;
	}

	@Override
	public int deleteProfileDAO(AssignmentEntity m) {
		// TODO Auto-generated method stub
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		
		EntityTransaction et=ss.getTransaction();
		et.begin();
		
		Query q=ss.createQuery("delete from com.assignment.entity.AssignmentEntity m where m.email=:em1");
		q.setParameter("em1", m.getEmail());
		
		int i=q.executeUpdate();
		
		et.commit();
		return i;
	}

	@Override
	public List<AssignmentEntity> viewAllProfile(AssignmentEntity m) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session ss = sf.openSession();
		Query q = ss.createQuery("from com.assignment.entity.AssignmentEntity m");
		List<AssignmentEntity> ll = q.getResultList();
		return ll;
	}

}
