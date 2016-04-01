package blockBuilders;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JPanel{
	
	
	public GameFrame() {
		setFocusable(true);
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawString("Hello World", 100, 100);
		
		ImageIcon ic = new ImageIcon("D:/Eclipse Text Editor/workspace/blockBuilders/images/planet.png");
		Image i = ic.getImage();
		
		g2d.drawImage(i, 200, 200, null);
	}


}
