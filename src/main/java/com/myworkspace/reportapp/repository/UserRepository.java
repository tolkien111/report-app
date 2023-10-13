package com.myworkspace.reportapp.repository;

import com.myworkspace.reportapp.entity.customer.User;
import com.myworkspace.reportapp.entity.customer.enums.UserType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("FROM User u WHERE u.userType = :type")
    Page<User> findAllRelevantUsers(@Param("type") UserType type, Pageable pageable);

}
