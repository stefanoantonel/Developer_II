package exampleFinal;

import javax.swing.JFrame;

public class CarApp {

   public static void main( String [] args ) {
	  JFrame frame = new CarAppGui();
      final int FRAME_WIDTH  = 600;
      final int FRAME_HEIGHT = 220;
      frame.setSize( FRAME_WIDTH, FRAME_HEIGHT );
	  frame.setLocationRelativeTo( null );
	  frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	  frame.setTitle( "Cars" );
	  frame.setVisible( true );
   }

} 

