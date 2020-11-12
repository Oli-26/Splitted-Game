package spilted.model;

public class Item extends GameObject {
	private int speedUp;
	private int damageUp;
	private int healthUp;
	private int rangeUp;
	
	
	public Item(int xPos, int yPos, int xVel, int yVel, int r){
		super(xPos,yPos,xVel,yVel,r);
		speedUp = 0;
		damageUp = 0;
		healthUp = 0;
		rangeUp = 0;
	}
	
	public void setSpeedUp(int speed){
		speedUp = speed;
	}
	
	public void setDamageUp(int damage){
		damageUp = damage;
	}
	public void setHealthUp(int health){
		healthUp = health;
	}
	public void setRangeUp(int range){
		rangeUp = range;
	}
	
	
	
	public int getSpeedUp(){
		return speedUp;
	}
	public int getDamageUp(){
		return damageUp;
	}
	public int getHealthUp(){
		return healthUp;
	}
	public int getRangeUp(){
		return rangeUp;
	}
	
	
}
