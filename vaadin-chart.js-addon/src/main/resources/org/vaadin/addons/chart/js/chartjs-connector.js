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
        console.log(state.chartData.seriesDataContainer);
        console.log(state.chartData.chartConfiguration);
        console.log(state.chartData.componentID);
        initChartJS(state);
    };

    initChartJS = function (state) {
        var canvasID = "chartjs-"+state.chartData.componentID;
        var cs = getComputedStyle(e);
        var width = parseInt(cs.getPropertyValue('width'), 10);
        var height = parseInt(cs.getPropertyValue('height'), 10);
        e.innerHTML = e.innerHTML + "<canvas id='"+canvasID+"' width='"+width+"' height='"+height+"'></canvas>";
        var data = {
            labels: ["January", "February", "March", "April", "May", "June", "July"],
            datasets: [
                {
                    label: "My First dataset",
                    fillColor: "rgba(220,220,220,0.2)",
                    strokeColor: "rgba(220,220,220,1)",
                    pointColor: "rgba(220,220,220,1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    ointHighlightStroke: "rgba(220,220,220,1)",
                    data: [65, 59, 80, 81, 56, 55, 40]
                },
                {
                    label: "My Second dataset",
                    fillColor: "rgba(151,187,205,0.2)",
                    strokeColor: "rgba(151,187,205,1)",
                    pointColor: "rgba(151,187,205,1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(151,187,205,1)",
                    data: [28, 48, 40, 19, 86, 27, 90]
                }
            ]
        };
        
        
        var ctx = document.getElementById(canvasID).getContext("2d");
        myNewChart = new Chart(ctx).Line(state.chartData.seriesDataContainer,state.chartData.chartConfiguration);
    };
    

};

