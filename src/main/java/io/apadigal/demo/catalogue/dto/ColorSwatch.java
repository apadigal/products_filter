/*
 * Swash Tech Ltd.
 *
 * ColorSwatch.java
 *
 * © 2018 Swash Tech Ltd. All Rights Reserved
 */
// ---- Package ---------------------------------------------------------------
package io.apadigal.demo.catalogue.dto;
// ---- Import Statements -----------------------------------------------------

import com.fasterxml.jackson.annotation.JsonProperty;
import io.apadigal.demo.catalogue.constant.Color;

import java.io.Serializable;
import java.util.Objects;

public class ColorSwatch implements Serializable {

    private static final long serialVersionUID = 7478637622295886567L;
    private String color;
    private String skuId;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String basicColor;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public void setBasicColor(String basicColor) {
        this.basicColor = basicColor;
    }

    public String getRgbColor() {
        Color color = Color.getByString(this.basicColor);
        return Objects.nonNull(color) ? color.getHexaDecimalCode() : this.basicColor;
    }
}