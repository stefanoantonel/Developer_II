package finalTest;

import javax.swing.JFrame;

public class BookGuiApp {

   public static void main( String [] args ) {
	  JFrame frame = new BookGui();
      final int FRAME_WIDTH  = 250;
      final int FRAME_HEIGHT = 300;
      frame.setSize( FRAME_WIDTH, FRAME_HEIGHT );
	  frame.setLocationRelativeTo( null );
	  frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	  frame.setTitle( "Books Administrator" );
	  frame.setVisible( true );
   }

} 

 