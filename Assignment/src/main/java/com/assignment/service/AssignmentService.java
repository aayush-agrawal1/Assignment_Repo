package com.assignment.service;

import java.util.List;

import com.assignment.entity.AssignmentEntity;
import com.assignment.dao.AssignmentDAO;
import com.assignment.dao.AssignmentDAOInterface;
import com.assignment.entity.AssignmentEntity;

public class AssignmentService implements AssignmentServiceInterface {

	public int createProfileService(AssignmentEntity w) {
		AssignmentDAOInterface md = new AssignmentDAO();
		return md.createProfileDAO(w);
	}

	public boolean loginProfile(AssignmentEntity m) {
		AssignmentDAOInterface md = new AssignmentDAO();
		return md.loginProfileDAO(m);
	}

	public AssignmentEntity viewprofile(AssignmentEntity m) {
		AssignmentDAOInterface md=new AssignmentDAO();
		return md.viewprofileDAO(m);
	}

	public int deleteprofile(AssignmentEntity m) {
		AssignmentDAOInterface md=new AssignmentDAO();
		return md.deleteProfileDAO(m);
	}

	@Override
	public List<AssignmentEntity> viewAllProfile(AssignmentEntity m) {
		// TODO Auto-generated method stub
		AssignmentDAOInterface md = new AssignmentDAO();
		return md.viewAllProfile(m);
	}
}
