import java.awt.EventQueue;

import javax.swing.UIManager;


public class FacePamphlet {

	//public static final String mFrame = null;
	//private static GUI mainFrame;
	//public static GUI mFrame;
//	public static int a =6;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
  					new GUI();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	    // You fill this in, along with any helper methods //
	}
	
}
