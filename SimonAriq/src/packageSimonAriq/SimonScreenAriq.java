package packageSimonAriq;

import java.awt.Color;
import java.util.ArrayList;

import gui.Screens.ClickableScreen;
import gui.components.Action;
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
		simonArrayList = new ArrayList<MoveInterfaceAriq>();
		//add 2 moves to start
		lastSelectedButton = -1;
		simonArrayList.add(randomMove());
		simonArrayList.add(randomMove());
		roundNumber = 0;
		viewObjects.add(simonProgress);
		viewObjects.add(simonTextLabel);
		
	}

	private MoveInterfaceAriq randomMove() {
		ButtonInterfaceAriq b;
		int rand = (int) (Math.random() * simonButton.length);
		while(rand == lastSelectedButton)
		{
			rand = (int) (Math.random() * simonButton.length);
		}
		b = simonButton[rand];
		lastSelectedButton = rand;
		return getMove(b);
	}

	private MoveInterfaceAriq getMove(ButtonInterfaceAriq b) {
		// TODO Auto-generated method stub
		return null;
	}

	private ProgressInterfaceAriq getProgress() {
		/**
		Placeholder until partner finishes implementation of ProgressInterface
		*/
		return null;
	}
	
	public ButtonInterfaceAriq getAButton(){
		
		return null;
	}

	private void addButtons() {
		// TODO Auto-generated method stub
		int numberOfButtons = 5;
			simonButton = new ButtonInterfaceAriq[numberOfButtons];
			
			Color[] color = {Color.blue, Color.green, Color.yellow, Color.black, Color.red};
			for(int i = 0; i < numberOfButtons; i++){
				ButtonInterfaceAriq b = getAButton();
				
				b.setColor(color[i]);
				b.setX((int) (i * 100 * Math.sin(Math.PI/3)));
				b.setY((int) (i * 100 * Math.cos(Math.PI/3)));
				b.setAction(new Action(){
//				final ButtonInterfaceAriq b = simonButton[i];
				
				public void act(){
				
				}
				
				});

}
}
}
