package combat;

import java.util.List;
import java.util.ArrayList;

public class KeyBinding {

	private int upKey;
	private int downKey;
	private int leftKey;
	private int rightKey;
	private int fireKey;

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

	public boolean ownsKey(int keyCode) {
		if (upKey == keyCode || downKey == keyCode || leftKey == keyCode
				|| rightKey == keyCode || fireKey == keyCode) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkForConflict(KeyBinding keyBinding){
		List<Integer> keyCodes = keyBinding.getKeyCodes();
		for(Integer keyCode : keyCodes){
			if(ownsKey(keyCode)){
				return true;
			}
		}
		return false;
	}
	
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
