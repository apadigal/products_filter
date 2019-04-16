/*
 * Swash Tech Ltd.
 *
 * CatalogueService.java
 *
 * © 2018 Swash Tech Ltd. All Rights Reserved
 */
// ---- Package ---------------------------------------------------------------
package io.apadigal.demo.catalogue.service;
// ---- Import Statements -----------------------------------------------------

import io.apadigal.demo.catalogue.constant.LabelType;
import io.apadigal.demo.catalogue.dto.ApiResponseDTO;
import io.apadigal.demo.catalogue.dto.ProductDTO;
import io.apadigal.demo.catalogue.util.SortByDiscount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CatalogueService {

    private final String API_URI = "https://jl-nonprod-syst.apigee.net/v1/categories/%s/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma";

    public ResponseEntity getProductsForCategory(String categoryId, LabelType labelType) {
        RestTemplate restTemplate = new RestTemplate();
        ApiResponseDTO output = restTemplate.getForObject(String.format(API_URI, categoryId), ApiResponseDTO.class);
        output.getProducts().forEach(productDTO -> productDTO.setLabelType(labelType));

        List<ProductDTO> productDTOS = output.getProducts().stream().filter(productDTO -> productDTO.getPrice().getDiscountPercent() > 0)
                .collect(Collectors.toList());

        Collections.sort(productDTOS, new SortByDiscount().reversed());

        output.setProducts(productDTOS);

        return new ResponseEntity(output, HttpStatus.OK);
    }

}