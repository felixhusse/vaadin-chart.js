/*
 * Copyright 2014 fatalix.
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
package org.vaadin.addons.chart.js;

import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;
import java.util.List;
import org.vaadin.addons.chart.js.data.AbstractSeriesDataContainer;
import org.vaadin.addons.chart.js.data.AbstractSeriesDataSet;
import org.vaadin.addons.chart.js.data.BarSeriesDataContainer;
import org.vaadin.addons.chart.js.data.BarSeriesDataSet;
import org.vaadin.addons.chart.js.data.LineSeriesDataContainer;
import org.vaadin.addons.chart.js.data.LineSeriesDataSet;
import org.vaadin.addons.chart.js.data.RadarSeriesDataContainer;
import org.vaadin.addons.chart.js.data.RadarSeriesDataSet;

/**
 *
 * @author felix.husse
 */
@JavaScript({"vaadin://chartjs/Chart.min.js", "chartjs-connector.js"})
public class ChartJS<T extends AbstractSeriesDataSet> extends AbstractJavaScriptComponent {

    private static int componentCount = 0;

    private final int componentId;

    public ChartJS(ChartConfiguration chartConfiguration, List<String> labels, List<T> dataSets) {
        super();
        componentId = componentCount;
        setId("chartjs-wrapper-" + componentId);
        componentCount++;
        ChartData chartData = new ChartData();
        chartData.componentID = componentId;
        chartData.chartConfiguration = chartConfiguration;
        
        if(dataSets.get(0) instanceof RadarSeriesDataSet) {
            System.out.println("RadarChart Found");
            RadarSeriesDataContainer dataContainer = new RadarSeriesDataContainer();
            dataContainer.setLabels(labels);
            dataContainer.setDatasets((List<RadarSeriesDataSet>)dataSets);
            chartData.chartType = ChartType.RADAR;
            chartData.radarSeriesDataContainer = dataContainer;
        } else if(dataSets.get(0) instanceof LineSeriesDataSet) {
            System.out.println("LineChart Found");
            LineSeriesDataContainer dataContainer = new LineSeriesDataContainer();
            dataContainer.setLabels(labels);
            dataContainer.setDatasets((List<LineSeriesDataSet>)dataSets);
            chartData.chartType = ChartType.LINE;
            chartData.lineSeriesDataContainer = dataContainer;
        } else if(dataSets.get(0) instanceof BarSeriesDataSet) {
            System.out.println("BarChart Found");
            BarSeriesDataContainer dataContainer = new BarSeriesDataContainer();
            dataContainer.setLabels(labels);
            dataContainer.setDatasets((List<BarSeriesDataSet>)dataSets);
            chartData.chartType = ChartType.BAR;
            chartData.barSeriesDataContainer = dataContainer;

        }

        getState().chartData = chartData;
    }

    @Override
    protected ChartJSState getState() {
        return (ChartJSState)super.getState();
    }

}
