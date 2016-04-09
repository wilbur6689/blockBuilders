package blockBuilders;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Enemy extends Entity{
	
	private int startX;

	public Enemy(int x, int y) {
		super(x, y);
		startX = x;
		
	}

	
	public void update() {
		
		x -= 1;
		checkCollisions();
		checkOffScreen();
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
		for (int i=0; i < GameFrame.getMissileListP1().size(); i++) {
			Missile missile = GameFrame.getMissileListP1().get(i);
			
			if (getBounds().intersects(missile.getBoundsP1())) {
				GameFrame.removeEnemy(this);
				GameFrame.removeP1Missile(missile);
			}
		}
		
		for (int i=0; i < GameFrame.getMissileListP2().size(); i++) {
			Missile missile = GameFrame.getMissileListP2().get(i);

			if (getBounds().intersects(missile.getBoundsP2())) {
				GameFrame.removeEnemy(this);
				GameFrame.removeP2Missile(missile);
			}
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, getEnemyImg().getWidth(null), 
				getEnemyImg().getHeight(null)); 
	}
	
	public void checkOffScreen() {
		if (x >= -20) {
			x = startX;
		}
	}
	
}
