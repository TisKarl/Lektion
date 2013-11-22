package prog2.inlamning.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import enemies.Enemy;

public class Game implements ApplicationListener {
	private SpriteBatch batch;

	private Enemy enemy;

	
	@Override
	public void create() {		
		batch = new SpriteBatch();
		enemy = new Enemy(20,20);	
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		
		if(Gdx.input.isTouched())
		{
			float x = Gdx.input.getX();
			float y = Gdx.graphics.getHeight() - Gdx.input.getY();
			
			if(enemy.getCollisionArea().contains(x, y))
			{
				System.out.println("Hit!");
				enemy.takeDamage(1);
			}
			else
			{
				System.out.println("Miss!");
				//System.out.println("X-enemy: "+enemy.getPosition().x);
				//System.out.println("Y-Enemy: "+enemy.getPosition().y);
				//System.out.println("Mouse X: "+x);
				//System.out.println("Mouse Y: "+y);
			}
		}
		
		enemy.update(Gdx.graphics.getDeltaTime());
		
		batch.begin();
		enemy.render(batch);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
