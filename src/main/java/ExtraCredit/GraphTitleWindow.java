package ExtraCredit;

import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphTitleWindow {
    //---------------------------------------------------------------------------------------------------------------Graphing Title Code--------------------------------------------------------------------------
    
    //This window pops up before the graphing gui window does, it allows the user to give a title for their graph
    public void guiGraphTitleWindow(){
        JFrame titleWindow = new JFrame();//Creates the JFrame/window for the graph title creation method
            titleWindow.setLocationRelativeTo(null);
            titleWindow.setVisible(true);
            titleWindow.setSize(400, 200);

        JTextField graphName = new JTextField(25);// Creates a Textfield for the User to input their graph name.
            graphName.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    try {
                        ChartAppCreator graph = new ChartAppCreator();
                        String title = graphName.getText();
                        if(title.isEmpty()){//Checks to see if the graph name box is empty
                            throw new IOException();//If empty throw the IOException
                        }else{//If it isn't empty it calls the graphing application function and closes the title window
                            graph.graphApplication(title);
                            titleWindow.dispose();
                        }
                    } catch (IOException ex) {//If Exception is thrown it creates a pop up window asking the user to enter a valid name
                        JOptionPane.showMessageDialog(titleWindow, "Please enter a valid name: "+ ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }      
                }
            });

        JButton titleButton = new JButton("Start App");//Creates a button to start the graphing application once a title has been typed
            titleButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    try {
                        ChartAppCreator graph = new ChartAppCreator();
                        String title = graphName.getText();
                        if(title.isEmpty()){//Checks to see if the graph name box is empty
                            throw new IOException();//If empty throw the IOException
                        }else{//If it isn't empty it calls the graphing application function and closes the title window
                            graph.graphApplication(title);
                            titleWindow.dispose();//Closes the title window once the app starts up
                        }
                    } catch (IOException ex) {//If Exception is thrown it creates a pop up window asking the user to enter a valid name
                        JOptionPane.showMessageDialog(titleWindow, "Please enter a valid name: "+ ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }      
                }
            });
            JPanel titlePanel = new JPanel();//Creates the Panel that contains the Text field and button for adding a title and starting the app
                titlePanel.add(new JLabel("Enter Graph/File Title"));
                titlePanel.add(graphName);
                titlePanel.add(titleButton, BorderLayout.SOUTH);
            titleWindow.add(titlePanel);//Adds the TitlePanel to the Title Window JFrame
            titleWindow.pack();//This compacts all previous additions to the window making it pop up and fit properly into the application window for user usage
            
    }
}


