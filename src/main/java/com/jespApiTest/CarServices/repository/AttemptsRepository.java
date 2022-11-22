package com.jespApiTest.CarServices.repository;

import java.util.Optional;

import com.jespApiTest.CarServices.models.Attempts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttemptsRepository extends JpaRepository<Attempts, Integer> {
    Optional<Attempts> findAttemptsByUsername(String username);
}