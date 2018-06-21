/*
 * Copyright 2018 Shehan Perera
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.sorting.src.main.java.com.github.shehanperera.algo;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;

import java.util.concurrent.TimeUnit;

public class MetricsServer {

    private static MetricsServer metricServer;
    private final MetricRegistry metricRegistry = new MetricRegistry();
    private Timer bubbleSortTime;
    private Timer heapSortTime;
    private Timer insertionSortTime;
    private Timer quickSortTime;
    private Timer radixSortTime;
    private Timer selectionSortTime;
    private Timer mergeSortTime;

    private ConsoleReporter ConsoleReporter;

    private MetricsServer() {

        bubbleSortTime = this.metricRegistry.timer("Time for Bubble Sort");
        heapSortTime = this.metricRegistry.timer("Time for Heap Sort");
        insertionSortTime = this.metricRegistry.timer("Time for Insertion Sort ");
        quickSortTime = this.metricRegistry.timer("Time for Quick Sort");
        radixSortTime = this.metricRegistry.timer("Time for Radix Sort");
        selectionSortTime = this.metricRegistry.timer("Time for Selection Sort");
        mergeSortTime = this.metricRegistry.timer("Time for Merge Sort");

    }

    public static MetricsServer getInstance() {

        if (metricServer == null) {
            metricServer = new MetricsServer();
        }
        return metricServer;
    }

    public Timer getBubbleSortTime() {

        return bubbleSortTime;
    }
    public Timer getHeapSortTime() {

        return heapSortTime;
    }
    public Timer getInsertionSortTime() {

        return insertionSortTime;
    }
    public Timer getQuickSortTime() {

        return quickSortTime;
    }
    public Timer getRadixSortTime() {

        return radixSortTime;
    }
    public Timer getSelectionSortTime() {

        return selectionSortTime;
    }
    public Timer getMergeSortTime() {

        return mergeSortTime;
    }

    public void startReport() {
        /*
        * This for Console reporter
        * Period apply to 2 for make easy view of output
        */
        System.out.println("Timers");
        ConsoleReporter = ConsoleReporter.forRegistry(metricRegistry)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();
        ConsoleReporter.start(1, TimeUnit.SECONDS);
    }

}