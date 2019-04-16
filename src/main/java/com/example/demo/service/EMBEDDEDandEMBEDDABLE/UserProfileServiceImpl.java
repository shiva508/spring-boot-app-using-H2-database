package com.example.demo.service.EMBEDDEDandEMBEDDABLE;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.EMBEDDEDandEMBEDDABLE.UserProfile;
import com.example.demo.repository.EMBEDDEDandEMBEDDABLE.UserProfileRepository;

@Service
@Transactional
public class UserProfileServiceImpl implements UserProfileService {
	@Autowired
	private UserProfileRepository userProfileRepository;

	@Override
	public UserProfile saveUserProfile(UserProfile userProfile) {
		return userProfileRepository.save(userProfile);
	}
}
