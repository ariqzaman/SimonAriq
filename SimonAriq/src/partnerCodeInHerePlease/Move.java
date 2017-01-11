package partnerCodeInHerePlease;

import packageSimonAriq.ButtonInterfaceAriq;
import packageSimonAriq.MoveInterfaceAriq;

public class Move implements MoveInterfaceAriq {

	private ButtonInterfaceAriq b;
	
	public Move(ButtonInterfaceAriq b) {
		this.b = b;
	}

	@Override
	public ButtonInterfaceAriq getButton() {
		return b;
	}

}
