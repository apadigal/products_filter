/*
 * Swash Tech Ltd.
 *
 * ApiResponseDTO.java
 *
 * © 2018 Swash Tech Ltd. All Rights Reserved
 */
// ---- Package ---------------------------------------------------------------
package io.apadigal.demo.catalogue.dto;
// ---- Import Statements -----------------------------------------------------

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ApiResponseDTO implements Serializable {

    private static final long serialVersionUID = 2972762525210722986L;
    List<ProductDTO> products;

}