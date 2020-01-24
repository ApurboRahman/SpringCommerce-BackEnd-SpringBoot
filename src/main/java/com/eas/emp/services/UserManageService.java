package com.eas.emp.services;

import com.eas.emp.dto.UserDTO;
import com.eas.emp.model.UserModel;

public interface UserManageService {
    UserModel registerUser(UserDTO userDTO,String password);

    }
