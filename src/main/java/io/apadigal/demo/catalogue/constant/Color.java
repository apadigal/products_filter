/*
 * Swash Tech Ltd.
 *
 * Color.java
 *
 * © 2018 Swash Tech Ltd. All Rights Reserved
 */
// ---- Package ---------------------------------------------------------------
package io.apadigal.demo.catalogue.constant;
// ---- Import Statements -----------------------------------------------------

import java.util.HashMap;
import java.util.Map;

public enum Color {

    BLACK("000000"),
    BLUE("0000FF"),
    CYAN("00FFFF"),
    GRAY("808080"),
    GREY("808080"),
    GREEN("008000"),
    MAGENTA("FF00FF"),
    ORANGE("FFA500"),
    RED("800080"),
    PINK("FF00FF"),
    PURPLE("FF0000"),
    WHITE("FFFFFF"),
    YELLOW("FFFF00");

    String hexaDecimalCode;

    private static final Map<String, Color> COLOR_MAP = new HashMap<String, Color>();

    static {
        for (Color color : values()) {
            COLOR_MAP.put(color.name(), color);
            COLOR_MAP.put(color.name().toLowerCase(), color);
        }
    }


    Color(String hexaDecimalCode) {
        this.hexaDecimalCode = hexaDecimalCode;
    }

    public String getHexaDecimalCode() {
        return hexaDecimalCode;
    }

    public static Color getByString(String colorName) {

        if (colorName == null)
            return null;
        return COLOR_MAP.get(colorName.toUpperCase());
    }
}