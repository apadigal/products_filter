/*
 * Swash Tech Ltd.
 *
 * ApiErrorMessage.java
 *
 * © 2018 Swash Tech Ltd. All Rights Reserved
 */
// ---- Package ---------------------------------------------------------------
package io.apadigal.demo.catalogue.rest.exception;
// ---- Import Statements -----------------------------------------------------

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiErrorMessage {

    private HttpStatus status;
    private String message;
    private List<String> errors;
    private String path;
}