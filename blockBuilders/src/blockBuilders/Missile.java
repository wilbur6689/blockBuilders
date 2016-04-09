package blockBuilders;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Missile extends Entity{

	public Missile(int x, int y) {
		super(x, y);
	}

	public void update() {
		x += 3;
	}
	
	public void drawP1(Graphics2D g2d) {
		g2d.drawImage(getP1MissileImg(),  x+8,  y+23,  null);
	}
	
	public void drawP2(Graphics2D g2d) {
		g2d.drawImage(getP2MissileImg(),  x+8,  y+23,  null);
	}
	
	public Image getP1MissileImg() {
		
		ImageIcon ic = new ImageIcon("D:/Eclipse Text Editor/gitRepo/blockBuilders/images/missileP2.png");
		return ic.getImage();
	}	
	
	public Image getP2MissileImg() {
		
		ImageIcon ic = new ImageIcon("D:/Eclipse Text Editor/gitRepo/blockBuilders/images/missileP1.png");
		return ic.getImage();
	}
	
	public Rectangle getBoundsP1() {
		return new Rectangle(x+8, y+23, getP1MissileImg().getWidth(null), 
				getP2MissileImg().getHeight(null)); 
	}
	
	public Rectangle getBoundsP2() {
		return new Rectangle(x+8, y+23, getP2MissileImg().getWidth(null), 
				getP2MissileImg().getHeight(null)); 
	}
	
}
