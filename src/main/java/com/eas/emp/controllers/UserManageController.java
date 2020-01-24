package com.eas.emp.controllers;

import com.eas.emp.model.UserModel;
import com.eas.emp.services.UserManageService;
import com.eas.emp.vm.ManagedUserVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserManageController {

    @Autowired
    private UserManageService userManageService;

    /**
     * {@code POST  /register} : register the user.
     * @param userVM
     */

    @PostMapping("/register")
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@Valid @RequestBody ManagedUserVM userVM){
        UserModel user = userManageService.registerUser(userVM,userVM.getPassword());

        //Send email confirmation to the user. Feature will be developed later.
        /*mailService.sendActivationEmail(user);*/
    }

}
