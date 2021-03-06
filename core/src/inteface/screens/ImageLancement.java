package inteface.screens;

import inteface.manag.My1GdxGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ImageLancement implements Screen {
	
	My1GdxGame game;
	private float largeur_ecran;
	private float hauteur_ecran;
	private SpriteBatch batch;
	private Sprite arrierePlanSprite;
	private Sprite arrierePlanSpriteClique; 
	private boolean touch = false;
	 
    public ImageLancement(My1GdxGame g) {
        game = g;
    }
    
    private float xUnite(float x)
    {
           return x*largeur_ecran/480f;
    }
    
    private float yUnite(float y)
    {
           return y*hauteur_ecran/320;
    }

	@Override
	public void show() {
		
		 // Obtenir la taille de l'écran actuelle
		largeur_ecran = Gdx.graphics.getWidth();
        hauteur_ecran = Gdx.graphics.getHeight();
       
        batch = new SpriteBatch();
        
        // Charger Texture dans Sprite
        arrierePlanSprite = new Sprite(new Texture(Gdx.files.internal("logo1.png")));
        arrierePlanSpriteClique = new Sprite(new Texture(Gdx.files.internal("logo2.png")));
        
        arrierePlanSprite.setSize(xUnite(480), yUnite(320));
        arrierePlanSpriteClique.setSize(xUnite(480), yUnite(320));
		
        
	}
	
	

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(1, 1, 1, 1);
        manipulerMenu();
        
        if(touch == false){
        batch.begin();
        arrierePlanSprite.draw(batch);
        batch.end();  // obligatoire pour finir le dessin sur un SpriteBatch
        }
        
        if(touch == true){
            batch.begin();
            arrierePlanSpriteClique.draw(batch);
            batch.end();  // obligatoire pour finir le dessin sur un SpriteBatch
            }
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	public void manipulerMenu()
    {
          Gdx.input.setInputProcessor(new InputProcessor() {
        	  @Override
              public boolean touchUp(int x, int y, int pointer, int bouton) {
        		  game.setScreen(new Menu(game));
				return false;
        		  
        	  }
        	  
        	   public boolean touchDown(int x, int y, int pointer, int bouton) {
        		touch=true; 
				return false;
        		   
        	   }

			@Override
			public boolean keyDown(int keycode) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean keyUp(int keycode) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean keyTyped(char character) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean touchDragged(int screenX, int screenY, int pointer) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean mouseMoved(int screenX, int screenY) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean scrolled(int amount) {
				// TODO Auto-generated method stub
				return false;
			}
          });
          }

}
