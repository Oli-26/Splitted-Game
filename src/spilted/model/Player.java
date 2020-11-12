package spilted.model;


public class Player extends GameObject {

	private int speed;
	private int health;
	private int damage;
	private Direction direction; 
	private boolean shooting;
	private int range;
	
	
	
	public Player(){
		super(50,50,0,0,10);
		speed = 5;
		health = 10;
		range = 10;
		damage =1;
	}
	
	public void movingUp(boolean b){
		if(b){
			yVelocity = -1*speed;
		}else{
			yVelocity = 0;
		}
	}
	public void movingDown(boolean b){
		if(b){
			yVelocity = 1*speed;
		}else{
			yVelocity = 0;
		}
	}
	public void movingRight(boolean b){
		if(b){
			xVelocity = 1*speed;
		}else{
			xVelocity = 0;
		}
	}
	public void movingLeft(boolean b){
		if(b){
			xVelocity = -1*speed;
		}else{
			xVelocity = 0;
		}
	}
	
	public void shooting(boolean b){
		shooting = b;
	}
	
	public boolean isShooting(){
		return shooting;
	}
	
	public void setDirection(Direction d){
		direction = d;
	}
	
	public Direction getDirection(){
		return direction;
	}
	
	public int getRange(){
		return range;
	}
	
	public void setRange(int r){
		range = r;
	}
	
	
	public int getHealth(){
		return health;
	}
	
	public void setHealth(int h){
		health = h;
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
	
	public void itemUp(Item item){
		range = range+item.getRangeUp();
		speed = speed+item.getSpeedUp();
		health =health+item.getHealthUp();
		damage = damage+item.getDamageUp();
		
	}
	
}
