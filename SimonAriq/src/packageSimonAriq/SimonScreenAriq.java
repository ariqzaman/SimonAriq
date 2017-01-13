package packageSimonAriq;

import java.awt.Color;
import java.util.ArrayList;

import gui.Screens.ClickableScreen;
import gui.components.Action;

import gui.components.TextLabel;
import gui.components.Visible;
import partnerCodeInHerePlease.Button;
import partnerCodeInHerePlease.Move;
import partnerCodeInHerePlease.Progress;

public class SimonScreenAriq extends ClickableScreen implements Runnable {

	public TextLabel simonTextLabel;
	public ButtonInterfaceAriq[] simonButton;
	public ProgressInterfaceAriq simonProgress;
	public ArrayList<MoveInterfaceAriq> simonArrayList;

	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;

	public SimonScreenAriq(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		simonTextLabel.setText("");
		nextRound();
	}

	private void nextRound() {
		// TODO Auto-generated method stub
		acceptingInput = false;
		roundNumber++;
		simonArrayList.add(randomMove());
		simonProgress.setSequenceSize(simonArrayList.size());
		simonProgress.setRound(roundNumber);
		changeText("Simon's Turn");
		changeText("");
		playSequence();
		changeText("Your Turn");
		changeText("");
		acceptingInput = true;
		sequenceIndex = 0;
	}

	private void playSequence() {
		// TODO Auto-generated method stub
		ButtonInterfaceAriq b = null;
		for(int i = 0; i < simonArrayList.size(); i ++) {
			
			if(b != null) b.dim();
			
			b = simonArrayList.get(i).getButton();
	
			b.highlight();
			int sleepTime = (int)((1000/roundNumber + 1) * 2);
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(b!=null)b.dim();
	}

	private void changeText(String string) {
		// TODO Auto-generated method stub
		simonTextLabel.setText(string);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		addButtons(viewObjects);
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
		return new Move(b);
	}

	private ProgressInterfaceAriq getProgress() {
		/**
		Placeholder until partner finishes implementation of ProgressInterface
		 */
		return new Progress();
	}

	public ButtonInterfaceAriq getAButton(){

		return new Button();
	}

	private void addButtons(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		int numberOfButtons = 6;
		simonButton = new ButtonInterfaceAriq[numberOfButtons];

		Color[] color = {Color.blue, Color.pink, Color.green,  Color.yellow, Color.black, Color.red};
		int[] coordX = {600, 700, 800, 900, 1000, 1100};
		//int[] coordY = {300, 600, 400, 500, 400, 500};
		for(int i = 0; i < numberOfButtons; i ++) {
			simonButton[i] = getAButton();
			simonButton[i].setColor(color[i]);
			simonButton[i].setX(coordX[i]);
			simonButton[i].setY(100);
			final ButtonInterfaceAriq b = simonButton[i];
			simonButton[i].setAction(new Action() {

				public void act(){
					if(acceptingInput) {
						Thread blink = new Thread(new Runnable(){
							public void run(){
								b.highlight();
								try {
									Thread.sleep(800);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								b.dim();
							}
						});
						blink.start();
						if(b == simonArrayList.get(sequenceIndex).getButton()){
							sequenceIndex++;

						}
						else{
							simonProgress.gameOver();
						}
						if(sequenceIndex == simonArrayList.size()){
							Thread nextRound = new Thread(SimonScreenAriq.this);
							nextRound.start(); 
						}
					}
				}

			});
			simonButton[i] = b;
			viewObjects.add(b);

		}
	}
}
