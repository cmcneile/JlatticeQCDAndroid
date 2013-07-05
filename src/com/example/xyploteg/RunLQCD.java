package com.example.xyploteg;

import com.example.xyploteg.eclipse.* ;
/*
 * Copyright 2012 AndroidPlot.com
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import com.androidplot.series.XYSeries;
import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;

import java.util.Arrays;

/**
 * The simplest possible example of using AndroidPlot to plot some data.
 */
public class RunLQCD extends Activity
{

    private XYPlot mySimpleXYPlot;

    private String nx ;
    private String nt ;
    private String beta ;



    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

	nx   = getIntent().getStringExtra("Xdim");
        nt   = getIntent().getStringExtra("Tdim");
        beta = getIntent().getStringExtra("beta");


        // initialize our XYPlot reference:
        mySimpleXYPlot = (XYPlot) findViewById(R.id.mySimpleXYPlot);


	int N = 2 ; 
        double beta = 2.1 ;
        int sweeps_between_meas = 5 ; 
        int max_sweeps = 50 ; 

        double[] x    = new double[max_sweeps] ;
        double[] plaq = new double[max_sweeps] ;
        generate_gauge.create_configs(N,beta,sweeps_between_meas, max_sweeps,x,plaq ) ;

        // Create a couple arrays of y-values to plot:
        Number[] series1Numbers = new Number[max_sweeps] ;
        Number[] series2Numbers = new Number[max_sweeps] ;

	for(int ip = 0 ; ip < max_sweeps ; ++ip)
	    {
		//		series1Numbers[ip] = new Double(x[ip]) ;
		series1Numbers[ip] = new Double(ip) ;
		series2Numbers[ip] = new Double(plaq[ip]) ;
	    }



        // Turn the above arrays into XYSeries':
        XYSeries series1 = new SimpleXYSeries(
                Arrays.asList(series1Numbers),          // SimpleXYSeries takes a List so turn our array into a List
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                "Trajectory");                             // Set the display title of the series

        // same as above
        XYSeries series2 = new SimpleXYSeries(Arrays.asList(series2Numbers), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Plaquette");

        // Create a formatter to use for drawing a series using LineAndPointRenderer:
        LineAndPointFormatter series1Format = new LineAndPointFormatter(
                Color.rgb(0, 200, 0),                   // line color
                Color.rgb(0, 100, 0),                   // point color
                null);                                  // fill color (none)

        // add a new series' to the xyplot:
	//        mySimpleXYPlot.addSeries(series1, series1Format);

        // same as above:
        mySimpleXYPlot.addSeries(series2,
                new LineAndPointFormatter(Color.rgb(0, 0, 200), Color.rgb(0, 0, 100), null));


        // reduce the number of range labels
	//        mySimpleXYPlot.setTicksPerRangeLabel(3);

        // by default, AndroidPlot displays developer guides to aid in laying out your plot.
        // To get rid of them call disableAllMarkup():
        mySimpleXYPlot.disableAllMarkup();
    }
}
