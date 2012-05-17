package combat;

import java.util.List;
import java.util.ArrayList;

/**
 * Represents the current key bindings for a player.
 */
public class KeyBinding {

	/**
	 * private storage for keycodes related to specific actions
	 */
	private int upKey;
	private int downKey;
	private int leftKey;
	private int rightKey;
	private int fireKey;

	// getters and setters.
	public int getUpKey() {
		return upKey;
	}

	public void setUpKey(int upKey) {
		this.upKey = upKey;
	}

	public int getDownKey() {
		return downKey;
	}

	public void setDownKey(int downKey) {
		this.downKey = downKey;
	}

	public int getLeftKey() {
		return leftKey;
	}

	public void setLeftKey(int leftKey) {
		this.leftKey = leftKey;
	}

	public int getRightKey() {
		return rightKey;
	}

	public void setRightKey(int rightKey) {
		this.rightKey = rightKey;
	}

	public int getFireKey() {
		return fireKey;
	}

	public void setFireKey(int fireKey) {
		this.fireKey = fireKey;
	}

	/**
	 * Checks whether the player who owns this Keycode object uses the key in its bindings.
	 * @param keyCode The keycode of the key to check
	 * @return True if the key is used by this player, false otherwise.
	 */
	public boolean ownsKey(int keyCode) {
		if (upKey == keyCode || downKey == keyCode || leftKey == keyCode
				|| rightKey == keyCode || fireKey == keyCode) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Checks to see if there are any keys used by this key binding and another
	 * @param keyBinding The keyBinding to check against
	 * @return true if there is a conflict, false otherwise
	 */
	public boolean checkForConflict(KeyBinding keyBinding){
		List<Integer> keyCodes = keyBinding.getKeyCodes();
		for(Integer keyCode : keyCodes){
			if(ownsKey(keyCode)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Gets a list of all the key codes for keys assigned to this binding
	 * @return A list of all key codes
	 */
	public List<Integer> getKeyCodes(){
		List<Integer> keyCodes = new ArrayList<Integer>();
		keyCodes.add(upKey);
		keyCodes.add(downKey);
		keyCodes.add(leftKey);
		keyCodes.add(rightKey);
		keyCodes.add(fireKey);
		return keyCodes;
	}

}
