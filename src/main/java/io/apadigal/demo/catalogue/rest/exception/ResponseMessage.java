/*
 * Swash Tech Ltd.
 *
 * ResponseMessage.java
 *
 * © 2018 Swash Tech Ltd. All Rights Reserved
 */
// ---- Package ---------------------------------------------------------------
package io.apadigal.demo.catalogue.rest.exception;
// ---- Import Statements -----------------------------------------------------

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseMessage {

    String message;

}