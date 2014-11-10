/*
 * Copyright 2014 felix.husse.
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
package org.vaadin.addons.chart.js.data;

/**
 *
 * @author felix.husse
 */
public class BarSeriesDataSet extends AbstractSeriesDataSet{
    private String highlightFill;
    private String highlightStroke;

    public void setHighlightFill(String highlightFill) {
        this.highlightFill = highlightFill;
    }

    public void setHighlightStroke(String highlightStroke) {
        this.highlightStroke = highlightStroke;
    }

    public String getHighlightFill() {
        return highlightFill;
    }

    public String getHighlightStroke() {
        return highlightStroke;
    }
    
}
