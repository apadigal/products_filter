/*
 * Swash Tech Ltd.
 *
 * ApplicationExceptionAdvice.java
 *
 * © 2018 Swash Tech Ltd. All Rights Reserved
 */
// ---- Package ---------------------------------------------------------------
package io.apadigal.demo.catalogue.rest.exception;
// ---- Import Statements -----------------------------------------------------

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@RestControllerAdvice
public class ApplicationExceptionAdvice {

    @ExceptionHandler(value = {NoHandlerFoundException.class})
    public ResponseEntity<ApiErrorMessage> handleNoHandlerFoundException(NoHandlerFoundException ex) {
        ApiErrorMessage responseMsg = ApiErrorMessage.builder()
                .status(HttpStatus.NOT_FOUND)
                .message("Requested resource not found")
                .path(ex.getRequestURL())
                .build();
        return new ResponseEntity<>(responseMsg, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {HttpClientErrorException.class})
    public ResponseEntity<ApiErrorMessage> handleCategoryNotFoundException() {
        ApiErrorMessage responseMsg = ApiErrorMessage.builder()
                .status(HttpStatus.NOT_FOUND)
                .message("Category Not Found")
                .build();
        return new ResponseEntity<>(responseMsg, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {ConversionFailedException.class})
    public ResponseEntity<ApiErrorMessage> handleBadDataException(ConversionFailedException ex, HttpServletResponse response) {
        ApiErrorMessage responseMsg = ApiErrorMessage.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message("Invalid request data")
                .errors(Arrays.asList("Source Type :" + ex.getSourceType(), "But Target Type:" + ex.getTargetType(), "Value :" + ex.getValue()))
                .build();
        return new ResponseEntity<>(responseMsg, HttpStatus.BAD_REQUEST);
    }

}