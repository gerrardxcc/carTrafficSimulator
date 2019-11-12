import model.Road;
import model.Simulator;
import view.MainFrame;
import view.MapView;
import view.RoadRectangle;
import view.TrafficLightView;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.PrintWriter;

public class Controller {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();

        Simulator simulator = new Simulator();

        MapView mapView = new MapView();//c
        mapView.setSimulator(simulator);
        mapView.load("positions.csv");

        mainFrame.add(mapView, BorderLayout.CENTER);//c add mapview to mainframe

        mainFrame.pack();

        // make frame visible for user


        mainFrame.setVisible(true); //c
        mainFrame.addNewActionListener(event ->{
            simulator.getNewCity();
        });

        mainFrame.addOpenActionListener(event -> {
            simulator.load("data.csv");
        });
        mainFrame.addSaveActionListener(event -> {
            simulator.save("data.csv");
        });

        mainFrame.addExitActionListener(event ->System.exit(0) );

        KeyListener keyListener = new KeyListener(){

            public void keyPressed(KeyEvent event){
                printEventInfo("Key Pressed",event);
            }


            public void keyReleased(KeyEvent event) {

                printEventInfo("Key Released", event);

            }

            public void keyTyped(KeyEvent event) {

                printEventInfo("Key Typed", event);

            }

            private void printEventInfo(String str, KeyEvent e) {

                System.out.println(str);

                int code = e.getKeyCode();

                System.out.println("   Code: " + KeyEvent.getKeyText(code));

                System.out.println("   Char: " + e.getKeyChar());

                int mods = e.getModifiersEx();

                System.out.println("    Mods: "

                        + KeyEvent.getModifiersExText(mods));

                System.out.println("    Location: "

                        + keyboardLocation(e.getKeyLocation()));

                System.out.println("    Action? " + e.isActionKey());

            }

            private String keyboardLocation(int keybrd) {

                switch (keybrd) {

                    case KeyEvent.KEY_LOCATION_RIGHT:

                        return "Right";

                    case KeyEvent.KEY_LOCATION_LEFT:

                        return "Left";

                    case KeyEvent.KEY_LOCATION_NUMPAD:

                        return "NumPad";

                    case KeyEvent.KEY_LOCATION_STANDARD:

                        return "Standard";

                    case KeyEvent.KEY_LOCATION_UNKNOWN:

                    default:

                        return "Unknown";

                }

            }

        };

        mapView.setFocusable(true);
        mapView.addKeyListener(keyListener);



    }

}
