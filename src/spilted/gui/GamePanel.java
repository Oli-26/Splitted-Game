package spilted.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import spilted.model.Bullet;
import spilted.model.Enemy;
import spilted.model.Game;
import spilted.model.GameObject;
import spilted.model.Item;
import spilted.model.Player;

public class GamePanel extends JPanel {
	Game game;
	public GamePanel(Game g){
		game = g;
		game.addObserver (new Observer ()
		{
			@Override
			public void update (Observable o, Object arg)
			{
				GamePanel.this.repaint ();
			}
		});
	}
	
	
	@Override
	public void paintComponent (Graphics g)
	{
		super.paintComponent (g);
		Graphics2D g2 = (Graphics2D) g;	
		this.setBackground (Color.black);
		this.paintObjects(g2);
		Player player = game.getPlayer();
		if(!player.isDestroyed()){
			this.paintPlayer(g2,player);
		}
		this.paintEnemies(g2);
		this.paintBullets(g2);
		this.paintItems(g2);
	}

	
	public void paintItems(Graphics2D g2){
		g2.setColor (Color.YELLOW);
		Collection<Item> items = game.getCurrentRoom().getItems();
		for(Item i: items){
			paintObject(g2,i);
		}
		
	}
	
	public void paintObjects (Graphics2D g2){
		Collection<GameObject> objects = game.getCurrentRoom().getObjects();
		for(GameObject obj : objects){
			paintObject(g2,obj);
		}
		
	}
	
	public void paintObject(Graphics2D g2,GameObject obj){
		g2.setColor (Color.GRAY);
		g2.draw(new Rectangle2D.Double(obj.getXPosition(), obj.getYPosition(),
                obj.getRadius(),
                obj.getRadius()));
	}
	
	public void paintEnemies(Graphics2D g2){
		g2.setColor (Color.RED);
		Collection<Enemy> enemies = game.getCurrentRoom().getEnemies();
		for(Enemy e: enemies){
			g2.draw(new Rectangle2D.Double(e.getXPosition(), e.getYPosition(),
	                e.getRadius(), e.getRadius()));
		}
	}
	
	public void paintBullets(Graphics2D g2){
		g2.setColor(Color.GRAY);
		Collection<Bullet> bullets = game.getCurrentRoom().getBullets();
		for(Bullet b: bullets){
			g2.draw(new Rectangle2D.Double(b.getXPosition(), b.getYPosition(),
	                b.getRadius(), b.getRadius()));
		}
	}
	
	public void paintPlayer(Graphics2D g2, Player player){
		g2.setColor (Color.GREEN);
		
		g2.draw(new Rectangle2D.Double(player.getXPosition(), player.getYPosition(),
                player.getRadius(), player.getRadius()));
		
		if(player.getHealth() > 0){
			g2.fill(new Rectangle2D.Double(10, 10,player.getHealth()*10, 5));
		}
		g2.drawString("Speed = " + player.getSpeed(), 10,30);
		g2.drawString("Range = " + player.getRange(), 10,50);
		g2.drawString("Damage = " + player.getDamage(), 10,70);
	}
	
}
