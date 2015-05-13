package inteface.manag;

import inteface.screens.ImageLancement;
import inteface.screens.Menu;

import com.badlogic.gdx.Game;



public class My1GdxGame  extends Game{

	@Override
	public void create() {

		setScreen(new ImageLancement(this));

	}
}
