package com.jespApiTest.CarServices.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.jespApiTest.CarServices.models.Auto;
import org.springframework.data.repository.query.Param;

public interface AutoRepository extends CrudRepository<Auto,Integer>{
    @Query(value = "SELECT a FROM Auto a WHERE a.idProprietario = :idProprietario")
    Iterable<Auto> findByidProprietario(@Param("idProprietario") long idProprietario);
}
