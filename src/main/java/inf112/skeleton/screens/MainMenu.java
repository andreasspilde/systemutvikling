package inf112.skeleton.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.Viewport;

import inf112.skeleton.app.PlatformerGame;
import inf112.skeleton.app.map.Levels;
public class MainMenu implements Screen {


	private PlatformerGame game;
	private Texture singlePlayerButtonUnpressed;
	private Texture singleplayerButtonPressed;
	private Texture multiplayerButtonUnpressed;
	private Texture multiplayerButtonPressed;
	private Texture exitButtonUnpressed;
	private Texture exitButtonPressed;
	Levels levels = new Levels();
	private OrthographicCamera camera;
	float screenHeight;
    float screenWidth;
    private Texture background;

	public MainMenu(PlatformerGame game) {
		this.game = game;
		this.singlePlayerButtonUnpressed = new Texture("SINGLEPLAYER_UNPRESSED.png");
		this.singleplayerButtonPressed = new Texture("SINGLEPLAYER_PRESSED.png");
		this.multiplayerButtonUnpressed = new Texture("MULTIPLAYER_UNPRESSED.png");
		this.multiplayerButtonPressed = new Texture("MULTIPLAYER_PRESSED.png");
		this.exitButtonUnpressed = new Texture("EXIT_UNPRESSED.png");
		this.exitButtonPressed = new Texture("EXIT_PRESSED.png");
		this.background = new Texture("mainmenu_background.PNG");
		screenHeight = Gdx.graphics.getHeight();
	    screenWidth = Gdx.graphics.getWidth();
	    camera = new OrthographicCamera();
	    camera.setToOrtho(false, (float) screenWidth / 2, (float) screenHeight / 2);
	    Vector3 position = camera.position;
	    position.x = 160;
	    position.y = 120;
	    camera.position.set(position);
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        camera.update(); 
        game.batch.setProjectionMatrix(camera.combined);
        
        //game.batch.draw(startButtonUnpressed, 0, 150);
        //game.batch.draw(exitButtonUnpressed, 0, 0);
        //Når vi vil tilpasse bildene til alt...
        //float breddeScale = Gdx.graphics.getWidth() / 360;
        //float hoydeScale = Gdx.graphics.getHeight() / 640;
        game.batch.draw(background, 0, 0);
        //Exit button
        if(Gdx.input.getX() > 0  && Gdx.input.getX() < 300 && Gdx.input.getY() > 330 && Gdx.input.getY() < 480) {
        	game.batch.draw(exitButtonPressed, 0 , 0, (float) exitButtonPressed.getWidth()/2, (float) exitButtonPressed.getHeight()/2);
        	if(Gdx.input.isTouched()) {
        		Gdx.app.exit();
        	}
        }
        else game.batch.draw(exitButtonUnpressed, 0 , 0,  (float) exitButtonUnpressed.getWidth()/2, (float) exitButtonUnpressed.getHeight()/2);
        //Two player button
        if(Gdx.input.getX() > 0 && Gdx.input.getX() < 300 && Gdx.input.getY() > 180 && Gdx.input.getY() < 330 ) {
        	game.batch.draw(multiplayerButtonPressed, 0, 80, (float) multiplayerButtonPressed.getWidth()/2, (float) multiplayerButtonPressed.getHeight()/2);
        	if(Gdx.input.isTouched()) {
        		startGame(2);
        	}
        }
        else game.batch.draw(multiplayerButtonUnpressed, 0 ,80, (float) multiplayerButtonUnpressed.getWidth()/2, (float) multiplayerButtonUnpressed.getHeight()/2);
        //One player button
        if(Gdx.input.getX() > 0 && Gdx.input.getX() < 300 && Gdx.input.getY() > 0 && Gdx.input.getY() < 180) {
        	game.batch.draw(singleplayerButtonPressed, 0 ,160, (float) singleplayerButtonPressed.getWidth()/2, (float) singleplayerButtonPressed.getHeight()/2);
        	if(Gdx.input.isTouched()) {
        		startGame(1);
        	}
        }
        else game.batch.draw(singlePlayerButtonUnpressed, 0, 160, (float) singlePlayerButtonUnpressed.getWidth()/2, (float) singlePlayerButtonUnpressed.getHeight()/2);
        
        game.batch.end();

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose() {
		game.dispose();
	}
	public void startGame(int numPlayer) {
		game.getScreen().dispose();
		game.setNumPlayers(numPlayer);
		game.setScreen(new GameScreen(game, levels.getLevel(0), numPlayer));
	}

}
