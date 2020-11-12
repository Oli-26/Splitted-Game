package spilted.model;




public class GameObject {
	private boolean destroyed;
	protected int xPosition;
	protected int yPosition;
	protected int xVelocity;
	protected int yVelocity;
	protected int radius;
	
	
	
	public GameObject(){
		destroyed = false;
		xPosition = 0;
		yPosition = 0;
		xVelocity = 0;
		yVelocity = 0;
		radius = 1;
	}
	
	public GameObject(int xp, int yp, int xv, int yv, int r){
		destroyed = false;
		xPosition = xp;
		yPosition = yp;
		xVelocity = xv;
		yVelocity = yv;
		radius = r;
	}
	
	
	
	public int getXPosition(){
		return xPosition;
	}
	public int getYPosition(){
		return yPosition;
	}
	public int getXVelocity(){
		return xVelocity;
	}
	public int getYVelocity(){
		return yVelocity;
	}
	public int getRadius(){
		return radius;
	}
	
	
	public void setXPosition(int xPos){
		xPosition = xPos;
	}
	public void setYPosition(int yPos){
		yPosition = yPos;
	}
	public void setXVelocity(int xVel){
		xVelocity = xVel;
	}
	public void setYVelocity(int yVel){
		yVelocity = yVel;
	}
	public void setRadius(int r){
		radius = r;
	}
	
	
	
	public void setDestroyed(boolean b){
		destroyed = b;
	}
	public boolean isDestroyed(){
		return destroyed;
	}
	
	
	public void move(){
		
		
		int newXPosition = xPosition + xVelocity;
		int newYPosition = yPosition + yVelocity;
		if(!(newXPosition < 0) && !(newXPosition > 500)){
			xPosition = newXPosition;
		}
		if(!(newYPosition < 0) && !(newYPosition > 500)){
			yPosition = newYPosition;
		}
		
		
	}
	
	 
	public boolean collides (GameObject other) 
	{
		double distX = this.xPosition - other.getXPosition();
		double distY = this.yPosition - other.getYPosition();
		double distance = Math.sqrt(distX * distX + distY * distY);
		
		return distance < this.getRadius() + other.getRadius();
	}

	
	public void update(){
		
	}
}
