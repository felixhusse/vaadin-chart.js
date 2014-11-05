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

/**
 *
 * @author felix.husse
 */
@JavaScript({"vaadin://chartjs/Chart.min.js","chartjs-connector.js"})
public class ChartJS extends AbstractJavaScriptComponent{
    private static int componentCount = 0;
    
    private final int componentId;
    
    public ChartJS() {
        super();
        
        componentId = componentCount;
        setId("chartjs-wrapper-"+componentId);
        componentCount++;
        getState().componentId = componentId;
    }
    
    @Override
    protected ChartJSState getState() {
        return (ChartJSState) super.getState();
    }
    
    
    
}