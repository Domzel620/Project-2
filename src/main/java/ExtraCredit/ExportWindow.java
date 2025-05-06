package ExtraCredit;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Part1_JavaPSSFIles.ChartImgCreator;
import Part1_JavaPSSFIles.DataHandler;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExportWindow {
    //----------------------------------------------------------------------------------------------Export Window Code----------------------------------------------------------------------------------------------------------------------------------------------------
    
    //Export Window method
    public void exportWindowPop(ArrayList<double[]> baseDataset, ArrayList<double[]> saltedDataset, ArrayList<double[]> smoothedDataset, String title){
        JFrame exportWindow = new JFrame("Export");//Creates the JFrame/window for the Exporting pop process
            exportWindow.pack();
            exportWindow.setLocationRelativeTo(null);
            exportWindow.setVisible(true);
            exportWindow.setSize(400, 200);
        
        JTextField fileLoc = new JTextField(25);//Text field for the user to input intended Filepath for exporting their data and graph
            fileLoc.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    String file = fileLoc.getText();
                    ChartImgCreator charter = new ChartImgCreator();
                    DataHandler writer = new DataHandler();
                    try {
                        String directory = file + File.separator + title;//Sets the directory string equal to the FilePath input from fileLoc JTextField and adds the graph title to the end of it. 
                                                                         //The graph title will be the name of the folder holding the data csvs and graph png
                        File f = new File(directory);//Gives the new file a File Path
                        if(!f.exists()){//Checks to see if the Folder already exists, if it does it will just store the files within the pre-existing folder
                            f.mkdirs();//If it doesn't exist it will create the new folder to hold the data
                            System.out.println("Folder Created!");
                        }  
                        writer.csvOverWriter(baseDataset, directory + File.separator + "base.csv");//the writer lines create a csv file for the baseData, saltedData, and smoothedData datasets
                        writer.csvOverWriter(saltedDataset, directory + File.separator + "salted.csv");
                        writer.csvOverWriter(smoothedDataset, directory + File.separator + "smoothed.csv");
                        charter.groupChartApp(baseDataset, "Base", saltedDataset, "Salted", smoothedDataset, "Smoothed", "groupChart.png", directory);//Creates a Chart PNG for the graphed datasets
                        System.out.println("Files exported to " + directory);
                        JOptionPane.showMessageDialog(exportWindow, "Files exported to: " + directory);//Creates a pop up window showing the filepath of the newly exporting folder
                        exportWindow.dispose();//Closes the window once the exporting process is complete
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(exportWindow, "Failed to export files: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);//Creates a pop up window if the export process fails, typically due to incorrect File Path
                    }
                }
            });
        JButton export = new JButton("Export");//Creates the Export button
            export.setFocusable(false);
            export.setToolTipText("Click to export your data");
            export.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    String file = fileLoc.getText();
                    ChartImgCreator charter = new ChartImgCreator();
                    DataHandler writer = new DataHandler();
                    try {
                        String directory = file + File.separator + title;//Sets the directory string equal to the FilePath input from fileLoc JTextField and adds the graph title to the end of it. 
                                                                         //The graph title will be the name of the folder holding the data csvs and graph png
                        File f = new File(directory);//Gives the new file a File Path
                        if(!f.exists()){//Checks to see if the Folder already exists, if it does it will just store the files within the pre-existing folder
                            f.mkdirs();//If it doesn't exist it will create the new folder to hold the data
                            System.out.println("Folder Created!");
                        }  
                        writer.csvOverWriter(baseDataset, directory + File.separator + "base.csv");//the writer lines create a csv file for the baseData, saltedData, and smoothedData datasets
                        writer.csvOverWriter(saltedDataset, directory + File.separator + "salted.csv");
                        writer.csvOverWriter(smoothedDataset, directory + File.separator + "smoothed.csv");
                        charter.groupChartApp(baseDataset, "Base", saltedDataset, "Salted", smoothedDataset, "Smoothed", "groupChart.png", directory);//Creates a Chart PNG for the graphed datasets
                        System.out.println("Files exported to " + directory);
                        JOptionPane.showMessageDialog(exportWindow, "Files exported to: " + directory);//Creates a pop up window showing the filepath of the newly exporting folder
                        exportWindow.dispose();//Closes the window once the exporting process is complete
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(exportWindow, "Failed to export files: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);//Creates a pop up window if the export process fails, typically due to incorrect File Path
                    }
                }
            });

        JPanel exportPanel = new JPanel();//Creates the Panel for the fileLoc Text Field and Export button to to be added to
            exportPanel.add(new JLabel("Enter File Location"));
            exportPanel.add(fileLoc);
            exportPanel.add(export, BorderLayout.SOUTH);
        exportWindow.add(exportPanel);//Adds the exportPanel panel to the exportWindow JFrame
        exportWindow.pack();//This compacts all previous additions to the window making it pop up and fit properly into the application window for user usage
    }
}
