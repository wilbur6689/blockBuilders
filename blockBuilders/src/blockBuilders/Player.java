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
	private int startX;
	

	public Player(int x, int y) {
		super(x, y);
		startX = x;

	}

	public void update() {
		y += velY;
		x += velX;

		checkCollisions();
		checkOffScreen();
	}

	public void drawP1(Graphics2D g2d) {
		g2d.drawImage(getPlayer1Img(), x, y, null);		
	}
	
	public void drawP2(Graphics2D g2d) {		
		g2d.drawImage(getPlayer2Img(), x, y, null);
	}

	public Image getPlayer1Img() {

		ImageIcon ic = new ImageIcon("D:/Eclipse Text Editor/gitRepo/blockBuilders/images/blockPlayer1.png");
		return ic.getImage();
	}

	public Image getPlayer2Img() {
		ImageIcon ic = new ImageIcon("D:/Eclipse Text Editor/gitRepo/blockBuilders/images/blockPlayer2.png");
		return ic.getImage();
	}



	public void moveUp(boolean action) {

		if (action == true) {
			velY =-speed;
		} else {
			velY = 0;
		}
		
	}

	public void moveDown(boolean action) {
		if (action == true) {
			velY =speed;
		} else {
			velY = 0;
		}
	}

	public void moveLeft(boolean action) {
		if (action == true) {
			velX = -speed;
		} else {
			velX = 0;
		}
	}

	public void moveRight(boolean action) {
		if (action == true) {
			velX =speed;
		} else {
			velX = 0;
		}
	}
	
	public void shootP1(boolean action) {
		if (action == true) {
			GameFrame.addP1Missile(new Missile(x, y));
		}
	}
	
	public void shootP2(boolean action) {
		if (action == true) {
			GameFrame.addP2Missile(new Missile(x, y));
		}
	}
	
	public void placeBlock(boolean action) {
		if (action == true) {
			GameFrame.addBlock(new Block(x, y));
		}
	}
	
	public void checkOffScreen() {
		if (x <= -20) {
			x = startX;
		}
	}


	public void checkCollisions() {
		ArrayList<Enemy> enemies = GameFrame.getEnemyList();

		for (int i = 0; i < enemies.size(); i++) {
			Enemy tempEnemy = enemies.get(i);

			if (getBoundsP1().intersects(tempEnemy.getBounds())) {
				JOptionPane.showMessageDialog(null, "you have died on level " + GameFrame.level + "try harder");
				System.exit(0);
			}
		}
		
		for (int i = 0; i < enemies.size(); i++) {
			Enemy tempEnemy = enemies.get(i);

			if (getBoundsP2().intersects(tempEnemy.getBounds())) {
				JOptionPane.showMessageDialog(null, "you have died on level " + GameFrame.level + "try harder");
				System.exit(0);
			}
		}
	}

	public Rectangle getBoundsP1() {
		return new Rectangle(x, y, getPlayer1Img().getWidth(null), getPlayer1Img().getHeight(null));
	}
	
	public Rectangle getBoundsP2() {
		return new Rectangle(x, y, getPlayer2Img().getWidth(null), getPlayer2Img().getHeight(null));
	}

}
