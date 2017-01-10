package partnerCodeInHerePlease;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import gui.components.Action;
import gui.components.Component;
import packageSimonAriq.ButtonInterfaceAriq;

public class Button extends Component implements ButtonInterfaceAriq {
	/**
	 * need my partner to have setX(), setY() and setColor()
	 */
	private Color c;
	private int x;
	private int y;
	private static int width = 50;
	private static int height = 50; 
	
	public Button() {
		super(0, 0, width, height);
		update();
	}

	@Override
	public void act() {
		
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
	public BufferedImage getImage() {
		return null;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public boolean isAnimated() {
		return false;
	}

	@Override
	public void update() {
		
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(c != null) {
			g.setColor(c);
			g.fillOval(0, 0, width, height);
			g.setColor(Color.BLACK);
			g.drawOval(0, 0, width, height);
		}
	}

}
