package enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Enemy {
	private Vector2 position;
	private int width = 50;
	private int height = 50;
	
	private Rectangle area;
	
	private Texture texture;
	private TextureRegion region;
	
	private boolean isDead;
	
	private int hitPoints;
	
	public void takeDamage(int damage)
	{
		hitPoints = hitPoints - damage;
	}
	
	
	
	
	public Enemy(float x, float y)
	{
		position = new Vector2(x,y);
		area = new Rectangle(x,y,width,height);
		
		texture = new Texture(Gdx.files.internal("data/block.png"));
		//texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		region = new TextureRegion(texture, 0, 0, 50, 50);
		
		hitPoints = 20;
		
		
	}
	
	public Rectangle getCollisionArea()
	{
		area.x = position.x;
		area.y = position.y;
		
		return area;
	}
	
	public void render(SpriteBatch batch)
	{
		batch.draw(region,position.x,position.y);
	}
	
	public void update(float delta)
	{
		if(hitPoints < 1)
		{
			isDead = true;
			System.out.println("I died!");
		}
		else
		{
			System.out.println("I have " + hitPoints + " hitpoints left!");
		}
	}

	public Vector2 getPosition() {		
		return position;
	}
	
}
