package com.eas.emp.services;

import com.eas.emp.exceptions.EmailAlreadyUsedException;
import com.eas.emp.exceptions.UsernameAlreadyUsedException;
import com.eas.emp.repository.UserManageRepository;
import com.eas.emp.dto.UserDTO;
import com.eas.emp.exceptions.InvalidPasswordException;
import com.eas.emp.model.UserModel;
import com.eas.emp.vm.ManagedUserVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;


@Service
@Transactional
public class UserManageServiceImp implements UserManageService {

    private final Logger logger = LoggerFactory.getLogger(UserManageService.class);

    @Autowired
    private UserManageRepository userManageRepository;
    @Autowired
    private  PasswordEncoder passwordEncoder;

    public UserManageServiceImp() {

    }

    public UserManageServiceImp(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * @param userDTO  the managed user View Model.
     * @param password
     * @return
     * @throws InvalidPasswordException     {@code 400 (Bad Request)} if the password is incorrect.
     * @throws EmailAlreadyUsedException    {@code 400 (Bad Request)} if the email is already used.
     * @throws UsernameAlreadyUsedException {@code 400 (Bad Request)} if the login is already used.
     */
    @Override
    public UserModel registerUser(UserDTO userDTO, String password) {
        if (!checkPasswordLength(password)) {
            logger.error("password length does not match");
            throw new InvalidPasswordException();
        }
        userManageRepository.findOneByLogin(userDTO.getLogin().toLowerCase()).ifPresent(existingUser -> {
            logger.error("this login user name already taken");
            throw new UsernameAlreadyUsedException();
        });
        userManageRepository.findOneByEmailIgnoreCase(userDTO.getEmail().toLowerCase()).ifPresent(existingUser -> {
            logger.error("email id already used by someone else!!");
            throw new EmailAlreadyUsedException();
        });
        String encryptedPassword = passwordEncoder.encode(password);
        UserModel userModel = new UserModel();

        logger.info("Login user converting to lower case start.");
        userModel.setLogin(userDTO.getLogin().toLowerCase());
        logger.info("Login user converting to lower case done.");
        logger.info("password encryption start.");
        userModel.setPassword(encryptedPassword);
        logger.info("password encryption end.");
        userModel.setFirstName(userDTO.getFirstName());
        userModel.setLastName(userDTO.getLastName());
        userModel.setImageUrl(userDTO.getImageUrl());

        //Activation key will be updated late
        logger.info("Activation key generating start.");
        userModel.setActivationKey(null);
        logger.info("Activation key generating end.");

        //new user is not active
        //userModel.setActivated(false);
        userModel.setActivated(true);
        logger.info("new user deactivated.");
        // registration key for new user
        userModel.setLangKey(userDTO.getLangKey());

        userManageRepository.save(userModel);
        logger.info("Created Information for User: {}", userModel);
        return userModel;
    }

    private boolean checkPasswordLength(String password) {
        return !StringUtils.isEmpty(password) &&
                password.length() >= ManagedUserVM.PASSWORD_MIN_LENGTH &&
                password.length() <= ManagedUserVM.PASSWORD_MAX_LENGTH;
    }
}

