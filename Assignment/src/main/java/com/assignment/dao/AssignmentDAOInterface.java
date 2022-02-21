package com.assignment.dao;

import java.util.List;

import com.assignment.entity.AssignmentEntity;

public interface AssignmentDAOInterface {

	int createProfileDAO(AssignmentEntity w);

	boolean loginProfileDAO(AssignmentEntity m);

	AssignmentEntity viewprofileDAO(AssignmentEntity m);

	int deleteProfileDAO(AssignmentEntity m);

	List<AssignmentEntity> viewAllProfile(AssignmentEntity m);


}
