package com.projectFile.AutoStack.Exception;


import com.projectFile.AutoStack.Exception.Error.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> handleBadRequestException(BadRequestException exception) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, exception.getMessage());
        log.info(apiError.toString());
        return ResponseEntity.status(apiError.status()).body(apiError);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFoundException(ResourceNotFoundException exception) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, exception.getResourceName() + " with Id : " + exception.getResourceId() + "Not found !");
        log.info(apiError.toString());
        return ResponseEntity.status(apiError.status()).body(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleInputValidationErrors(MethodArgumentNotValidException exception) {
        List<ApiFieldError> listError = exception.getBindingResult().getFieldErrors().stream()
                .map(error -> new ApiFieldError(error.getField(), error.getDefaultMessage()))
                .toList();
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "Input validation failed !", listError);
        log.info(apiError.toString());
        return ResponseEntity.status(apiError.status()).body(apiError);
    }


//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ApiResponse<?>> handleInternalServerError(Exception exception) {
//        ApiError apiError = ApiError.builder()
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .message(exception.getMessage())
//                .build();
//        return buildErrorResponseEntity(apiError);
//    }
//
//    private ResponseEntity<ApiResponse<?>> buildErrorResponseEntity(ApiError apiError) {
//        return new ResponseEntity<>(new ApiResponse<>(apiError), apiError.getStatus());
//    }
//
//
//    //    Spring security Errors:
//    @ExceptionHandler(AuthenticationException.class)
//    public ResponseEntity<ApiError> handlingDsExceptions(AuthenticationException authenticationException){
//        ApiError error=new ApiError(  HttpStatus.UNAUTHORIZED,authenticationException.getMessage(), Collections.singletonList(authenticationException.getLocalizedMessage()));
//        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
//
//    }


}