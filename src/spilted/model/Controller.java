package spilted.model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {
	Player player;
	
	public Controller(){
		this(new Player());
	}
	public Controller(Player p){
		setPlayer(p);
	}
	
	public void setPlayer(Player p){
		player = p;
	}
	
	@Override
	public void keyPressed (KeyEvent e)
	{
		//System.out.println(e.getKeyCode());
		switch (e.getKeyCode ()) 
		{
			case 87:
				player.movingUp(true);
				player.setDirection(Direction.Up);
				break;
			case 83:
				player.movingDown(true);
				player.setDirection(Direction.Down);
				break;
			case 68:
				player.movingRight(true);
				player.setDirection(Direction.Right);
				break;
			case 65:
				player.movingLeft(true);
				player.setDirection(Direction.Left);
				break;
			case 32:
				player.shooting(true);
				break;
			
		}
	}


	@Override
	public void keyReleased (KeyEvent e)
	{
		switch (e.getKeyCode ()) 
		{
			case 87:
				player.movingUp(false);
				break;
			case 83:
				player.movingDown(false);
				break;
			case 68:
				player.movingRight(false);
				break;
			case 65:
				player.movingLeft(false);
				break;
			case 32:
				player.shooting(false);
				break;
		}
	}


	@Override
	public void keyTyped (KeyEvent e) {}
	
	
	
}
