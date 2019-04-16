/*
 * Swash Tech Ltd.
 *
 * PriceDTO.java
 *
 * © 2018 Swash Tech Ltd. All Rights Reserved
 */
// ---- Package ---------------------------------------------------------------
package io.apadigal.demo.catalogue.dto;
// ---- Import Statements -----------------------------------------------------

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Map;
import java.util.Objects;

public class PriceDTO implements Serializable {
    private static final long serialVersionUID = -3298813527682861017L;
    private String was;
    private String then1;
    private String then2;
    private Object now;
    private String currency;

    public String getWas() {
        return getNullIfEmpty(was);
    }

    public void setWas(String was) {
        this.was = was;
    }

    public String getThen1() {
        return getNullIfEmpty(then1);
    }

    public void setThen1(String then1) {
        this.then1 = then1;
    }

    public String getThen2() {
        return getNullIfEmpty(then2);
    }

    public void setThen2(String then2) {
        this.then2 = then2;
    }

    public String getNow() {
        if (this.now instanceof String) {
            return (String) this.now;
        } else if (this.now instanceof Map) {
            return String.valueOf(((Map) this.now).get("to"));
        } else {
            return "";
        }
    }

    public void setNow(Object now) {
        this.now = now;
    }

    public String getCurrency() {
        return getNullIfEmpty(currency);
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    private String getNullIfEmpty(String value) {
        return Objects.isNull(value) || value.equals("") || value.trim().length() == 0 ? null : value;
    }

    public String getCurrencyCode() {
        return Objects.nonNull(getCurrency()) ? Currency.getInstance(getCurrency()).getSymbol() : null;
    }

    public String formatNowPriceWithLabel() {
        return String.format("now %s", formatNowPrice());

    }

    public String formatNowPrice() {
        String nowValue;
        if (this.now instanceof String) {
            nowValue = (String) this.now;
        } else if (this.now instanceof Map) {
            nowValue = String.valueOf(((Map) this.now).get("to"));
        } else {
            return "";
        }
        return formatPriceValue(nowValue);
    }

    public String formatWasPrice() {
        return Objects.nonNull(getWas()) ? String.format("Was %s,", formatPriceValue(getWas())) : "";
    }

    public String formatThenPrice() {
        return Objects.nonNull(getThenPrice()) ? String.format("then %s,", formatPriceValue(getThenPrice())) : "";
    }

    private Number getPriceAsNumber(String value) {
        try {
            return NumberFormat.getInstance().parse(value);
        } catch (ParseException ex) {
            return 0.00;
        }
    }

    private String formatPriceValue(String value) {
        try {
            Number number = NumberFormat.getInstance().parse(value);
            if (number.intValue() >= 10) {
                return String.format("%s%d", getCurrencyCode(), number.intValue());
            } else {
                return String.format("%s%.2f", getCurrencyCode(), number.doubleValue());
            }
        } catch (ParseException ex) {
            return "";
        }
    }

    private String getThenPrice() {
        return Objects.nonNull(getThen2()) ? getThen2() : getThen1();
    }

    public String getDiscountPercentLabel() {
        if (getDiscountPercent() > 0) {
            return String.format("%%%d off - %s", getDiscountPercent(), formatNowPriceWithLabel());
        }
        return "";
    }

    public Integer getDiscountPercent() {
        try {
            Double wasPrice = getPriceAsNumber(this.was).doubleValue();
            Double nowPrice = getPriceAsNumber(getNow()).doubleValue();
            if (wasPrice - nowPrice > 0) {
                Double discount = nowPrice * 100 / wasPrice;
                return discount.intValue();
            } else
                return 0;
        } catch (Exception ex) {
            return 0;
        }

    }
}