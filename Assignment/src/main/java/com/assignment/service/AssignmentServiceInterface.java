package com.assignment.service;

import java.util.List;

import com.assignment.entity.AssignmentEntity;


public interface AssignmentServiceInterface {
	int createProfileService(AssignmentEntity w);

	boolean loginProfile(AssignmentEntity m);

	AssignmentEntity viewprofile(AssignmentEntity m);

	int deleteprofile(AssignmentEntity m);

	List<AssignmentEntity> viewAllProfile(AssignmentEntity m);
}
