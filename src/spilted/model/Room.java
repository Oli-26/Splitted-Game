package spilted.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Room {
	Collection<GameObject> objects;
	Collection<Enemy> enemies;
	Collection<Bullet> bullets;
	Collection<Item> items;
	Player player1;
	int tick;
	
	public Room(Player p){
		player1 = p;
		objects = new ArrayList<GameObject>();
		enemies = new ArrayList<Enemy>();
		bullets = new ArrayList<Bullet>();
		items = new ArrayList<Item>();
		tick = 0;
	}
	
	
	public Collection<GameObject> getObjects(){
		return objects;
	}
	public Collection<Enemy> getEnemies(){
		return enemies;
	}
	public Collection<Bullet> getBullets(){
		return bullets;
	}
	public Collection<Item> getItems(){
		return items;
	}
	
	
	public void addObject(GameObject obj){
		objects.add(obj);
	}
	public void addObject(Bullet b){
		bullets.add(b);
	}
	public void addObject(Enemy e){
		if(e!=null){
			enemies.add(e);
		}
	}
	public void addObject(Item i){
		items.add(i);
	}
	
	public void removeObject(GameObject obj){
		objects.remove(obj);
	}
	
	
	
	public void createNewEnemy(){
		Random rng = new Random();
		int type = rng.nextInt(4)+1;
		Enemy enemy;

		System.out.println("Creating enemy of type : " + type);
		do{
			
			switch(type){
				case 1:
					enemy = new Wanderer(rng.nextInt(499), rng.nextInt(499), 0,0,rng.nextInt(8)+1);
					break;
				case 2:
					enemy = new Tracker(rng.nextInt(499), rng.nextInt(499), 0,0,9);
					break;
				case 3:
					enemy = new Jumper(rng.nextInt(499), rng.nextInt(499), 0,0,12);
					break;
				case 4:
					enemy =new Expander(rng.nextInt(499), rng.nextInt(499), 0,0,5);
					break;
				default:
					enemy = new Wanderer(rng.nextInt(499), rng.nextInt(499), 0,0,4);
					break;
			
			}
			
		}while(player1.collides(enemy));
		enemies.add(enemy);
	}
	
	public void createNewItem(){
		Random rng = new Random();
		Item item;
		
		int type = rng.nextInt(4);
		System.out.println("Creating item of type : " + type);
		
		item = new Item(rng.nextInt(499), rng.nextInt(499),0,-1, 5);
		switch(type){
			case 1:
					item.setDamageUp(rng.nextInt(2)+1);
					break;
			case 2:
					item.setRangeUp(rng.nextInt(9)+1);
					break;
			case 3:
					item.setSpeedUp(rng.nextInt(2)+1);
					break;
			case 4:
					item.setHealthUp(rng.nextInt(1)+1);
					break;
			
		}
		items.add(item);
	}
	
	public void update(){
		
		if(tick == 0){
			createNewItem();
		}
		if(tick%100 == 0){
			createNewEnemy();
		}
		
		
		
		// Bullets
		Collection<Bullet> removeBullets = new ArrayList<Bullet>();
		for(Bullet b : bullets){
			b.update();
			b.move();
			
			for(Enemy e:enemies){
				if(b.collides(e) && !b.isDestroyed() && !e.isDestroyed() && !b.isParent(e)){
					b.setDestroyed(true);
					e.setDestroyed(true);
				}
			}
			
			if(b.collides(player1) && !b.isDestroyed() && !player1.isDestroyed() && !b.isParent(player1)){
				player1.setHealth(player1.getHealth() -b.getDamage());
			}
			if(b.isDestroyed()){
				removeBullets.add(b);
			}
			
		}
		for(Bullet b : removeBullets){
			bullets.remove(b);
		}
		
		// Enemies
		
		Collection<Enemy> removeEnemies = new ArrayList<Enemy>();
		for(Enemy e: enemies){
			e.update();
			e.move(player1);
			
			
			if(e.collides(player1) && !e.isDestroyed() && !player1.isDestroyed()){
				player1.setHealth(player1.getHealth() - e.getDamage());
				e.setDestroyed(true);
			}
			
			if(e.isDestroyed()){
				removeEnemies.add(e);
			}
		}
		for(Enemy e:removeEnemies){
			enemies.remove(e);
		}
		
		
		// Items
		Collection<Item> removeItems = new ArrayList<Item>();
		for(Item i: items){
			if(i.collides(player1) && !i.isDestroyed() && !player1.isDestroyed()){
				player1.itemUp(i);
				i.setDestroyed(true);
			}
			if(i.isDestroyed()){
				removeItems.add(i);
			}
		}
		
		for(Item i:removeItems){
			items.remove(i);
		}
		
		if(!player1.isDestroyed()){
			player1.move();
			if(player1.isShooting()){
				Bullet b = new Bullet(player1, player1.getDirection(), player1.getRange(),player1.getDamage());
				addObject(b);
			}
			if(player1.getHealth() <= 0){
				player1.setDestroyed(true);
			}
		}
		
		
		
		tick++;
		tick= tick%200;
	}
	
	
	
	
}
