package de.fatalix.vaadin.addon.codemirror.demo;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import java.util.Arrays;
import org.vaadin.addons.chart.js.ChartConfiguration;
import org.vaadin.addons.chart.js.ChartJS;
import org.vaadin.addons.chart.js.color.ChartColor;
import org.vaadin.addons.chart.js.data.RadarSeriesDataSet;
import org.vaadin.addons.chart.js.data.BarSeriesDataSet;
import org.vaadin.addons.chart.js.data.DoughnutSeriesDataSet;
import org.vaadin.addons.chart.js.data.LineSeriesDataSet;
import org.vaadin.addons.chart.js.data.PieSeriesDataSet;

@Theme("demo")
@Title("ChartJS Add-on Demo")
@SuppressWarnings("serial")
public class DemoUI extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = DemoUI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(final VaadinRequest request) {
        try {
            ChartJS<RadarSeriesDataSet> radarChart = createRadarChart();
            radarChart.setHeight(340, Unit.PIXELS);
            radarChart.setWidth(600, Unit.PIXELS);
            
            ChartJS<BarSeriesDataSet> barChart = createBarChart();
            barChart.setHeight(340, Unit.PIXELS);
            barChart.setWidth(600, Unit.PIXELS);
            
            ChartJS<LineSeriesDataSet> lineChart = createLineChart();
            lineChart.setHeight(340, Unit.PIXELS);
            lineChart.setWidth(600, Unit.PIXELS);
            
            ChartJS<PieSeriesDataSet> pieChart = createPieChart();
            pieChart.setHeight(340, Unit.PIXELS);
            pieChart.setWidth(600, Unit.PIXELS);
            
            ChartJS<DoughnutSeriesDataSet> doughnutChart = createDoughnutChart();
            doughnutChart.setHeight(340, Unit.PIXELS);
            doughnutChart.setWidth(600, Unit.PIXELS);
            
            final HorizontalLayout chartLayout = new HorizontalLayout();
            chartLayout.addStyleName("wrapping");
            chartLayout.setSpacing(true);
            chartLayout.addComponents(radarChart,barChart,lineChart,doughnutChart,pieChart);
            
            final VerticalLayout layout = new VerticalLayout();
            layout.setStyleName("demoContentLayout");
            layout.addComponents(chartLayout);
            
            setContent(layout);
            
        } catch(Exception ex) {
            ex.printStackTrace(System.err);
        }
    }

    private ChartConfiguration createChartConfiguration(boolean datasetFill, boolean bezier) {
        ChartConfiguration chartConfiguration = new ChartConfiguration();
        chartConfiguration.animation = true;
        chartConfiguration.datasetFill = datasetFill;
        chartConfiguration.bezierCurve = bezier;
        chartConfiguration.scaleBeginAtZero = true;
        chartConfiguration.tooltipTemplate = "<%=datasetLabel%>: <%= value %>";
        chartConfiguration.multiTooltipTemplate = "<%=datasetLabel%>: <%= value %>";
        return chartConfiguration;
    }
    
    private ChartConfiguration createPieChartConfiguration() {
        ChartConfiguration chartConfiguration = new ChartConfiguration();
        chartConfiguration.animation = true;
        chartConfiguration.segmentShowStroke = true;
        chartConfiguration.segmentStrokeColor = "#fff";
        chartConfiguration.segmentStrokeWidth = 2;
        chartConfiguration.legendTemplate = "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<segments.length; i++){%><li><span style=\"background-color:<%=segments[i].fillColor%>\"></span><%if(segments[i].label){%><%=segments[i].label%><%}%></li><%}%></ul>";
        return chartConfiguration;
    }
    
    private ChartJS<LineSeriesDataSet> createLineChart() {
        
        LineSeriesDataSet velocity = new LineSeriesDataSet();
        velocity.label = "Velocity";
        velocity.setPointColor("#919C00");
        velocity.setStrokeColor("#919C00");
        velocity.setFillColor("#919C00");
        velocity.setPointHighlightFill("#fff");
        velocity.setData(Arrays.asList(new Float[] {78f, 108f, 85f, 121f}));

        LineSeriesDataSet spDone = new LineSeriesDataSet();
        spDone.label = "SP Done";
        spDone.setStrokeColor("#4F5502");
        spDone.setPointColor("#4F5502");
        spDone.setPointHighlightFill("#fff");
        spDone.setData(Arrays.asList(new Float[] {57f, 90f, 71f, 52f}));

        LineSeriesDataSet achievment = new LineSeriesDataSet();
        achievment.label = "Achievment";
        achievment.setStrokeColor("#082A39");
        achievment.setPointColor("#082A39");
        achievment.setPointHighlightFill("#fff");
        achievment.setData(Arrays.asList(new Float[] {72f, 87f, 59f, 100f}));
        
        ChartJS<LineSeriesDataSet> chartJS = new ChartJS<>(createChartConfiguration(false,true),
                                                            Arrays.asList(new String[] {"Sprint1", "Sprint2", "Sprint3", "Sprint4"}),
                                                            Arrays.asList(new LineSeriesDataSet[] {spDone, velocity, achievment}));
        return chartJS;
    }
    
    private ChartJS<BarSeriesDataSet> createBarChart() {
        BarSeriesDataSet velocity = new BarSeriesDataSet();
        velocity.label = "Velocity";
        velocity.setFillColor("#919C00");
        velocity.setHighlightFill("rgba(145,156,0,0.6)");
        //velocity.setStrokeColor("#3F596D");
        velocity.setData(Arrays.asList(new Float[] {78f, 108f, 85f, 121f}));

        BarSeriesDataSet spDone = new BarSeriesDataSet();
        spDone.label = "SP Done";
        spDone.setFillColor("#4F5502");
        spDone.setHighlightFill("rgba(79,85,2,0.6)");
        //spDone.setStrokeColor("#515602");
        spDone.setData(Arrays.asList(new Float[] {57f, 90f, 71f, 52f}));

        BarSeriesDataSet achievment = new BarSeriesDataSet();
        achievment.label = "Achievment";
        achievment.setFillColor("#082A39");
        achievment.setHighlightFill("rgba(8,42,57,0.6)");
        //achievment.setStrokeColor("#9DAA00");
        achievment.setData(Arrays.asList(new Float[] {72f, 87f, 59f, 100f}));

        ChartJS<BarSeriesDataSet> chartJS = new ChartJS<>(createChartConfiguration(false,false),
                                                            Arrays.asList(new String[] {"Sprint1", "Sprint2", "Sprint3", "Sprint4"}),
                                                            Arrays.asList(new BarSeriesDataSet[] {spDone, velocity, achievment}));
        
        return chartJS;
    }
    
    private ChartJS<RadarSeriesDataSet> createRadarChart() {

        RadarSeriesDataSet velocity = new RadarSeriesDataSet();
        velocity.label = "Velocity";
        velocity.setFillColor("rgba(145,156,0,0.2)");
        velocity.setStrokeColor("#919C00");
        velocity.setPointColor("#919C00");
        velocity.setPointHighlightFill("#fff");
        velocity.setData(Arrays.asList(new Float[] {8f, 10f, 13f, 12f,9f}));

        RadarSeriesDataSet spDone = new RadarSeriesDataSet();
        spDone.label = "SP Done";
        spDone.setFillColor("rgba(79,85,2,0.2)");
        spDone.setStrokeColor("#4F5502");
        spDone.setPointColor("#4F5502");
        spDone.setPointHighlightFill("#fff");
        spDone.setData(Arrays.asList(new Float[] {57f, 53f, 41f, 52f,66f}));
        //082A39
        RadarSeriesDataSet achievment = new RadarSeriesDataSet();
        achievment.label = "Achievment";
        achievment.setFillColor("rgba(8,42,57,0.2)");
        achievment.setStrokeColor("#082A39");
        achievment.setPointColor("#082A39");
        achievment.setPointHighlightFill("#fff");
        achievment.setData(Arrays.asList(new Float[] {72f, 87f, 59f, 100f, 60f}));

        ChartJS<RadarSeriesDataSet> chartJS = new ChartJS<>(createChartConfiguration(false,false),
                                                            Arrays.asList(new String[] {"Sprint1", "Sprint2", "Sprint3", "Sprint4", "Sprint5"}),
                                                            Arrays.asList(new RadarSeriesDataSet[] {spDone, velocity, achievment}));

        return chartJS;
    }
    
    private ChartJS<PieSeriesDataSet> createPieChart() {
        PieSeriesDataSet bugs = new PieSeriesDataSet();
        bugs.label = "Bugs";
        bugs.setColor("#919C00");
        bugs.setHighlight("rgba(145,156,0,0.6)");
        bugs.setValue(12f);
        
        PieSeriesDataSet stories = new PieSeriesDataSet();
        stories.label = "Stories";
        stories.setColor("#4F5502");
        stories.setHighlight("rgba(79,85,2,0.6");
        stories.setValue(5f);
        
        PieSeriesDataSet unplanned = new PieSeriesDataSet();
        unplanned.label = "Unplanned";
        unplanned.setColor("#082A39");
        unplanned.setHighlight("rgba(8,42,57,0.6)");
        unplanned.setValue(3f);
        
        ChartJS<PieSeriesDataSet> chartJS = new ChartJS<>(createPieChartConfiguration(),
                                                            Arrays.asList(new String[] {"möp"}),
                                                            Arrays.asList(new PieSeriesDataSet[] {bugs, stories, unplanned}));
        
        return chartJS;
    }
    
    private ChartJS<DoughnutSeriesDataSet> createDoughnutChart() {
        DoughnutSeriesDataSet bugs = new DoughnutSeriesDataSet();
        bugs.label = "Bugs";
        bugs.setColor(ChartColor.CHARTJS_RED.getRGBCode());
        bugs.setHighlight(ChartColor.CHARTJS_RED.getHightlightCode(0.95f));
        bugs.setValue(12f);
        
        DoughnutSeriesDataSet stories = new DoughnutSeriesDataSet();
        stories.label = "Stories";
        stories.setColor(ChartColor.CHARTJS_BLUE.getRGBCode());
        stories.setHighlight(ChartColor.CHARTJS_BLUE.getHightlightCode(0.95f));
        stories.setValue(5f);
        
        DoughnutSeriesDataSet unplanned = new DoughnutSeriesDataSet();
        unplanned.label = "Unplanned";
        unplanned.setColor(ChartColor.CHARTJS_VIOLETTE.getRGBCode());
        unplanned.setHighlight(ChartColor.CHARTJS_VIOLETTE.getHightlightCode(0.95f));
        unplanned.setValue(3f);
        
        ChartJS<DoughnutSeriesDataSet> chartJS = new ChartJS<>(createPieChartConfiguration(),
                                                            Arrays.asList(new String[] {"super"}),
                                                            Arrays.asList(new DoughnutSeriesDataSet[] {bugs, stories, unplanned}));
        
        return chartJS;
    }
}
