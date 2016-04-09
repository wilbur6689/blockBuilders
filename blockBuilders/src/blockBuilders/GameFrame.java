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
	static ArrayList<Missile> missilesP1  = new ArrayList<Missile>();
	static ArrayList<Missile> missilesP2  = new ArrayList<Missile>();
	static ArrayList<Block> blocks = new ArrayList<Block>();
	Random rand = new Random();
	
	public GameFrame() {
		setFocusable(true);
		
		player1 = new Player (250, 250);
		player2 = new Player (1000, 250);
		
		addKeyListener(new KeyAdapt(player1, player2));
		mainTimer = new Timer(10, this);
		mainTimer.start();
		
		startGame();
		
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		ImageIcon backGround = new ImageIcon("D:/Eclipse Text Editor/gitRepo/blockBuilders/images/background.jpg");
		g2d.drawImage(backGround.getImage(), 0,0, null);
		
		player1.drawP1(g2d);
		player2.drawP2(g2d);
		
		
		for (int i=0; i < enemies.size(); i++) {
			Enemy tempEnemy = enemies.get(i);
			tempEnemy.draw(g2d);
		}
		
		for (int i=0; i < missilesP1.size(); i++) {
			Missile tempMissile = missilesP1.get(i);
			tempMissile.drawP1(g2d);
		}
		
		for (int i=0; i < missilesP2.size(); i++) {
			Missile tempMissile = missilesP2.get(i);
			tempMissile.drawP2(g2d);
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
		
		for (int i=0; i < missilesP1.size(); i++) {
			Missile tempMissile = missilesP1.get(i);
			tempMissile.update(); 
		}
		
		for (int i=0; i < missilesP2.size(); i++) {
			Missile tempMissile = missilesP2.get(i);
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
	
	public static void addP1Missile(Missile missile) {
		missilesP1.add(missile);
	}
	
	public static void removeP1Missile (Missile missile) {
		missilesP1.remove(missile);
	}
	
	public static void addP2Missile(Missile missile) {
		missilesP2.add(missile);
	}
	
	public static void removeP2Missile (Missile missile) {
		missilesP2.remove(missile);
	}
	
	public static ArrayList<Missile> getMissileListP1() {
		return missilesP1;
	}
	
	public static ArrayList<Missile> getMissileListP2() {
		return missilesP2;
	}
	
	
	
	public void startGame() {
		
		enemyCount = level * 5;
		
		for (int i = 0;i < enemyCount; i++) {
			addEnemy(new Enemy(1200 + rand.nextInt(300),100 + rand.nextInt(200)));
		}
	}
	
	public void checkEnd() {
		if (enemies.size() == 0) {
			level++;
			enemies.clear();
			missilesP1.clear();
			missilesP2.clear();
			JOptionPane.showMessageDialog(null, "Good work, you have completed level " + (level-1) + ". lets move onto the next level!");
			startGame();
		}
	}
}
