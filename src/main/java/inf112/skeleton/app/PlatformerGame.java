package inf112.skeleton.app;

import java.util.Arrays;
import java.util.List;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import inf112.skeleton.screens.GameScreen;
import inf112.skeleton.screens.MainMenu;


public class PlatformerGame extends Game {


	public SpriteBatch batch; //All screens can use this
	private int numPlayers = 1;
	private List<String> levels = Arrays.asList("cave_platformer_prototype.tmx", "Map2.tmx");
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		Screen menuScreen = new MainMenu(this);
		setScreen(menuScreen);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
	}
	
	@Override
	public void pause() {
		// TODO Auto-generated method stub
		super.pause();
	}
	
	@Override
	public void resume() {
		// TODO Auto-generated method stub
		super.resume();
	}
	
	@Override
	public void render() {
		super.render();
	}
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		super.resize(width, height);
	}
	
	@Override
	public void setScreen(Screen screen) {
		// TODO Auto-generated method stub
		super.setScreen(screen);
	}
	
	@Override
	public Screen getScreen() {
		// TODO Auto-generated method stub
		return super.getScreen();
	}
	public void setNumPlayers(int numPlay) {
		this.numPlayers = numPlay;
	}
	public int getNumPlayers() {
		return this.numPlayers;
	}
}
