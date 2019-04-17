/*
 * Swash Tech Ltd.
 *
 * ApiErrorController.java
 *
 * © 2018 Swash Tech Ltd. All Rights Reserved
 */
// ---- Package ---------------------------------------------------------------
package io.apadigal.demo.catalogue.rest.controller;
// ---- Import Statements -----------------------------------------------------

import io.apadigal.demo.catalogue.rest.exception.ApiErrorMessage;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApiErrorController implements ErrorController {

    @RequestMapping("/error")
    public ResponseEntity<ApiErrorMessage> handleError() {
        ApiErrorMessage responseMsg = ApiErrorMessage.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message("Unexpected error")
                .build();
        return new ResponseEntity<>(responseMsg, HttpStatus.BAD_REQUEST);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}