package com.javacourse.section8.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@Deprecated
@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class UserNotValidatedException extends RuntimeException {
   public UserNotValidatedException(String msg){
       super(msg);
   }
}
