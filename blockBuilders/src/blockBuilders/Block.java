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
		ArrayList<Missile> missiles = GameFrame.getMissileList();
		
		for (int i=0; i < GameFrame.missiles.size(); i++) {
			Missile missile = GameFrame.missiles.get(i);
			
			if (getBounds().intersects(missile.getBounds())) {
				GameFrame.removeBlock(this);
				GameFrame.removeMissile(missile);
			}
		}
	}
	

	public Rectangle getBounds() {
		return new Rectangle(x, y, getBlockImg().getWidth(null), 
				getBlockImg().getHeight(null)); 
	}
	
}
