package com.taskmanager.taskmanager.validator;

import com.taskmanager.taskmanager.entity.Users;
import com.taskmanager.taskmanager.payload.UserRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Users.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {

        UserRequest users = (UserRequest) object;

        if(users.getPassword().length() <6){
            errors.rejectValue("password","Length", "Password must be at least 6 characters");
        }


    }
}
