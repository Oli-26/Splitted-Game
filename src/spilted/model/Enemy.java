package spilted.model;

public class Enemy extends GameObject {
	private int damage;
	protected int speed;
	
	public Enemy(int xPos, int yPos, int xVel, int yVel, int r){
		super(xPos,yPos,xVel,yVel, r);
		damage = 2;
	}
	
	public int getDamage(){
		return damage;
	}
	public void setDamage(int d){
		damage = d;
	}
	
	public int getSpeed(){
		return speed;
	}
	
	public void setSpeed(int s){
		speed = s;
	}
	
	public void move(Player p){

		int newXPosition = xPosition + xVelocity;
		int newYPosition = yPosition + yVelocity;
		if(!(newXPosition < 0) && !(newXPosition > 500)){
			xPosition = newXPosition;
		}
		if(!(newYPosition < 0) && !(newYPosition > 500)){
			yPosition = newYPosition;
		}
	}
}
