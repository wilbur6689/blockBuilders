package blockBuilders;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Player extends Entity {

	int velX, velY = 0;
	int speed = 3;

	public Player(int x, int y) {
		super(x, y);

	}

	public void update() {
		y += velY;
		x += velX;

		checkCollisions();
	}

	public void draw(Graphics2D g2d) {
		g2d.drawImage(getPlayerImg(), x, y, null);
		// g2d.draw(getBounds());
	}

	public Image getPlayerImg() {

		ImageIcon ic = new ImageIcon("D:/Eclipse Text Editor/gitRepo/blockBuilders/images/blockPlayer.png");
		return ic.getImage();
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_W) {
			velY = -speed;
		} else if (key == KeyEvent.VK_S) {
			velY = speed;
		} else if (key == KeyEvent.VK_A) {
			velX = -speed;

		} else if (key == KeyEvent.VK_D) {
			velX = speed;
		} else if (key == KeyEvent.VK_SPACE) {
			GameFrame.addMissile(new Missile(x, y));
		} else if (key == KeyEvent.VK_G) {
			GameFrame.addBlock(new Block(x, y));
		}

	}

	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_W) {
			velY = -0;
		} else if (key == KeyEvent.VK_S) {
			velY = 0;
		} else if (key == KeyEvent.VK_A) {
			velX = -0;

		} else if (key == KeyEvent.VK_D) {
			velX = 0;
		}
	}

	public void checkCollisions() {
		ArrayList<Enemy> enemies = GameFrame.getEnemyList();

		for (int i = 0; i < enemies.size(); i++) {
			Enemy tempEnemy = enemies.get(i);

			if (getBounds().intersects(tempEnemy.getBounds())) {
				JOptionPane.showMessageDialog(null, "you have died on level " + GameFrame.level + "try harder"); 
				System.exit(0);
			}
		}
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, getPlayerImg().getWidth(null), getPlayerImg().getHeight(null));
	}

}
