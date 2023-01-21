package com.jespApiTest.CarServices.repository;

import com.jespApiTest.CarServices.models.DateModel;
import com.jespApiTest.CarServices.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.sql.Timestamp;
import java.util.Date;

public interface DateModelRepository extends CrudRepository<DateModel,Integer> {
//    @Query(value = "SELECT d FROM DateModel d WHERE d.date between  :startDate and :stopDate")
//    Iterable<DateModel> getRangeListDate(@Param("startDate") Timestamp startDate, @Param("stopDate") Timestamp stopDate);

}
