package blockBuilders;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameFrame extends JPanel implements ActionListener{
	
	Timer mainTimer;
	Player player1;
	int enemyCount = 5;
	int level = 1;
	
	static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	static ArrayList<Missile> missiles  = new ArrayList<Missile>();
	Random rand = new Random();
	
	public GameFrame() {
		setFocusable(true);
		
		player1 = new Player (250, 630);
		
		addKeyListener(new KeyAdapt(player1));
		
		
		mainTimer = new Timer(10, this);
		mainTimer.start();
		
		startGame();
		
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		player1.draw(g2d);
		
		for (int i=0; i < enemies.size(); i++) {
			Enemy tempEnemy = enemies.get(i);
			tempEnemy.draw(g2d);
		}
		
		for (int i=0; i < missiles.size(); i++) {
			Missile tempMissile = missiles.get(i);
			tempMissile.draw(g2d);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		player1.update();
		
		for (int i=0; i< enemies.size(); i++) {
			Enemy tempEnemy = enemies.get(i);
			tempEnemy.update();
		}
		
		for (int i=0; i < missiles.size(); i++) {
			Missile tempMissile = missiles.get(i);
			tempMissile.update(); 
		}
		
		repaint();
		
		
	}

	public static void addEnemy(Enemy enemy1) {
		enemies.add(enemy1);
	}
	
	public static void removeEnemy (Enemy e) {
		enemies.remove(e);
	}
	
	public static ArrayList<Enemy> getEnemyList() {
		return enemies;
	}
	
	public static void addMissile(Missile missile) {
		missiles.add(missile);
	}
	
	public static void removeMissile (Missile missile) {
		missiles.remove(missile);
	}
	
	public static ArrayList<Missile> getMissileList() {
		return missiles;
	}
	
	
	
	public void startGame() {
		
		enemyCount = level * 5;
		
		for (int i = 0;i < enemyCount; i++) {
			addEnemy(new Enemy(rand.nextInt(500), -10 + -rand.nextInt(800)));
		}
	}
}
