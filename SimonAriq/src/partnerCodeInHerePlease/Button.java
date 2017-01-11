package partnerCodeInHerePlease;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import gui.components.Action;
import gui.components.Component;
import packageSimonAriq.ButtonInterfaceAriq;

public class Button extends Component implements ButtonInterfaceAriq {
	
	private Color c;
	private Color tempC;
	private static int width = 50;
	private static int height = 50; 
	private Action action;
	
	public Button() {
		super(0, 0, width, height);
		update();
	}

	@Override
	public void act() {
		action.act();
	}

	@Override
	public boolean isHovered(int x, int y) {
		return x>getX() && x<getX()+getWidth() && y > getY() && y<getY()+getHeight();
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getX() {
		return super.getX();
	}

	@Override
	public int getY() {
		return super.getY();
	}

	@Override
	public boolean isAnimated() {
		return false;
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(tempC != null) {
			g.setColor(tempC);
			g.fillOval(0, 0, width, height);
			g.setColor(Color.BLACK);
			g.drawOval(0, 0, width-1, height-1);
		}
	}

	@Override
	public void setColor(Color color) {
		c = color;
		tempC = Color.lightGray;
		update();
	}

	@Override
	public void setX(int i) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setY(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAction(Action action) {
		this.action = action;
	}

	@Override
	public void highlight() {
		tempC = c;
		update();
	}

	@Override
	public void dim() {
		tempC = Color.lightGray;
		update();
	}

}
