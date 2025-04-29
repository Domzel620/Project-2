package JavaPSSFIles;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class ChartAppCreator {
        private JFreeChart scatter;
        private XYSeries graphingData;

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

                    if(initialX.getText() != null){
                        double x = Double.parseDouble(initialX.getText());
                        dataset = math.expFunc(x);
                        XYSeries newData = new XYSeries(title);

                        for(double[] coords : dataset){
                            graphingData.add(coords[0],coords[1]);
                        } 
                        System.out.println("Initial X-value: " + x);
                        initialX.setText("");
                        chart.repaint();
                    
                    }
                }
            });

            //Code for the Graphing Button
            JButton button = new JButton("Graph");
            button.setFocusable(false);
            button.setToolTipText("This will graph the selected function, based on your initial X-value");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    FunctionPlot math = new FunctionPlot();
                    ArrayList<double[]> dataset = new ArrayList<>();

                    if(initialX.getText() != null){
                        double x = Double.parseDouble(initialX.getText());
                        dataset = math.expFunc(x);
                        for(double[] coords : dataset){
                            graphingData.add(coords[0],coords[1]);
                        } 
                        System.out.println("Initial X-value: " + x);
                        initialX.setText("");
                        chart.repaint();
                    }
                }
            });
            //Code for a Clear Graph Button
            JButton clearButton = new JButton("Clear");
                clearButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        graphingData.clear();
                        chart.setChart(scatter); 
                        System.out.println("Graph cleared.");
                        chart.repaint();
                    }
                });
        JPanel controls = new JPanel();
            controls.add(new JLabel("Enter initial x-value: "));
            controls.add(initialX);
            controls.add(button);
            controls.add(clearButton);
            controls.setSize(100, 100);
        window.add(controls, BorderLayout.SOUTH);
    }
}
