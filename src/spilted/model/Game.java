package spilted.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;

public class Game extends Observable implements Runnable{

	Room currentRoom;
	Player player1;
	
	public Game(Player p){
		player1 = p;
		currentRoom = new Room(player1);
	}
	
	
	
	
	
	public Room getCurrentRoom(){
		return currentRoom;
	}
	public void setCurrentRoom(Room r){
		currentRoom = r;
	}
	public Player getPlayer(){
		return player1;
	}
	
	
	@Override
	public void run(){
		while(true){
			try{
				Thread.sleep(50);
				currentRoom.update();

				this.setChanged();
				this.notifyObservers();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	
}
