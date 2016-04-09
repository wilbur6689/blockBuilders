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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameFrame extends JPanel implements ActionListener{
	
	Timer mainTimer;
	Player player1;
	Player player2;
	int enemyCount = 5;
	public static int level = 1;
	
	static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	static ArrayList<Missile> missiles  = new ArrayList<Missile>();
	static ArrayList<Block> blocks = new ArrayList<Block>();
	Random rand = new Random();
	
	public GameFrame() {
		setFocusable(true);
		
		player1 = new Player (250, 250);
		player2 = new Player (1000, 250);
		
		addKeyListener(new KeyAdapt(player1));
		addKeyListener(new KeyAdapt(player2));
		
		mainTimer = new Timer(10, this);
		mainTimer.start();
		
		startGame();
		
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		ImageIcon ic = new ImageIcon("D:/Eclipse Text Editor/gitRepo/blockBuilders/images/background.jpg");
		g2d.drawImage(ic.getImage(), 0,0, null);
		
		player1.draw(g2d);
		player2.draw(g2d);
		
		
		for (int i=0; i < enemies.size(); i++) {
			Enemy tempEnemy = enemies.get(i);
			tempEnemy.draw(g2d);
		}
		
		for (int i=0; i < missiles.size(); i++) {
			Missile tempMissile = missiles.get(i);
			tempMissile.draw(g2d);
		}
		
		for (int i = 0; i < blocks.size(); i++) {
			Block tempBlock = blocks.get(i);
			tempBlock.draw(g2d);
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
		
		for (int i = 0; i < blocks.size(); i++) {
			Block tempBlock = blocks.get(i);
			tempBlock.update(); 
		}
		               
		checkEnd();
		repaint();
		
		
	}

	public static void addEnemy(Enemy enemy1) {
		enemies.add(enemy1);
	}
	
	public static void removeEnemy (Enemy e) {
		enemies.remove(e);
	}
	
	public static void addBlock(Block block) {
		blocks.add(block);
	}
	
	
	public static void removeBlock (Block block) {
		blocks.remove(block);
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
			addEnemy(new Enemy(1200 + rand.nextInt(300),rand.nextInt(600)));
		}
	}
	
	public void checkEnd() {
		if (enemies.size() == 0) {
			level++;
			enemies.clear();
			missiles.clear();
			JOptionPane.showMessageDialog(null, "Good work, you have completed level " + (level-1) + ". lets move onto the next level!");
			startGame();
		}
	}
}
