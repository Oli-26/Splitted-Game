package spilted.model;

import java.util.Random;

public class Expander extends Enemy {
	int expandTick;
	int originalSize;
	
	
	
	public Expander(int xPos, int yPos, int xVel, int yVel, int r){
		super(xPos,yPos,xVel,yVel, r);
		Random rng = new Random();
		speed = 0;
		this.setDamage(rng.nextInt(4)+1);
		originalSize = r;
		expandTick = 0;
	}
	
	
	@Override
	public void update(){
		Random rng = new Random();
		if(expandTick == 0){
			
			if(rng.nextInt(50)+1 == 24){
				expandTick = rng.nextInt(20)+30;
				
			}
			
			
		}else if(expandTick == 1){
			radius = originalSize;
			expandTick--;
		}else{
			radius++;
			expandTick--;
			
		}
		
		
	}
}
