package com.inkflair.resumeportal;

import com.inkflair.resumeportal.models.User;
import com.inkflair.resumeportal.models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {
    Optional<UserProfile> findByUsername(String username);
}
