/*
 * Copyright 2015 felix.husse.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.vaadin.addons.chart.js.color;

import java.awt.Color;

/**
 * Some example colors.
 *
 * @author felix.husse
 */
public enum ChartColor {

    DARK_BLUE("#082A39"), DARK_GREEN("#4F5502"), LIGHT_GREEN("#BBC264"),
    CHARTJS_BLUE("#5B90BF"), CHARTJS_RED("#D08770"), CHARTJS_VIOLETTE("#B48EAD"),
    CHARTJS_BROWN("#AB7967"), CHARTJS_GREEN("#A3BE8C"), CHARTJS_CYAN("#96B5B4");

    private final String hexCode;

    private ChartColor(String hexCode) {
        this.hexCode = hexCode;
    }

    public String getRGBCode() {
        return hexCode;
    }
    
    public String getHightlightCode(float alpha) {
        Color rgbaColor = new Color(Integer.valueOf(hexCode.substring(1, 3), 16), Integer.valueOf(hexCode.substring(3, 5), 16), Integer.valueOf(hexCode.substring(5, 7), 16));
        String rgbaCode = "rgba("+rgbaColor.getRed()+","+rgbaColor.getGreen()+ "," + rgbaColor.getBlue() + ","+alpha+")";
        
        return rgbaCode;
    }


}
