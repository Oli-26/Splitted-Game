import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import spilted.gui.GameFrame;
import spilted.model.Controller;
import spilted.model.Enemy;
import spilted.model.Game;
import spilted.model.Item;
import spilted.model.Player;
import spilted.model.Wanderer;

public class Spilted {

	public static void main(String[] args) {
		
		Spilted spilted = new Spilted();
		JFrame frame = new JFrame("Main Menu");
		GridLayout layout = new GridLayout(3,1); 
		JPanel panel = new JPanel(layout);
		
		
		frame.setTitle ("Spilted");
		frame.setSize (800, 800);
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

		
		
		AbstractAction playAction = new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e){
				spilted.startGame();
			}
		};
		JButton playButton = new JButton();
		playButton.setAction(playAction);
		playButton.setText("Play game");
		
		
		panel.add(playButton);
		frame.add(panel);
		
		frame.setVisible(true);
		
	}
	
	
	public void startGame(){
		Player player1 = new Player();
		Game game = new Game(player1);
		Controller controller = new Controller(player1);
		
		new GameFrame(game,controller);
		game.getCurrentRoom().addObject((Enemy)new Wanderer(200,200,0,0,9));
		game.getCurrentRoom().addObject((Enemy)new Wanderer(250,200,0,0,9));
		game.getCurrentRoom().addObject((Enemy)new Wanderer(200,250,0,0,9));
		game.getCurrentRoom().addObject((Enemy)new Wanderer(200,300,0,0,9));
		game.getCurrentRoom().addObject((Enemy)new Wanderer(230,400,0,0,9));
		game.getCurrentRoom().addObject((Enemy)new Wanderer(250,250,0,0,9));
		

		Item firstItem = new Item(300,300,0,0,4);
		firstItem.setRangeUp(10);
		game.getCurrentRoom().addObject(firstItem);
		
		new Thread(game).start();
	}

	
	
}
