/*
 * Swash Tech Ltd.
 *
 * CatagoriesController.java
 *
 * © 2018 Swash Tech Ltd. All Rights Reserved
 */
// ---- Package ---------------------------------------------------------------
package io.apadigal.demo.catalogue.rest.controller;
// ---- Import Statements -----------------------------------------------------

import io.apadigal.demo.catalogue.constant.LabelType;
import io.apadigal.demo.catalogue.service.CatalogueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
@Slf4j
public class CategoriesController {

    @Autowired
    CatalogueService catalogueService;

    @GetMapping
    public String home() {
        return "Hello Catalogue";
    }

    @GetMapping(value = "v1/categories/{categoryId}")
    public ResponseEntity getCategoryProducts(@PathVariable(name = "categoryId") String categoryId,
                                              @RequestParam(name = "labelType", required = false, defaultValue = "ShowWasNow") LabelType labelType) {

        log.info("Label Type:" + labelType);
        return catalogueService.getProductsForCategory(categoryId, labelType);
    }
}