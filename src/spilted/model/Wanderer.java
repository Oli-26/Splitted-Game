package spilted.model;

import java.util.Random;

public class Wanderer extends Enemy {

	public Wanderer(int xPos, int yPos, int xVel, int yVel, int r){
		super(xPos,yPos,xVel,yVel, r);
		Random rng = new Random();
		speed = rng.nextInt(15)+1;
	}
	
	@Override
	public void update(){
		Random rng = new Random();
		xVelocity = rng.nextInt(speed)-speed/2;
		yVelocity = rng.nextInt(speed)-speed/2;
	}
	
	
}
