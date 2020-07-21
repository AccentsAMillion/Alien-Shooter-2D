package edu.shc.prg335;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Shooter extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private Texture background;
	private Sprite gunSprite;
	private AnimatedSprite hero;
	private OrthographicCamera camera;
	
	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false,1080,1920);

		batch = new SpriteBatch();
		background = new Texture(Gdx.files.internal("shooterbackground.png"));
		Texture turretTexture = new Texture(Gdx.files.internal("turret.png"));
		gunSprite = new Sprite(turretTexture);
		hero = new AnimatedSprite(gunSprite);
		hero.setPosition(1000/2,0);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(background, 0, 0);
		hero.draw(batch);
		batch.end();
        
        handleInput();
        hero.move();
	}

    private void handleInput() {
        if(Gdx.input.isTouched()){
            int x = Gdx.input.getX();
            if(x > hero.getX()){
                hero.moveRight();
            }else{
                hero.moveLeft();
            }
        }
    }

    @Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
