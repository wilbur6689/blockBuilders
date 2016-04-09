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
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getMissileImg(),  x+8,  y+23,  null);
	}
	
	public Image getMissileImg() {
		
		ImageIcon ic = new ImageIcon("D:/Eclipse Text Editor/gitRepo/blockBuilders/images/missile.png");
		return ic.getImage();
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x+8, y+23, getMissileImg().getWidth(null), 
				getMissileImg().getHeight(null)); 
	}
	
}
