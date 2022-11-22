package com.jespApiTest.CarServices.repository;

import com.jespApiTest.CarServices.models.Access;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface AccessRepository extends CrudRepository<Access, Long>{

    @Query(value = "SELECT a FROM Access a WHERE a.username = :username")
    Access findByUsername(@Param("username") String username);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Access a set a.password = :password WHERE a.username = :username")
    void changePassword(@Param("username") String username, @Param("password") String newPassword);

}
