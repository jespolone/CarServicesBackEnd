package com.jespApiTest.CarServices.services;

import com.jespApiTest.CarServices.exception.InternalServerErrorException;
import com.jespApiTest.CarServices.models.DateModel;
import com.jespApiTest.CarServices.models.User;
import com.jespApiTest.CarServices.repository.DateModelRepository;
import com.jespApiTest.CarServices.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DateModelService {

    @Autowired
    private DateModelRepository dateModelRepository;
    @Autowired
    private UserRepository userRepository;

    public  Iterable<DateModel> getUserDate(int userId) throws InternalServerErrorException {
        Iterable<DateModel> tempDateModel =  dateModelRepository.findAll();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByUsername(userDetails.getUsername());
        if(user.getIdRuolo() == 1 || user.getIdRuolo() == 2){
            return tempDateModel;
        }
        for(DateModel date : tempDateModel ){
            if(date.getClient() != userId){
                date.setAuto(null);
                date.setDatedescription("Occupato");
                date.setClient(null);
            }
        }

        return tempDateModel;
    }

    public void createDate(DateModel date) throws InternalServerErrorException{
        try {
            dateModelRepository.save(date);
        }
        catch(Exception exception){
            throw new InternalServerErrorException(exception.getMessage());
        }
    }

   /* public Iterable<DateModel> getListDate() throws InternalServerErrorException {
        try {
            Iterable<DateModel> toRet = dateModelRepository.findAll();

            if(!((List<DateModel>)toRet).isEmpty()) {
                return toRet;
            }
            else {
                throw new NotFoundException("Nessun appuntamento trovato!");
            }
        }
        catch(Exception e) {
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    public void createDate(DateModel date) throws InternalServerErrorException{
        final int hour = 3600000; //an hour in milliseconds
        Timestamp startTime = date.getDate();
        Timestamp stopTime = new Timestamp(startTime.getTime() + hour);
        log.info(stopTime.toString());
        log.info(startTime.toString());
        if(dateModelRepository.getRangeListDate(startTime, stopTime) != null){
            throw new InternalServerErrorException("Permesso negato");
        }
        try {
            dateModelRepository.save(date);
        }
        catch(Exception exception){
            throw new InternalServerErrorException(exception.getMessage());
        }
    }

    public Iterable<DateModel> getTodayListDate(String date) throws InternalServerErrorException{
        String startDate = date + " 00:00:00";
        String stopDate = date + " 23:59:59";
        Timestamp startTimestamp = new Timestamp(0);
        Timestamp stopTimestamp = new Timestamp(0);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long millisStart = sdf.parse(startDate).getTime();
            long millisStop = sdf.parse(stopDate).getTime();
            startTimestamp = new Timestamp(millisStart);
            stopTimestamp = new Timestamp(millisStop);
            log.info(startTimestamp.toString());
            log.info(stopTimestamp.toString());
        } catch (ParseException pe) {
            pe.printStackTrace();
        }

        try {
            return dateModelRepository.getRangeListDate(startTimestamp, stopTimestamp);
        }
        catch(Exception exception){
            throw new InternalServerErrorException(exception.getMessage());
        }
    }

    */
}
