/*
 * Swash Tech Ltd.
 *
 * ProductBaseDTO.java
 *
 * © 2018 Swash Tech Ltd. All Rights Reserved
 */
// ---- Package ---------------------------------------------------------------
package io.apadigal.demo.catalogue.dto;
// ---- Import Statements -----------------------------------------------------

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProductBaseDTO implements Serializable {

    private static final long serialVersionUID = 7860812004713145727L;
    private String productId;
    private String title;

}