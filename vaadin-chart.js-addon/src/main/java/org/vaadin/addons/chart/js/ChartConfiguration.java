/*
 * Copyright 2014 Fatalix.
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

import java.io.Serializable;

/**
 *
 * @author Fatalix
 */
public class ChartConfiguration implements Serializable{
    
    // Boolean - If we want to override with a hard coded scale
    public boolean scaleOverride = false;

    // ** Required if scaleOverride is true **
    // Number - The number of steps in a hard coded scale
    public Float scaleSteps = null;
    // Number - The value jump in the hard coded scale
    public Float scaleStepWidth=null;
    // Number - The scale starting value
    public Float scaleStartValue=null;
    
    // Boolean - Whether the scale should start at zero, or an order of magnitude down from the lowest value
    public boolean scaleBeginAtZero= false;
    
    // String - Template string for single tooltips
    public String tooltipTemplate= "<%if (label){%><%=label%>: <%}%><%= value %>";

    // String - Template string for single tooltips
    public String multiTooltipTemplate = "<%= value %>";
    
    public boolean animation = true;
    public int animationSteps = 60;
    public String animationEasing = "easeOutQuart";

    //Boolean - Whether grid lines are shown across the chart
    public boolean scaleShowGridLines = true;
   
    //String - Colour of the grid lines
    public String scaleGridLineColor = "rgba(233,0,0,.05)";
    //Number - Width of the grid lines
    public int scaleGridLineWidth = 1;
    //Boolean - Whether the line is curved between points
    public boolean bezierCurve = true;
    //Number - Tension of the bezier curve between points
    public double bezierCurveTension = 0.4d;
    //Boolean - Whether to show a dot for each point
    public boolean pointDot = true;
    //Number - Radius of each point dot in pixels
    public int pointDotRadius = 4;
    //Number - Pixel width of point dot stroke
    public int pointDotStrokeWidth = 1;
    //Number - amount extra to add to the radius to cater for hit detection outside the drawn point
    public int pointHitDetectionRadius = 20;
    //Boolean - Whether to show a stroke for datasets
    public boolean datasetStroke = true;
    //Number - Pixel width of dataset stroke
    public int datasetStrokeWidth = 2;
    //Boolean - Whether to fill the dataset with a colour
    public boolean datasetFill = true;
    //String - A legend template
    public String legendTemplate = "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<datasets.length; i++){%><li><span style=\"background-color:<%=datasets[i].lineColor%>\"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>";

    
}
