package blockBuilders;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyAdapt extends KeyAdapter {

	
	Player player1;
	Player player2;

	public KeyAdapt(Player player) {
		player1 = player;
		player2 = player;
		
	}
	
	
	
	public void keyPressedP1(KeyEvent e) {
		player1.keyPressedP1(e);
	}
	
	public void keyReleasedP1(KeyEvent e) {
		player1.keyReleasedP1(e);
	}
	
	public void keyPressedP2(KeyEvent f) {
		player2.keyPressedP2(f);
	}
	
	public void keyReleasedP2(KeyEvent f) {
		player2.keyReleasedP2(f);
	}
}
