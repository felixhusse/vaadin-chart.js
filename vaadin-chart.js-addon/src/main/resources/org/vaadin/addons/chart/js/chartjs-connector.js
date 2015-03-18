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
window.org_vaadin_addons_chart_js_ChartJS = function () {
    
    
    
    var e = this.getElement();
    var self = this;
    var myNewChart;
    
    this.onStateChange = function () {
        var state = this.getState();
        initChartJS(state);
    };

    initChartJS = function (state) {
        var canvasID = "chartjs-"+state.chartData.componentID;
        //var legendID = "chartjs-legend-"+state.chartData.componentID;
        var cs = getComputedStyle(e);
        var width = parseInt(cs.getPropertyValue('width'), 10);
        
        var height = parseInt(cs.getPropertyValue('height'), 10);
        
        var innerHTML_TEXT = "<canvas id='"+canvasID+"' width='"+width+"' height='"+height+"'></canvas>";
                        //+"<div style='width: 100px; height: "+height+"px;'id='"+legendID+"'></div></div>";
        
        e.innerHTML = e.innerHTML + innerHTML_TEXT;
        
        var ctx = document.getElementById(canvasID).getContext("2d");
        switch (state.chartData.chartType) {
            case "LINE":
                myNewChart = new Chart(ctx).Line(state.chartData.lineSeriesDataContainer,state.chartData.chartConfiguration);
                break;
            case "BAR":
                myNewChart = new Chart(ctx).Bar(state.chartData.barSeriesDataContainer,state.chartData.chartConfiguration);
                break;
            case "RADAR":
                myNewChart = new Chart(ctx).Radar(state.chartData.radarSeriesDataContainer,state.chartData.chartConfiguration);
                break;
            case "PIE":
                myNewChart = new Chart(ctx).Pie(state.chartData.pieSeriesDataContainer,state.chartData.chartConfiguration);
                break;
            case "DOUGHNUT":
                myNewChart = new Chart(ctx).Doughnut(state.chartData.doughnutDataContainer,state.chartData.chartConfiguration);
                //var legendHolder = document.getElementById(legendID);
                //legendHolder.innerHTML = myNewChart.generateLegend();
                break;
        }
    };
    

};

