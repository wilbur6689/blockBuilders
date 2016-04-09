package blockBuilders;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Block extends Entity{

	public Block(int x, int y) {
		super(x, y);
	}

	public void update() {
		
		//check to see if it has been hit with a bullet
		checkCollisions();
	}
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getBlockImg(),  x+5,  y+20,  null);
	}
	
public Image getBlockImg() {
		
		ImageIcon ic = new ImageIcon("D:/Eclipse Text Editor/gitRepo/blockBuilders/images/block.png");
		return ic.getImage();
	}
	
	public void checkCollisions() {
		ArrayList<Missile> missilesP1 = GameFrame.getMissileListP1();
		ArrayList<Missile> missilesP2 = GameFrame.getMissileListP2();
		
		
		for (int i=0; i < GameFrame.missilesP1.size(); i++) {
			Missile missile = GameFrame.missilesP1.get(i);
			
			if (getBounds().intersects(missile.getBoundsP1())) {
				GameFrame.removeBlock(this);
				GameFrame.removeP1Missile(missile);
			}
			
		}
		
		for (int i=0; i < GameFrame.missilesP2.size(); i++) {
			Missile missile = GameFrame.missilesP2.get(i);

			
			if (getBounds().intersects(missile.getBoundsP2())) {
				GameFrame.removeBlock(this);
				GameFrame.removeP2Missile(missile);
			}
		}
	}
	

	public Rectangle getBounds() {
		return new Rectangle(x+5, y+20 , getBlockImg().getWidth(null), 
				getBlockImg().getHeight(null)); 
	}
	
}
