package com.satyabhushan.splitwiseapplication.repositories;

import com.satyabhushan.splitwiseapplication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByPhoneNumber(String phoneNumber);

    @Override
    Optional<User> findById(Long aLong);


    User save(User user);
}