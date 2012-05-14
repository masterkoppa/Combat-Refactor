package combat;
/** 
 * @author DevC
 * @version $Id: CommandInterpreter.java,v 1.8 2012/04/08 03:50:18 DevA Exp $
 *
 * CommandInterpreter class.  Listens on the frame to grab keyboard events and
 *  pass them along to the game or the players
 *
 * Revision History:
 *   $Log: CommandInterpreter.java,v $
 *   Revision 1.8  2012/04/08 03:50:18  DevA
 *   Cleaned up the code to run with Java 1.6: removed unused imports,
 *   fixed some UI focus issues (introduced by new focus "features" in Java since
 *   our original implementation), and made the CommandInterpreter not a Singleton
 *
 *   Revision 1.7  2003/05/30 18:25:25  DevB
 *   Reformatted, and added an exception to register for
 *   completeness.
 *
 *   Revision 1.6  2000/05/11 22:19:24  DevC
 *   cleaned up code & corrected comments
 *
 *   Revision 1.5  2000/05/09 06:08:04  DevC
 *   error checking in the keyPressed;
 *   reset the command
 *
 *   Revision 1.4  2000/05/05 04:47:40  DevC
 *   implemented the remainder of the methods.
 *   Compiles with PM and a stub Player
 *
 *   Revision 1.3  2000/05/04 01:21:10  DevC
 *   set up as listener; set up singleton construct
 *
 *   Revision 1.1  2000/05/04 01:08:11  DevC
 *   Initial revision
 *
 *   Revision 1.2  2000/05/04 01:13:57  DevC
 *   changed from rose file to one that I created; cleaner
 *
 *
 *
 */

import java.awt.event.*;

import javax.swing.JFrame;

public class CommandInterpreter extends JFrame implements KeyListener
{
	private static final long serialVersionUID = -1;

    private int p1Command = 0;                //player 1's current command
    private int p2Command = 0;                //player 2's current command
    
    private KeyBinding p1cmdBinding;
    private KeyBinding p2cmdBinding;

    /**
     * Private constructor in order to follow the singleton pattern of
     * creation.
     */
    public CommandInterpreter(KeyBinding p1keyBindings, KeyBinding p2keyBindings)
    {
        //creation and setup for the main window for the system.
        super( "COMBAT!" );
        System.err.println("Creating the first command interpreter.");
        this.register(1, p1keyBindings);
        this.register(2,p2keyBindings);
    }

    /**
     * A No-op; we do nothing specific on a key type.
     * Here for completion and adherance of the KeyListener interface.
     * @param   e   The key event generated by the user
     */
    public void keyTyped(KeyEvent e)
    {
    }

    /**
     * Handles interpretation of key events; sets the player's command,
     * if the key was a command key.
     * @param   e   The key event generated by the user
     */
    public void keyPressed(KeyEvent e)
    {
        //get the key code for the event
        int code = e.getKeyCode();
                
        //determine if the key pressed is of interest and assign it to the
        // correct player
        if( p1cmdBinding.ownsKey(code))
        {
            p1Command = code;
        }
        else if(p2cmdBinding.ownsKey(code) )
        {
            p2Command = code;
        }
        
    }

    /**
     * A No-op; we do nothing specific on a key release.
     * Here for completion and adherance of the KeyListener interface.
     * @param   e   The key event generated by the user
     */
    public void keyReleased(KeyEvent e)
    {
    }

    /**
     * Gets the key code for a given player's command.
     * @param   player  The player to return the event for.
     * @return  The key code for player's next command.
     */
    public int getCommand( int player )
    {
        //holds the response
        int response = 0;
        
        //return the appropriate command determined by the player asking
        if( player == 1 )
        {
            response = p1Command;
            p1Command = 0;
        }
        else if( player == 2 )
        {
            response = p2Command;
            p2Command = 0;
        }
        
        return response;   
    }
    
    /**
     * Method to get the current key bindings
     * @param playerNum
     * @return
     */
    public KeyBinding getKeyBindings(int playerNum)
    {
    	if(playerNum == 1)
    		return p1cmdBinding;
    	else
    		return p2cmdBinding;
    }
    
    /**
     * Allows the PlayerManager to tell the CommandInterpreter what
     * keys they are interested in.
     * @param   playerNum   The player number.
     * @param   cmds[]      The player's commands to listen on.
     * @throws  IllegalArgumentException    If the player number is out of
     *                                      bounds.
     */
    public void register( int playerNum, KeyBinding keys)
    {
    	System.out.println("Register "+playerNum+" with commands: ");
    	/*for(int i = 0; i<cmds.length; i++)
    	{
    		System.out.println("	"+i+": "+cmds[i]);
    	}
    	System.out.println("");*/
        //check the player number and assign the array accordingly
        if( playerNum == 1 ) p1cmdBinding = keys; 
        else if( playerNum == 2 ) p2cmdBinding = keys;
        else throw new IllegalArgumentException("Invalid player number.");
    }
}
