package com.jespApiTest.CarServices.controller;

import com.jespApiTest.CarServices.exception.InternalServerErrorException;
import com.jespApiTest.CarServices.models.User;
import com.jespApiTest.CarServices.services.UserService;
import com.jespApiTest.CarServices.util.ChangePasswordRequestModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 *
 * Servizi REST User
 *
 * @author Elvin Iluca
 *
 */
@CrossOrigin
@RestController
@Slf4j
public class UserController{

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("user/all")
    public Iterable<User> getUsers() throws InternalServerErrorException {
        return userService.getUsers();
    }

    @GetMapping("user/all-mechanical")
    public Iterable<User> getAllMechanical() throws InternalServerErrorException {
        log.info("user/all-mechanical");
        return userService.getAllMechanical();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("user/role-update")
    @ResponseStatus(HttpStatus.OK)
    public void changeUserRole(@RequestBody User user)throws InternalServerErrorException{
        userService.changeUserRole(user);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("user/active-update")
    @ResponseStatus(HttpStatus.OK)
    public void changeUserActive(@RequestBody User user)throws InternalServerErrorException{
        userService.changeUserActive(user);
    }

    @PostMapping("user/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user) throws InternalServerErrorException {
        userService.createUser(user);
    }
    //@PreAuthorize("hasAnyAuthority('ADMIN')")
//    @PostMapping("user/{id}/password")
//    @ResponseStatus(HttpStatus.OK)
//    public void cambioPasswordOld(@RequestBody ChangePasswordRequestModel changePasswordRequestModel, @PathVariable("id") Long id) throws InternalServerErrorException {
//        userService.cambioPassword(changePasswordRequestModel, id);
//    }

    @PostMapping("user/change-password")
    @ResponseStatus(HttpStatus.OK)
    public void cambioPassword(@RequestBody ChangePasswordRequestModel changePasswordRequestModel) throws InternalServerErrorException {
        log.info("cambio password...");
        userService.cambioPassword(changePasswordRequestModel);
    }

    @GetMapping("user/activate/{username}/{activationCode}")
    public String attivaUser(@PathVariable("username") String username, @PathVariable("activationCode") String activationCode) throws InternalServerErrorException {
        return userService.attivaUser(username, Integer.parseInt(activationCode));
    }

}
