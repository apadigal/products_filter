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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class ApplicationExceptionAdvice {

    @ExceptionHandler(value = {HttpClientErrorException.class})
    public ResponseMessage handleNotFoundException(HttpServletResponse response) {
        response.setStatus(HttpStatus.NOT_FOUND.value());
        ResponseMessage responseMsg = new ResponseMessage("Not Found");
        return responseMsg;
    }

    @ExceptionHandler(value = {ConversionFailedException.class})
    public ResponseMessage handleBadDataException(HttpServletResponse response) {
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        ResponseMessage responseMsg = new ResponseMessage("Bad Request parameters");
        return responseMsg;
    }
}