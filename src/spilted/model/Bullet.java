package spilted.model;

public class Bullet extends GameObject {
	
	private int lifeTime;
	private GameObject parent;
	private int damage;
	
	public Bullet(GameObject o, Direction d, int lt, int dam){
		super(o.getXPosition()+o.getRadius()/2, o.getYPosition()+o.getRadius()/2, o.getXVelocity(),o.getYVelocity(),2);
		parent = o;
		damage = dam;
		switch(d){
			case Up:
				this.setYVelocity(this.getYVelocity()-10);
				break;
			case Down:
				this.setYVelocity(this.getYVelocity()+10);
				break;
			case Left:
				this.setXVelocity(this.getXVelocity()-10);
				break;
			
			case Right:
				this.setXVelocity(this.getXVelocity()+10);
				break;
		}
		lifeTime = lt;
	}
	
	@Override
	public void move(){
		xPosition = xPosition + xVelocity;
		yPosition = yPosition + yVelocity;
		lifeTime--;
		
		if(lifeTime ==0){
			this.setDestroyed(true);
		}
		
	}
	
	public boolean isParent(GameObject o){
		if(parent == o){
			return true;
		}else{
			return false;
		}
	}
	
	
	public int getDamage(){
		return damage;
	}
	public void setDamage(int d){
		damage = d;
	}
}
