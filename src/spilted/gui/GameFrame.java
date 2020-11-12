package spilted.gui;

import javax.swing.JFrame;

import spilted.model.Controller;
import spilted.model.Game;

public class GameFrame extends JFrame {
	GamePanel panel;
	Game game;
	
	public GameFrame(Game g, Controller controller){
		game = g;
		this.setTitle ("Spilted");
		this.setSize (800, 800);
		this.addKeyListener (controller);
		this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

		panel = new GamePanel(game); 
		this.add(panel);
		this.setVisible (true);
		
	}
}
