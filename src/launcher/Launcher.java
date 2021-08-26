package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
		
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Student octa = new Student(128459, "Antich", "Octavio", "otiantich@gmail.com", "https://github.com/octavioantich/tdp-proyecto-1", "/images/yo.jpg");
        		
            	SimplePresentationScreen frame = new SimplePresentationScreen(octa);
				frame.setVisible(true);
            }
        });
    }
}