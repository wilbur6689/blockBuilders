package blockBuilders;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyAdapt extends KeyAdapter {

	
	Player player1;
	Player player2;

	public KeyAdapt(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		
	}

	
	public void keyPressed(KeyEvent e) {
		//if the up key is pressed then p1.up(true)
		//if the w key is pressed then p2.up(true)
		
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_W) {
			player1.moveUp(true);
//Player 1
		} else if (key == KeyEvent.VK_S) {
			player1.moveDown(true);
			
		} else if (key == KeyEvent.VK_A) {
			player1.moveLeft(true);
			
		} else if (key == KeyEvent.VK_D) {
			player1.moveRight(true);

		} else if (key == KeyEvent.VK_SPACE) {
			player1.shootP1(true);
			
		} else if (key == KeyEvent.VK_G) {
			player1.placeBlock(true);
//Player 2			
		} else if (key == KeyEvent.VK_UP) {
			player2.moveUp(true);
			
		} else if (key == KeyEvent.VK_DOWN) {
			player2.moveRight(true);

		} else if (key == KeyEvent.VK_LEFT) {
			player2.moveLeft(true);

		} else if (key == KeyEvent.VK_RIGHT) {
			player2.moveRight(true);
			
		}  else if (key == KeyEvent.VK_ENTER) {
			player2.shootP2(true);
			
		} else if (key == KeyEvent.VK_SHIFT) {
			player2.placeBlock(true);
		}
		
		
		
		
		
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_W) {
			player1.moveUp(false);
//Player 1
		} else if (key == KeyEvent.VK_S) {
			player1.moveDown(false);
			
		} else if (key == KeyEvent.VK_A) {
			player1.moveLeft(false);
			
		} else if (key == KeyEvent.VK_D) {
			player1.moveRight(false);

		} else if (key == KeyEvent.VK_SPACE) {
			player1.shootP1(false);
			
		} else if (key == KeyEvent.VK_G) {
			player1.placeBlock(false);
//Player 2			
		} else if (key == KeyEvent.VK_KP_UP) {
			player2.moveUp(false);
			
		} else if (key == KeyEvent.VK_KP_DOWN) {
			player2.moveRight(false);

		} else if (key == KeyEvent.VK_KP_LEFT) {
			player2.moveLeft(false);

		} else if (key == KeyEvent.VK_KP_RIGHT) {
			player2.moveRight(false);
			
		}  else if (key == KeyEvent.VK_ENTER) {
			player2.shootP2(false);
			
		} else if (key == KeyEvent.VK_SHIFT) {
			player2.placeBlock(false);
		}
	}

}
