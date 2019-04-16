/*
 * Swash Tech Ltd.
 *
 * SortByDiscount.java
 *
 * © 2018 Swash Tech Ltd. All Rights Reserved
 */
// ---- Package ---------------------------------------------------------------
package io.apadigal.demo.catalogue.util;
// ---- Import Statements -----------------------------------------------------

import io.apadigal.demo.catalogue.dto.ProductDTO;

import java.util.Comparator;

public class SortByDiscount implements Comparator<ProductDTO> {

    @Override
    public int compare(ProductDTO o1, ProductDTO o2) {
        return o1.getPrice().getDiscountPercent() - o2.getPrice().getDiscountPercent();
    }

}