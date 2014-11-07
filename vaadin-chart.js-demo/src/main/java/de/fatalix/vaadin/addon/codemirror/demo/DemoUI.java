package de.fatalix.vaadin.addon.codemirror.demo;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.colorpicker.Color;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.vaadin.addons.chart.js.ChartConfiguration;
import org.vaadin.addons.chart.js.ChartJS;
import org.vaadin.addons.chart.js.data.AbstractSeriesDataSet;
import org.vaadin.addons.chart.js.data.LineSeriesDataSet;
import org.vaadin.addons.chart.js.data.SeriesDataContainer;

@Theme("demo")
@Title("ChartJS Add-on Demo")
@SuppressWarnings("serial")
public class DemoUI extends UI {

    private static final String exampleCode = "function findSequence(goal) {\n" + "  function find(start, history) {\n" + "    if (start == goal)\n" + "      return history;\n"
                                              + "    else if (start > goal)\n" + "      return null;\n" + "    else\n" + "      return find(start + 5, \"(\" + history + \" + 5)\") ||\n"
                                              + "             find(start * 3, \"(\" + history + \" * 3)\");\n" + "  }\n" + "  return find(1, \"1\");\n" + "}";

    private static final String exampleCode2 = "function findDaSequenceeee(goal) {\n" + "  function doSomeSearching(start, history) {\n" + "  }\n" + "  return find(1, \"1\");\n" + "}";

    private boolean changeFlag = false;

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = DemoUI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(final VaadinRequest request) {
        try {

            // Show it in the middle of the screen
            final VerticalLayout layout = new VerticalLayout();
            layout.setStyleName("demoContentLayout");
            ChartConfiguration chartConfiguration = new ChartConfiguration();
            chartConfiguration.animation = true;
            chartConfiguration.datasetFill = false;
            chartConfiguration.bezierCurve = false;
            chartConfiguration.scaleBeginAtZero = true;
            chartConfiguration.tooltipTemplate = "<%=datasetLabel%>: <%= value %>";
            chartConfiguration.multiTooltipTemplate = "<%=datasetLabel%>: <%= value %>";
            
            
            LineSeriesDataSet velocity = new LineSeriesDataSet();
            velocity.label = "Velocity";
            velocity.setFillColor("#3F596D");
            velocity.setStrokeColor("#3F596D");
            velocity.setPointColor("#3F596D");
            velocity.setPointStrokeColor("#fff");
            velocity.setPointHighlightFill("#fff");
            velocity.setPointHighlightStroke("#3F596D");
            velocity.setData(Arrays.asList(new Float[]{0.78f,1.08f,0.85f,1.21f}));
            
            LineSeriesDataSet spDone = new LineSeriesDataSet();
            spDone.label = "SP Done";
            //dataSet.setFillColor("rgba(220,220,220,0.2)");
            spDone.setStrokeColor("#515602");
            spDone.setPointColor("#515602");
            spDone.setPointStrokeColor("#fff");
            spDone.setPointHighlightFill("#fff");
            spDone.setPointHighlightStroke("#515602");
            spDone.setData(Arrays.asList(new Float[]{57f,90f,71f,52f}));
            
            LineSeriesDataSet achievment = new LineSeriesDataSet();
            achievment.label = "Achievment";
            //dataSet.setFillColor("rgba(220,220,220,0.2)");
            achievment.setStrokeColor("#9DAA00");
            achievment.setPointColor("#9DAA00");
            achievment.setPointStrokeColor("#fff");
            achievment.setPointHighlightFill("#fff");
            achievment.setPointHighlightStroke("#9DAA00");
            achievment.setData(Arrays.asList(new Float[]{72f,87f,59f,100f}));
            
            SeriesDataContainer dataContainer = new SeriesDataContainer();
            dataContainer.setLabels(Arrays.asList(new String[]{"Sprint1","Sprint2","Sprint3","Sprint4"}));
            dataContainer.setDatasets(Arrays.asList(new AbstractSeriesDataSet[]{velocity}));
            
            final ChartJS chartJS = new ChartJS(chartConfiguration,dataContainer);
            
            chartJS.setHeight(340, Unit.PIXELS);
            chartJS.setWidth(600, Unit.PIXELS);
            //chartJS.initChart();

            layout.addComponents(chartJS);
            layout.setExpandRatio(chartJS, 1.0f);
            layout.setComponentAlignment(chartJS, Alignment.MIDDLE_CENTER);
            layout.setSizeFull();

            setContent(layout);

        } catch(Exception ex) {
            ex.printStackTrace(System.err);
        }
    }
}
