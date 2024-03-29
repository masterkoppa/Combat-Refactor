package combat;
/** 
 * @author DevC
 * @version $Id: KeyBox.java,v 1.4 2012/04/08 03:50:18 DevA Exp $
 *
 * KeyBox holds the keyCode for the most recent input
 *
 * Revision History:
 *   $Log: KeyBox.java,v $
 *   Revision 1.4  2012/04/08 03:50:18  DevA
 *   Cleaned up the code to run with Java 1.6: removed unused imports,
 *   fixed some UI focus issues (introduced by new focus "features" in Java since
 *   our original implementation), and made the CommandInterpreter not a Singleton
 *
 *   Revision 1.3  2003/05/30 18:43:30  DevB
 *   Reformatted.
 *
 *   Revision 1.2  2000/05/09 14:05:46  DevC
 *   tracking bugs
 *
 *   Revision 1.1  2000/05/09 04:14:09  DevC
 *   Initial revision
 *
 */

import java.awt.event.*;

import javax.swing.*;

public class KeyBox extends JButton
{
	private static final long serialVersionUID = -1;
   
     int keyCode;
    
    /**
     * Sets the key code for the value in the box.
     * @param   KeyCode     The key code value.
     */
    public KeyBox()
    {
        super();
        addKeyListener( new TFListener() );
        addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				KeyBox.this.setText("...");
			}
        	
        });
    }
      
    /**
     * Gets the key code for the value in the box.
     * @return  KeyCode
     */
    public int getKeyCode(){
        return keyCode;
    }
    
    /**
     * Sets the key code for the value in the box.
     * @param   KeyCode     The key code value.
     */
    public void setKeyCode( int keyCode ){
        this.keyCode = keyCode;
        setText( KeyEvent.getKeyText(keyCode) );
        this.setSelected(false);
    }
    

    /**
     * custom Key Listener for this key box
     */
    public class TFListener implements KeyListener{
    	/**
    	 * constructor
    	 */
        public TFListener(){}
        
        /**
         * Fired when a key is pressed
         */
        @Override
		public void keyPressed( KeyEvent e ){
            int kc = e.getKeyCode();
            System.out.println("keyCode = " + e.getKeyCode());
            setKeyCode(kc);
        }
        
        /**
         * Fired when a key is released
         */
        @Override
		public void keyReleased( KeyEvent e ){}
        
        /**
         * fired when a key is typed
         */
        @Override
		public void keyTyped( KeyEvent e )
        {
        }
    }
    
}
