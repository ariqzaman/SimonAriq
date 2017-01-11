package packageSimonAriq;

import gui.GUIApplication;


public class SimonGameAriq extends GUIApplication {




	
	public SimonGameAriq(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	
	}

	@Override
	public void initScreen() {
		// TODO Auto-generated method stub
		SimonScreenAriq ssa = new SimonScreenAriq(getWidth(), getHeight()); 
		setScreen(ssa);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimonGameAriq sga = new SimonGameAriq(800,500);
		Thread game = new Thread(sga);
		game.start();
	}

}
