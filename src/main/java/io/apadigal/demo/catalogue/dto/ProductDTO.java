/*
 * Swash Tech Ltd.
 *
 * ProductDTO.java
 *
 * © 2018 Swash Tech Ltd. All Rights Reserved
 */
// ---- Package ---------------------------------------------------------------
package io.apadigal.demo.catalogue.dto;
// ---- Import Statements -----------------------------------------------------

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.apadigal.demo.catalogue.constant.LabelType;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDTO extends ProductBaseDTO {

    private static final long serialVersionUID = -3615688653664331240L;
    private LabelType labelType;

    private List<ColorSwatch> colorSwatches;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private PriceDTO price;

    public PriceDTO getPrice() {
        return price;
    }

    @JsonProperty(value = "nowPrice")
    public String getNowPrice() {
        if (price == null)
            return null;

        return price.formatNowPrice();
    }

    public List<ColorSwatch> getColorSwatches() {
        return colorSwatches;
    }

    public void setColorSwatches(List<ColorSwatch> colorSwatches) {
        this.colorSwatches = colorSwatches;
    }

    public void setPrice(PriceDTO price) {
        this.price = price;
    }

    public void setLabelType(LabelType labelType) {
        this.labelType = labelType;
    }

    @JsonProperty(value = "priceLabel")
    public String getPriceLabel() {
        if (labelType == null)
            return null;

        StringBuilder stringBuilder = new StringBuilder();

        switch (labelType) {
            case ShowWasNow:
                return stringBuilder.append(price.formatWasPrice()).append(price.formatNowPriceWithLabel()).toString();
            case ShowWasThenNow:
                return stringBuilder.append(price.formatWasPrice()).append(price.formatThenPrice()).append(price.formatNowPriceWithLabel()).toString();
            case ShowPercDscount:
                return price.getDiscountPercentLabel();
            default:
                return "";
        }
    }
}