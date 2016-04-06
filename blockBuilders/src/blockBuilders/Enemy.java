package blockBuilders;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Enemy extends Entity{

	public Enemy(int x, int y) {
		super(x, y);
	}

	
	public void update() {
		
		y += 1;
		checkCollisions();
	}
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getEnemyImg(), x, y, null);
//		g2d.draw(getBounds());
	}
	
	
	public Image getEnemyImg() {
		
		ImageIcon ic = new ImageIcon("D:/Eclipse Text Editor/gitRepo/blockBuilders/images/monster.png");
		return ic.getImage();
	}
	
	public void checkCollisions() {
		for (int i=0; i < GameFrame.getMissileList().size(); i++) {
			Missile missile = GameFrame.getMissileList().get(i);
			
			if (getBounds().intersects(missile.getBounds())) {
				GameFrame.removeEnemy(this);
				GameFrame.removeMissile(missile);
			}
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, getEnemyImg().getWidth(null), 
				getEnemyImg().getHeight(null)); 
	}
	
}
