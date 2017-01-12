package partnerCodeInHerePlease;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import gui.components.Component;
import packageSimonAriq.ProgressInterfaceAriq;

public class Progress extends Component implements ProgressInterfaceAriq {
	
	private int size;
	private int roundNumber;
	private Color bgColor;
	private Color fontColor;
	private ArrayList<String> stringList;
	
	public Progress() {
		super(50, 50, 200, 100);
		Color limeGreen = new Color(125, 255, 100);
		bgColor = limeGreen;
		stringList = new ArrayList<String>();
		fontColor = Color.black;
	}

	@Override
	public void gameOver() {
		bgColor = Color.RED;
		stringList.add("WRONG, GAME OVER!");
		update();
	}

	@Override
	public void setSequenceSize(int size) {
		this.size = size;
		updateArrayList();
		update();
	}

	@Override
	public void setRound(int roundNumber) {
		this.roundNumber = roundNumber;
		updateArrayList();
		update();
	}
	
	public void updateArrayList() {
		while(stringList.size() > 0) stringList.remove(0);
		stringList.add("Round Number " + roundNumber);
		stringList.add("Sequence Length " + size);
	}
	
	@Override
	public void update(Graphics2D g) {
//		clear
		g = clear();		
		
//		draw label
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(bgColor);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, getWidth()-1, getHeight()-1);
		
//		draw text
		g.setColor(fontColor);
		Font font = new Font("Comic Sans", Font.PLAIN, 14);
		g.setFont(font);
		FontMetrics fm = g.getFontMetrics();
		if(stringList != null && stringList.size() > 0) {
			for(int i = 0; i < stringList.size(); i ++) {
				g.drawString(stringList.get(i), (getWidth()-fm.stringWidth(stringList.get(i))) / 2, (fm.getAscent() + fm.getDescent()) * (i+1));
			}
		}
	}

}
