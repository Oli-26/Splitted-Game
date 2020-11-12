package spilted.model;

import java.util.Random;

public class Jumper extends Enemy {
	public Jumper(int xPos, int yPos, int xVel, int yVel, int r){
		super(xPos,yPos,xVel,yVel, r);
		Random rng = new Random();
		speed = rng.nextInt(10)+150;
		this.setDamage(rng.nextInt(4)+1);
	}
	
	
	@Override
	public void move(Player p){
		Random rng = new Random(); 
		if(rng.nextInt(100) == 15){
			
			if(this.getXPosition() < p.getXPosition()){
				this.setXPosition(this.getXPosition()+speed+this.getXVelocity());
			
			
			}else{
				this.setXPosition(this.getXPosition()-speed+this.getXVelocity());
			}
		
			if(this.getYPosition() < p.getYPosition()){
				this.setYPosition(this.getYPosition()+speed+this.getYVelocity());
			
			
			}else{
				this.setYPosition(this.getYPosition()-speed+this.getYVelocity());
			}
		}
		
	}
	
}
