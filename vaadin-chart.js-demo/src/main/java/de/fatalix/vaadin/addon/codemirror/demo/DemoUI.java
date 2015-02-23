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
import org.vaadin.addons.chart.js.data.RadarSeriesDataSet;
import org.vaadin.addons.chart.js.data.BarSeriesDataSet;
import org.vaadin.addons.chart.js.data.LineSeriesDataSet;

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
            
            
            final HorizontalLayout chartLayout = new HorizontalLayout();
            chartLayout.addStyleName("row");
            chartLayout.setSizeFull();
            chartLayout.addComponents(radarChart,barChart,lineChart);
            
            
            final VerticalLayout layout = new VerticalLayout();
            layout.setStyleName("demoContentLayout");
            layout.addComponents(chartLayout);
            layout.setSizeFull();
            setContent(layout);
        } catch(Exception ex) {
            ex.printStackTrace(System.err);
        }
    }

    private ChartConfiguration createChartConfiguration() {
        ChartConfiguration chartConfiguration = new ChartConfiguration();
        chartConfiguration.animation = true;
        chartConfiguration.datasetFill = false;
        chartConfiguration.bezierCurve = false;
        chartConfiguration.scaleBeginAtZero = true;
        chartConfiguration.tooltipTemplate = "<%=datasetLabel%>: <%= value %>";
        chartConfiguration.multiTooltipTemplate = "<%=datasetLabel%>: <%= value %>";

        return chartConfiguration;
    }
    
    
    
    private ChartJS<LineSeriesDataSet> createLineChart() {
        
        LineSeriesDataSet velocity = new LineSeriesDataSet();
        velocity.label = "Velocity";
        velocity.setStrokeColor("#919C00");
        velocity.setFillColor("#919C00");
        velocity.setData(Arrays.asList(new Float[] {78f, 108f, 85f, 121f}));

        LineSeriesDataSet spDone = new LineSeriesDataSet();
        spDone.label = "SP Done";
        spDone.setStrokeColor("#4F5502");
        spDone.setFillColor("#4F5502");
        
        spDone.setData(Arrays.asList(new Float[] {57f, 90f, 71f, 52f}));

        LineSeriesDataSet achievment = new LineSeriesDataSet();
        achievment.label = "Achievment";
        achievment.setStrokeColor("#082A39");
        achievment.setFillColor("#082A39");
        achievment.setData(Arrays.asList(new Float[] {72f, 87f, 59f, 100f}));
        
        ChartJS<LineSeriesDataSet> chartJS = new ChartJS<>(createChartConfiguration(),
                                                            Arrays.asList(new String[] {"Sprint1", "Sprint2", "Sprint3", "Sprint4"}),
                                                            Arrays.asList(new LineSeriesDataSet[] {spDone, velocity, achievment}));
        return chartJS;
    }
    
    private ChartJS<BarSeriesDataSet> createBarChart() {
        BarSeriesDataSet velocity = new BarSeriesDataSet();
        velocity.label = "Velocity";
        velocity.setFillColor("#919C00");
        //velocity.setStrokeColor("#3F596D");
        velocity.setData(Arrays.asList(new Float[] {78f, 108f, 85f, 121f}));

        BarSeriesDataSet spDone = new BarSeriesDataSet();
        spDone.label = "SP Done";
        spDone.setFillColor("#4F5502");
        //spDone.setStrokeColor("#515602");
        spDone.setData(Arrays.asList(new Float[] {57f, 90f, 71f, 52f}));

        BarSeriesDataSet achievment = new BarSeriesDataSet();
        achievment.label = "Achievment";
        achievment.setFillColor("#082A39");
        //achievment.setStrokeColor("#9DAA00");
        achievment.setData(Arrays.asList(new Float[] {72f, 87f, 59f, 100f}));

        ChartJS<BarSeriesDataSet> chartJS = new ChartJS<>(createChartConfiguration(),
                                                            Arrays.asList(new String[] {"Sprint1", "Sprint2", "Sprint3", "Sprint4"}),
                                                            Arrays.asList(new BarSeriesDataSet[] {spDone, velocity, achievment}));
        
        return chartJS;
    }
    
    private ChartJS<RadarSeriesDataSet> createRadarChart() {

        RadarSeriesDataSet velocity = new RadarSeriesDataSet();
        velocity.label = "Velocity";
        velocity.setFillColor("#3F596D");
        velocity.setStrokeColor("#3F596D");
        velocity.setPointColor("#3F596D");
        velocity.setPointStrokeColor("#fff");
        velocity.setPointHighlightFill("#fff");
        velocity.setPointHighlightStroke("#3F596D");
        velocity.setData(Arrays.asList(new Float[] {78f, 108f, 85f, 121f}));

        RadarSeriesDataSet spDone = new RadarSeriesDataSet();
        spDone.label = "SP Done";
        //dataSet.setFillColor("rgba(220,220,220,0.2)");
        spDone.setStrokeColor("#515602");
        spDone.setPointColor("#515602");
        spDone.setPointStrokeColor("#fff");
        spDone.setPointHighlightFill("#fff");
        spDone.setPointHighlightStroke("#515602");
        spDone.setData(Arrays.asList(new Float[] {57f, 90f, 71f, 52f}));

        RadarSeriesDataSet achievment = new RadarSeriesDataSet();
        achievment.label = "Achievment";
        //dataSet.setFillColor("rgba(220,220,220,0.2)");
        achievment.setStrokeColor("#9DAA00");
        achievment.setPointColor("#9DAA00");
        achievment.setPointStrokeColor("#fff");
        achievment.setPointHighlightFill("#fff");
        achievment.setPointHighlightStroke("#9DAA00");
        achievment.setData(Arrays.asList(new Float[] {72f, 87f, 59f, 100f}));

        ChartJS<RadarSeriesDataSet> chartJS = new ChartJS<>(createChartConfiguration(),
                                                            Arrays.asList(new String[] {"Sprint1", "Sprint2", "Sprint3", "Sprint4"}),
                                                            Arrays.asList(new RadarSeriesDataSet[] {spDone, velocity, achievment}));

        return chartJS;
    }
}
