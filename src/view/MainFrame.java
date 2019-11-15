package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener{ // extend JFrame
    private JMenuItem n1;
    private JMenuItem open;
    private JMenuItem save;
    private JMenuItem exit;
    private JMenuItem s1;
    private JMenuItem s2;

    public MainFrame(){
        super("CarTrafficSimulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        JMenu city = new JMenu("City editing");
        JMenu simulator = new JMenu("Simulator");

        menuBar.add(city);
        menuBar.add(simulator);

        n1 = new JMenuItem("New city");
        open = new JMenuItem("Open a city");
        save = new JMenuItem("Save a city");
        exit = new JMenuItem("Exit a city");
        city.add(n1);
        city.add(open);
        city.add(save);
        city.add(exit);

        // setup simulator menu with menuitems
        s1 = new JMenuItem("Start");
        s2 = new JMenuItem("Stop");
        simulator.add(s1);
        simulator.add(s2);


        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1,2));
        JLabel label = new JLabel("Mode");
        JLabel label1 = new JLabel("Status");
        bottomPanel.add(label);
        bottomPanel.add(label1);

        add(BorderLayout.SOUTH,bottomPanel);
        add(BorderLayout.NORTH,menuBar);
        pack();

    }
    public void addNewActionListener(ActionListener listener) {
        n1.addActionListener(listener);
    }
    public void addOpenActionListener(ActionListener listener) {
        open.addActionListener(listener);
    }
    public void addSaveActionListener(ActionListener listener){
        save.addActionListener(listener);
    }
    public void addExitActionListener(ActionListener listener) {
        exit.addActionListener(listener);
    }
    public void addStartActionListener(ActionListener listener){
        s1.addActionListener(listener);
    }
    public void addStopActionListener(ActionListener listener){
        s2.addActionListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
