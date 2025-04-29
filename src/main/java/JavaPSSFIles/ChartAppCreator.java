package JavaPSSFIles;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class ChartAppCreator {
        private JFreeChart scatter;
        private XYSeries graphingData;
        private ArrayList<double[]> saltedData;
        public ChartAppCreator(){
            saltedData = new ArrayList<>();
        }
    public void graphApplication( String title){
        ArrayList<double[]> dataset = new ArrayList<>();
        graphingData = new XYSeries(title);
        for(double[] coords : dataset){
            graphingData.add(coords[0],coords[1]);
        } 
        //Creates a Series Collection for graphing data
        XYSeriesCollection groupData = new XYSeriesCollection();
        groupData.addSeries(graphingData);

        scatter = ChartFactory.createXYLineChart(title, "X-Coordinates", "Y-Coordinates", groupData, PlotOrientation.VERTICAL, true, true, false);

        //Creates the chart panel using our scatter plot chart
        ChartPanel chart = new ChartPanel(scatter);
        chart.setPreferredSize(new java.awt.Dimension(600, 400));

        XYPlot plot = scatter.getXYPlot();

        XYLineAndShapeRenderer design = new XYLineAndShapeRenderer();
            design.setSeriesPaint(0, Color.black);
            design.setSeriesStroke(0, new BasicStroke(1.0f));
            design.setSeriesPaint(1, Color.orange);
            design.setSeriesStroke(1, new BasicStroke(4.0f));
            design.setSeriesPaint(2, Color.BLUE);
            design.setSeriesStroke(2, new BasicStroke(4.0f));
        plot.setRenderer(design);

        int width = 1000;
        int height = 1500;
        
        //Code for the Application Window
        JFrame window = new JFrame(title);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.add(chart, BorderLayout.CENTER);
            window.pack();
            window.setLocationRelativeTo(null);
            window.setVisible(true);
            window.setSize(1000, 1000);
        
        
        //Code for the X-value Input
        JTextField initialX = new JTextField(10);
            initialX.setMargin(new Insets(10, 30, 10, 30));
            initialX.setToolTipText("Enter initial X-value");
            initialX.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    FunctionPlot math = new FunctionPlot();
                    ArrayList<double[]> dataset = new ArrayList<>();

                    try{
                        double x = Double.parseDouble(initialX.getText());
                        dataset = math.expFunc(x);

                        for(double[] coords : dataset){
                            graphingData.add(coords[0],coords[1]);
                        } 
                        System.out.println("Initial X-value: " + x);
                        initialX.setText("");
                        chart.repaint();
                    
                    }catch(NumberFormatException ex){
                        System.out.println("Please enter a valid value!");
                    }
                }
            });

            String[] functions = {"Exponential"};
            JComboBox functionSelect = new JComboBox<>(functions);
//------------------------------------------------------------------------------------------------------------------Buttons------------------------------------------------------------------------------------------------------------------------------------------------------------
            //Code for the Graphing Button
            JButton button = new JButton("Graph");
            button.setFocusable(false);
            button.setToolTipText("This will graph the selected function, based on your initial X-value");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    FunctionPlot math = new FunctionPlot();
                    ArrayList<double[]> dataset = new ArrayList<>();

                    try{
                        double x = Double.parseDouble(initialX.getText());
                        dataset = math.expFunc(x);
                        for(double[] coords : dataset){
                            graphingData.add(coords[0],coords[1]);
                        } 
                        System.out.println("Initial X-value: " + x);
                        initialX.setText("");
                        chart.repaint();
                    } catch(NumberFormatException ex){
                        System.out.println("Please enter a valid value!");
                    }
                }
            });

            //Code for a data Salting button
            JButton saltButton = new JButton("Salt");
                saltButton.setFocusable(false);
                saltButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        ArrayList<double[]> dataset = new ArrayList<>();
                        XYSeries saltedSet = new XYSeries("Salted");
                        Salter salt = new Salter();
                        for(int i = 0; i < groupData.getSeriesCount(); i++){//Checks to make sure a Salted set is not present on graph preventing error
                            if(groupData.getSeriesKey(i).equals("Salted")){
                                groupData.removeSeries(i);
                                break;
                            }
                        }
                        for(int i = 0; i < graphingData.getItemCount(); i++){
                            double x = graphingData.getX(i).doubleValue();
                            double y = graphingData.getY(i).doubleValue();
                            dataset.add(new double[]{x,y});
                        }
                        dataset = salt.salter(dataset);
                        for(double[] coords : dataset){
                            saltedSet.add(coords[0], coords[1]);
                            saltedData.add(coords);
                        }
                        groupData.addSeries(saltedSet);
                        System.out.println("Salted dataset");
                        chart.repaint();
                        saltedData = dataset;
                    }
                });
            //Code for a data smoothing button
            JButton smoothButton = new JButton("Smooth");
                smoothButton.setFocusable(false);
                smoothButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        ArrayList<double[]> dataset = new ArrayList<>();
                        XYSeries smoothedSet = new XYSeries("Smoothed");
                        Salter salt = new Salter();

                        for(int i = 0; i < groupData.getSeriesCount(); i++){//Checks to make sure a Smoothed set is not present on graph preventing error
                            if(groupData.getSeriesKey(i).equals("Smoothed")){
                                groupData.removeSeries(i);
                                break;
                            }
                        }

                        for(int i = 0; i < graphingData.getItemCount(); i++){
                            double x = graphingData.getX(i).doubleValue();
                            double y = graphingData.getY(i).doubleValue();
                            dataset.add(new double[]{x,y});
                        }
                        dataset = salt.smoother(saltedData, 5);
                        for(double[] coords : dataset){
                            smoothedSet.add(coords[0], coords[1]);
                        }
                        groupData.addSeries(smoothedSet);
                        System.out.println("Smoothed dataset");
                        chart.repaint();
                        
                    }
                });
            //Code for a Clear Graph Button
            JButton clearButton = new JButton("Clear");
                clearButton.setFocusable(false);
                clearButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        graphingData.clear();
                        groupData.removeAllSeries();
                        groupData.addSeries(graphingData);
                        saltedData.clear();
                        chart.setChart(scatter); 
                        System.out.println("Graph cleared.");
                        chart.repaint();
                    }
                });
//-------------------------------------------------------------------------------------------------------------------Panels-------------------------------------------------------------------------------------------------------------------------------------------------------
        //Adds button and text fields to a panel for use.
        JPanel controls = new JPanel();
            controls.add(new JLabel("Enter initial x-value: "));
            controls.add(initialX);
            controls.add(functionSelect);
            controls.add(button);
            controls.add(saltButton);
            controls.add(smoothButton);
            controls.add(clearButton);
            controls.setSize(100, 100);
        window.add(controls, BorderLayout.SOUTH);
    }
}
