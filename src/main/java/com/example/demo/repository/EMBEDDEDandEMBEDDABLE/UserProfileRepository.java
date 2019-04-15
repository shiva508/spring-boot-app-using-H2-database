package com.example.demo.repository.EMBEDDEDandEMBEDDABLE;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.EMBEDDEDandEMBEDDABLE.UserProfile;
@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {

}
