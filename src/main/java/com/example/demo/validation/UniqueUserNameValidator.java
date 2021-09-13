package com.example.demo.validation;

import com.example.demo.service.ValidatorService;
import javax.validation.*;

public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName,String> {


        private final ValidatorService validatorService;


    public UniqueUserNameValidator(ValidatorService validatorService) {
        this.validatorService = validatorService;
    }


    @Override
    public void initialize(UniqueUserName constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return  !validatorService.isUserNameAlreadyUse(s);

    }


}
