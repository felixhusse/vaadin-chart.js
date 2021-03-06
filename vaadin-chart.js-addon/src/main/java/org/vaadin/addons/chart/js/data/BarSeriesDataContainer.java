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

import java.util.List;

/**
 *
 * @author felix.husse
 */
public class BarSeriesDataContainer extends AbstractSeriesDataContainer{
    private List<BarSeriesDataSet> datasets;

    public List<BarSeriesDataSet> getDatasets() {
        return datasets;
    }

    public void setDatasets(List<BarSeriesDataSet> datasets) {
        this.datasets = datasets;
    }
    
}
