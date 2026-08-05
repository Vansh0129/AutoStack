package com.projectFile.AutoStack.Exception;


import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.List;

public record ApiError(HttpStatus status,
                       String message,
                       Instant timeStamp
                       , @JsonInclude(JsonInclude.Include.NON_NULL) List<ApiFieldError> error) {

    public ApiError(HttpStatus status,
                    String message) {
        this(status, message, Instant.now(),null);
    }
    public ApiError(HttpStatus status,
                    String message,List<ApiFieldError> error) {
        this(status, message, Instant.now(),error);
    }


}
record ApiFieldError(String field,String message){}
