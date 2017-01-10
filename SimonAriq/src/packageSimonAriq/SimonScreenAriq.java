package packageSimonAriq;

import java.util.ArrayList;

import gui.Screens.ClickableScreen;
import gui.components.TextLabel;
import gui.components.Visible;

public class SimonScreenAriq extends ClickableScreen implements Runnable {
	
	public TextLabel simonTextLabel;
	public ButtonInterfaceAriq[] simonButton;
	public ProgressInterfaceAriq simonProgress;
	public ArrayList<MoveInterfaceAriq> simonArrayList;
	
	int roundNumber;
	boolean acceptingInput;
	int sequenceIndex;
	int lastSelectedButton;

	public SimonScreenAriq(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		addButtons();
		simonProgress = getProgress();
		simonTextLabel = new TextLabel(130,230,300,40,"Let's play Simon!");
		simonArrayList = new ArrayList<MoveInterface>();
		//add 2 moves to start
		lastSelectedButton = -1;
		simonArrayList.add(randomMove());
		simonArrayList.add(randomMove());
		roundNumber = 0;
		viewObjects.add(simonProgress);
		viewObjects.add(simonTextLabel);
		
	}

	private ProgressInterfaceAriq getProgress() {
		/**
		Placeholder until partner finishes implementation of ProgressInterface
		*/
		return null;
	}

	private void addButtons() {
		// TODO Auto-generated method stub
		
	}

}
