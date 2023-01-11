package com.jespApiTest.CarServices.repository;
import com.jespApiTest.CarServices.models.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "SELECT u FROM User u WHERE u.username = :username")
    User findByUsername(@Param("username") String username);

    @Query(value = "SELECT u FROM User u")
    Iterable<User> getUsers();

    @Transactional
    @Modifying
    @Query(value = "UPDATE User u set u.code = :code WHERE u.username = :username")
    void setCode(@Param("username") String username, @Param("code") int code);

    @Transactional
    @Modifying
    @Query(value = "UPDATE User u set u.isactive = :isactive WHERE u.username = :username")
    void setActive(@Param("username") String username, @Param("isactive") int isactive);

    @Query(value = "SELECT u.isactive FROM User u WHERE u.username = :username")
    int getIsActive(@Param("username") String username);

    @Transactional
    @Modifying
    @Query(value = "UPDATE User u set u.idRuolo = :role WHERE u.username = :username")
    void setRole(@Param("username") String username, @Param("role") int role);

}
