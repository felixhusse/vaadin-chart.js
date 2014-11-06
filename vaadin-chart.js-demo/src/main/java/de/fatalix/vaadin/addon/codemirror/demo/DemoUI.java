package de.fatalix.vaadin.addon.codemirror.demo;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.addons.chart.js.ChartJS;

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
            final ChartJS chartJS = new ChartJS();
            
            //chartJS.setHeight(400, Unit.PIXELS);
            //chartJS.setWidth(600, Unit.PIXELS);
            //chartJS.initChart();

            layout.addComponents(chartJS,new Label("Hello World"));
            layout.setExpandRatio(chartJS, 1.0f);
            layout.setComponentAlignment(chartJS, Alignment.MIDDLE_CENTER);
            layout.setSizeFull();

            setContent(layout);

        } catch(Exception ex) {
            ex.printStackTrace(System.err);
        }
    }
}
