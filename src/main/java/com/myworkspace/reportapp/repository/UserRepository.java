package com.myworkspace.reportapp.repository;

import com.myworkspace.reportapp.entity.customer.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("FROM User u WHERE u.userType = UPPER(?1)")
    List<User> findAllUsersWhen(String userType);
}
