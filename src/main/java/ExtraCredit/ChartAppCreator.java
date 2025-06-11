package ExtraCredit;

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
import javax.swing.JOptionPane;
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

import Part1_JavaPSSFIles.FunctionPlot;
import Part1_JavaPSSFIles.Salter;
//Heloooooooooooooooooooooooo
// HELOOOOOOOOOOOOOOOOOOOOOOOOooooo
public class ChartAppCreator {
        private JFreeChart scatter;
        private XYSeries graphingData;
        private ArrayList<double[]> saltedData;
        private ArrayList<double[]> smoothedData;
        private ArrayList<double[]> baseData;
        public ChartAppCreator(){
            saltedData = new ArrayList<>();
            smoothedData = new ArrayList<>();
            baseData = new ArrayList<>();
        }
    public void graphApplication( String title){
        ArrayList<double[]> dataset = new ArrayList<>();
        graphingData = new XYSeries("Base Data");//Creates the base dataset series
        for(double[] coords : dataset){//iterates through the dataset and adds the coordinates to the graphing data series
            graphingData.add(coords[0],coords[1]);
        } 
        //Creates a Series Collection for graphing multiple datasets
        XYSeriesCollection groupData = new XYSeriesCollection();
        groupData.addSeries(graphingData);

        scatter = ChartFactory.createXYLineChart(title, "X-Coordinates", "Y-Coordinates", groupData, PlotOrientation.VERTICAL, true, true, false);//Creates the scatter plot

        //Creates the chart panel using our scatter plot chart
        ChartPanel chart = new ChartPanel(scatter);
        chart.setPreferredSize(new java.awt.Dimension(600, 400));

        XYPlot plot = scatter.getXYPlot();//creates the plot

        XYLineAndShapeRenderer design = new XYLineAndShapeRenderer();//This block of code determines the characteristics of the line graph
            design.setSeriesPaint(0, Color.black);//Affects Base data plotting
            design.setSeriesStroke(0, new BasicStroke(1.0f));
            design.setSeriesPaint(1, Color.orange);//Affects Salted data plotting
            design.setSeriesStroke(1, new BasicStroke(4.0f));
            design.setSeriesPaint(2, Color.BLUE);//Affects Smoothed data plotting
            design.setSeriesStroke(2, new BasicStroke(4.0f));
        plot.setRenderer(design);//Adds the rendering characteristics to the plot
        
        //Code for the Application Window
        JFrame window = new JFrame(title);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.add(chart, BorderLayout.CENTER);
            window.setLocationRelativeTo(null);
            window.setVisible(true);
            window.setSize(1000, 1000);
        
        //This provides a dropdown menu letting you choose which function you want to graph
        String[] functions = {"Exponential", "Logarithmic"};
        JComboBox functionSelect = new JComboBox<>(functions);
        functionSelect.setToolTipText("Select your graphing function");

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
                        String function = (String) functionSelect.getSelectedItem();
                        graphingData.clear();
                        groupData.removeAllSeries();
                        switch(function){//Creates a switch case checking for which function is selected in the dropdown menu
                            case "Exponential": //Creates a popup window to enter an exponent
                                String expInput = JOptionPane.showInputDialog(null, "Enter an exponent:", "Exponent Selection", JOptionPane.PLAIN_MESSAGE);
                                if (expInput == null || expInput.trim().isEmpty()) {//Checks to make sure the exponent input isn't empty
                                    return;
                                }
                                    int exp = Integer.parseInt(expInput.trim());
                                    dataset = math.expFunc(x, exp);
                                break;
                            case "Logarithmic":
                                dataset = math.logFunc(x);
                                break;
                            default:
                                System.out.println("Please select a function!");
                        }
                        for(double[] coords : dataset){
                            graphingData.add(coords[0],coords[1]);
                        } 
                        groupData.addSeries(graphingData);//adds Graphing data to the group data collection series
                        System.out.println("Initial X-value: " + x);
                        initialX.setText("");//Resets the initialX field after it is graphed
                        chart.repaint();//Repaints the graph allowing you to change the base data of the graph
                        baseData = dataset;//Sets the global variable baseData to the graphed dataset for exporting purposes
                    } catch(NumberFormatException ex){
                        System.out.println("Please enter a valid value!");
                    }
                }
            });
//------------------------------------------------------------------------------------------------------------------Control Buttons------------------------------------------------------------------------------------------------------------------------------------------------------------
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
                        String function = (String) functionSelect.getSelectedItem();
                        graphingData.clear();
                        groupData.removeAllSeries();
                        switch(function){//Creates a switch case checking for which function is selected in the dropdown menu
                            case "Exponential": //Creates a popup window to enter an exponent value
                                String expInput = JOptionPane.showInputDialog(null, "Enter an exponent:", "Exponent Selection", JOptionPane.PLAIN_MESSAGE);
                                if (expInput == null || expInput.trim().isEmpty()) {//Checks to make sure the exponent isn't empty
                                    return;
                                }
                                    int exp = Integer.parseInt(expInput.trim());
                                    dataset = math.expFunc(x, exp);
                                break;
                            case "Logarithmic":
                                dataset = math.logFunc(x);
                                break;
                            default:
                                System.out.println("Please select a function!");
                        }
                        for(double[] coords : dataset){
                            graphingData.add(coords[0],coords[1]);
                        } 
                        groupData.addSeries(graphingData);//adds Graphing data to the group data collection series
                        System.out.println("Initial X-value: " + x);
                        initialX.setText("");//Resets the initialX field after it is graphed
                        chart.repaint();//Repaints the graph allowing you to change the base data of the graph
                        baseData = dataset;//Sets the global variable baseData to the graphed dataset for exporting purposes
                    } catch(NumberFormatException ex){
                        System.out.println("Please enter a valid value!");
                    }
                }
            });
//----------------------------------------------------------------------------------------Salting Functionality
            //Code for a data Salting button
            JButton saltButton = new JButton("Salt");
                saltButton.setFocusable(false);
                saltButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        ArrayList<double[]> tempDataset = new ArrayList<>();
                        XYSeries saltedSet = new XYSeries("Salted");//Creates a new series for the Salted data
                        Salter salt = new Salter();
                        for(int i = 0; i < groupData.getSeriesCount(); i++){//Checks to make sure a Salted set is not present on graph preventing error
                            if(groupData.getSeriesKey(i).equals("Salted")){
                                groupData.removeSeries(i);//removes the previous salted set in order to add a new one 
                                break;
                            }
                        }
                        if(baseData.isEmpty()){//Ensures that baseData isn't empty
                            JOptionPane.showMessageDialog(window, "Please create a base function graph before salting", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        tempDataset = salt.salter(baseData);//Salts the base dataset 
                        for(double[] coords : tempDataset){
                            saltedSet.add(coords[0], coords[1]);//Adds the salted dataset to a new salted series
                        }
                        groupData.addSeries(saltedSet);//adds Salted set to the groupData Collection Series
                        System.out.println("Salted dataset");
                        chart.repaint();//Repaints the chart allowing for an updated salted Dataset
                        saltedData = tempDataset;//Sets the global variable saltedData to the new salted dataset for exporting purposes
                    }
                });
//-------------------------------------------------------------------------------------------Smoothing Functionality
            //Smoothing WindowValue Code
            JTextField windowValue = new JTextField(5);
            //Smoothing Button Code
            JButton smoothButton = new JButton("Smooth");
                smoothButton.setFocusable(false);
                smoothButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        try{
                            ArrayList<double[]> tempDataset = new ArrayList<>();
                            XYSeries smoothedSet = new XYSeries("Smoothed");//Creates a new series for the smoothed data
                            Salter salt = new Salter();
                            int windowVal = Integer.parseInt(windowValue.getText());//Parses the String from the WindowValue textfield for the window value parameter in the smoothing function
                            if(windowVal < 0){//Ensures that there is a valid window value input
                                throw new NumberFormatException();
                            }
                            for(int i = 0; i < groupData.getSeriesCount(); i++){//Checks to make sure a Smoothed set is not present on graph preventing error
                                if(groupData.getSeriesKey(i).equals("Smoothed")){
                                    groupData.removeSeries(i);//Removes the previous smoothed set allowing for a new smoothed set
                                    break;
                                }
                            }

                            if (saltedData.isEmpty()) {//Ensures that saltedData isn't empty, creates a pop up window expressing the error
                                JOptionPane.showMessageDialog(window, "Please salt the data before smoothing.", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }

                            tempDataset = salt.smoother(saltedData, windowVal);//Smoothes the salted dataset
                            for(double[] coords : tempDataset){
                                smoothedSet.add(coords[0], coords[1]);//Adds new smoothed dataset to smoothed series for graphing
                            }
                            groupData.addSeries(smoothedSet);//Adds the smoothed series to the groupData set Collection Series
                            System.out.println("Smoothed dataset");
                            chart.repaint();//Repaints the chart allowing for an updated Smooth set
                            windowValue.setText("");//Clears the windowValue text field after successful smoothing operation
                            smoothedData = tempDataset;//Sets the global variable smoothedData equal to the new smoothed dataset for exporting purposes
                        } catch(NumberFormatException ex){//Creates a pop up window displaying an error when there is an invalid windowvalue
                            JOptionPane.showMessageDialog(window, "Please enter a valid positive integer for the window size.", "Input Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        
                    }
                });
//---------------------------------------------------------------------------------------Clearing Functionality
            //Clear button code
            JButton clearButton = new JButton("Clear");
                clearButton.setFocusable(false);
                clearButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){//clears all series, datasets, and charts
                        graphingData.clear();
                        groupData.removeAllSeries();
                        groupData.addSeries(graphingData);
                        saltedData.clear();
                        smoothedData.clear();
                        baseData.clear();
                        chart.setChart(scatter); 
                        System.out.println("Graph cleared.");
                        chart.repaint();//Repaints a blank graph
                    }
                });
//--------------------------------------------------------------------------------------------------------------------------------------------------------Export Button
            JButton export = new JButton("Export");//This export button calls the Export window method, creating a new window for the exporting process
                export.setFocusable(false);
                export.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        ExportWindow export = new ExportWindow();
                        export.exportWindowPop(baseData, saltedData, smoothedData, title);//Intakes the datasets, and title of the graph for Folder and File creation
                    }
                });
//-----------------------------------------------------------------------------------------------------------------------------------------------------------Panels
        //Adds button and text fields to a panel for use.
        JPanel controls = new JPanel();//Adds all of the buttons and text fields used for graphing, salting, and smoothing functionalitys to a panel withing the application window
            controls.add(new JLabel("Enter initial x-value: "));
            controls.add(initialX);
            controls.add(functionSelect);
            controls.add(button);
            controls.add(saltButton, BorderLayout.SOUTH);
            controls.add(new JLabel("Enter a Window Value: "), BorderLayout.SOUTH);
            controls.add(windowValue, BorderLayout.SOUTH);
            controls.add(smoothButton, BorderLayout.SOUTH);
            controls.add(clearButton);
            controls.setSize(100, 100);
        window.add(controls, BorderLayout.SOUTH);//Adds the panel to the bottom of the application window/JFrame

        JPanel exporter = new JPanel();//creates a new panel for the exporting button
            exporter.add(export);
            exporter.setSize(75, 75);
        window.add(exporter, BorderLayout.EAST);//Adds exporter panel to the right side of the application window/JFrame 
        window.pack();//This compacts all previous additions to the window making it pop up and fit properly into the application window for user usage
    }
}

