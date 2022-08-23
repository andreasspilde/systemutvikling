package inf112.skeleton.screens;


import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.Viewport;
import inf112.skeleton.app.Gems;
import inf112.skeleton.app.PlatformerGame;
import inf112.skeleton.app.PlayerInputProcessor;
import inf112.skeleton.app.WorldContactListener;
import inf112.skeleton.app.State.STATE;
import inf112.skeleton.app.entites.Player;
import inf112.skeleton.app.entites.Enemy;
import inf112.skeleton.app.map.ParseTiledmapObjects;
import inf112.skeleton.app.map.Levels;

public class GameScreen implements Screen {
	// pixel per meter. Used to convert From box2d unit to pixel and back.
	public static final float PPM = 16;
	private static final float SCALE = 0.9f;

	
	private World world;
	private Box2DDebugRenderer b2drBox2dDebugRenderer;
    private float screenHeight;
    private float screenWidth;
    
    TiledMap tiledMap;


    private int Numplayers = 2;
    Player player;
    Player player2;
    Enemy Monster1;

    TiledMapTileLayer playerLayer;
    private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera camera;
	private Viewport viewport;

	private TmxMapLoader tmxMapLoader;
	
	private PlatformerGame game;
	public static ArrayList<Body> scheduledForRemovalList;
	private Levels levels = new Levels();
	private String currentLevel;
	private boolean playerAtGoal;
	private int numGems;
	
	public boolean isPlayerAtGoal() {
		return playerAtGoal;
	}
	public void setIsPlayerAtGoal(boolean playerAtFlag) {
		this.playerAtGoal = playerAtFlag;
	}
	private void removeBodies() {
		if(!scheduledForRemovalList.isEmpty()) {
			if(!world.isLocked()){
				for(Body body : scheduledForRemovalList) {
					clearCells(body);
					world.destroyBody(body);
				}
			}
			
		}
		scheduledForRemovalList.clear();
	}
	private void update(float delta) {
		world.step(1/ 60f, 6, 2);
		removeBodies();
		cameraUpdate(delta);
		renderer.setView(camera);
		game.batch.setProjectionMatrix(camera.combined);
	}
    
    private void clearCells(Body body) {
    	try {
			TiledMapTileLayer layer = (TiledMapTileLayer)tiledMap.getLayers().get("Diamonds");
			int x = (int)body.getPosition().x;
			int y = (int)body.getPosition().y;
			if(layer.getCell(x, y) == null) {
				return;
			}
			layer.getCell(x, y).setTile(null);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	private void cameraUpdate(float delta) {
		Player playerCam = player;
		if(game.getNumPlayers()==2 && player.getCurrentState() == STATE.DEAD) {
			playerCam = player2;
		}
    	Vector3 position = camera.position;
    	position.x = playerCam.getBody().getPosition().x * PPM;
    	position.y = playerCam.getBody().getPosition().y * PPM;
    	camera.position.set(position);
		camera.update();
	}


    public GameScreen(PlatformerGame game, String level, int numPlayers)  {
    	this.game = game;
        Numplayers = numPlayers;
        this.currentLevel = level;
        playerAtGoal = false;
        scheduledForRemovalList = new ArrayList<>();
        //Create the world
        world = new World(new Vector2(0, -9.8f), false);
        b2drBox2dDebugRenderer = new Box2DDebugRenderer();
        world.setContactListener(new WorldContactListener(this));

        tiledMap = new TmxMapLoader().load(level);
        renderer = new OrthogonalTiledMapRenderer(tiledMap);
        // Adds the collision to walls, bricks.
        ParseTiledmapObjects.parsePolyLineObject(tiledMap.getLayers().get("Collision-layer").getObjects(), world);
        ParseTiledmapObjects.parsePolyLineObject(tiledMap.getLayers().get("Spikes").getObjects(), world, "spike");
        //Adds spawnPoints to the game
        ParseTiledmapObjects.parseSpawnPoints(tiledMap.getLayers().get("Enemy-Spawn"));
        ParseTiledmapObjects.parseSpawnPoints(tiledMap.getLayers().get("Player-Spawn"));
        
        ParseTiledmapObjects.parsePolyLineObject(tiledMap.getLayers().get("Collision-Monster").getObjects(), world, "monstercollison");
        ParseTiledmapObjects.parseRectObjects(tiledMap.getLayers().get("Goal").getObjects(), world, "goal", true);
        Gems gems = new Gems();
        gems.createBody(tiledMap.getLayers().get("Gems").getObjects(), world);
        numGems = tiledMap.getLayers().get("Gems").getObjects().getCount();
        
        
        

        // Size of the application window
        screenHeight = Gdx.graphics.getHeight();
        screenWidth = Gdx.graphics.getWidth();

        camera = new OrthographicCamera();
		camera.setToOrtho(false, screenWidth / 2, screenHeight / 2);
		// Creating the box2d player object
		Vector2 playerPos = ParseTiledmapObjects.getPlayerSpawnPoints().get(0);

		player =new Player(world, playerPos, (int)PPM, (int)PPM, PPM, SCALE);
		player.create();

        Vector2 EnemyPos = ParseTiledmapObjects.getEnemySpawnPoints().get(0);
        Monster1 =new Enemy(world, EnemyPos, (int)PPM, (int)PPM, PPM, 1);

        Monster1.create();

		if(Numplayers == 2) {
			Vector2 playerPos2 = ParseTiledmapObjects.getPlayerSpawnPoints().get(1);
			player2 = new Player(world, playerPos2, (int)PPM, (int)PPM, PPM, SCALE);
			player2.create();
		}
		
		// Input processor to handle inputs, can be changed to handle different input processors with input multiplexer
		if(Numplayers == 1) {
			PlayerInputProcessor inputProcessor = new PlayerInputProcessor(player);
			Gdx.input.setInputProcessor(inputProcessor);
		}
		else {
			PlayerInputProcessor inputProcessor = new PlayerInputProcessor(player, player2);
			Gdx.input.setInputProcessor(inputProcessor);
		}



//		Gdx.input.setInputProcessor(inputProcessor);
    }

    @Override
    public void dispose() {
        game.batch.dispose();
        player.dispose();
        player2.dispose();
        Monster1.dispose();
        tiledMap.dispose();
        b2drBox2dDebugRenderer.dispose();
        world.dispose();
        renderer.dispose();
        game.dispose();
    }

    @Override
    public void render(float delta) {
    	update(Gdx.graphics.getDeltaTime());
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

        renderer.render();
        game.batch.begin();
        if(!gameOverCheck()) {
        	if(!player.getCurrentState().equals(STATE.DEAD)) {
        	game.batch.draw(player.texturePlayer, player.getBody().getPosition().x*PPM - (PPM/2), player.getBody().getPosition().y*PPM
            		- (PPM/2), PPM*SCALE, PPM*SCALE);
        	}

        	// Game won --> change game
        	if(Numplayers == 2) {
        		if((player.getScore() + player2.getScore() == numGems) && playerAtGoal) {
        			game.dispose();
        			ParseTiledmapObjects.getPlayerSpawnPoints().clear();
            		ParseTiledmapObjects.getEnemySpawnPoints().clear();
        			if(currentLevel.equals(levels.getLevel(1))) {
        				game.setScreen(new MainMenu(game));
        			}
        			else {
        				game.setScreen(new GameScreen(game, levels.getLevel(1), game.getNumPlayers()));
        			}
                 	
        		}
        	} 
        	if((player.getScore() == numGems) && playerAtGoal) {
        		game.dispose();
        		ParseTiledmapObjects.getPlayerSpawnPoints().clear();
        		ParseTiledmapObjects.getEnemySpawnPoints().clear();
        		if(currentLevel.equals(levels.getLevel(1))) {
    				game.setScreen(new MainMenu(game));
    			}
    			else {
    				game.setScreen(new GameScreen(game, levels.getLevel(1), game.getNumPlayers()));
    			}
        	}
        	
        }
        else {
        	 if(Numplayers == 2) {
             	if(player.getCurrentState() == STATE.DEAD && player2.getCurrentState() == STATE.DEAD) {
             		game.dispose();
                 	game.setScreen(new GameScreen(game, currentLevel, game.getNumPlayers()));	

             	}
             }
             else {
             	game.dispose();
             	game.setScreen(new GameScreen(game, currentLevel, game.getNumPlayers()));

             }
        }
        
        game.batch.draw(Monster1.texturePlayer, Monster1.getBody().getPosition().x*PPM - (PPM/2), Monster1.getBody().getPosition().y*PPM
                - (PPM/2), PPM, PPM);

        if(Numplayers == 2 ) {
        	if(player2.getCurrentState() != STATE.DEAD) {
        		game.batch.draw(player2.texturePlayer, player2.getBody().getPosition().x*PPM - (PPM/2), player2.getBody().getPosition().y*PPM
                		- (PPM/2), PPM*SCALE, PPM*SCALE);
        	}
        	
        }
       
        // Make player move
        player.updateMotion();
        
        if(Numplayers ==2) {
        	player2.updateMotion();
        }
        //Make monster move
        Monster1.updateMotion();

        //Moves player2 to player 1 if outside screen
        if(player.getCurrentState() != STATE.DEAD && Numplayers  == 2) {
        	if(player2.getBody().getPosition().x > player.getBody().getPosition().x + 10 || player2.getBody().getPosition().x < player.getBody().getPosition().x - 10) {
        		player2.getBody().setTransform(player.getBody().getPosition().x, (player.getBody().getPosition().y + 1), 0);
        	}
        	if(player2.getBody().getPosition().y > player.getBody().getPosition().y + 8 || player2.getBody().getPosition().y < player.getBody().getPosition().y - 8){
        		player2.getBody().setTransform(player.getBody().getPosition().x, (player.getBody().getPosition().y + 1), 0);
        	}
        }
        game.batch.end();
        
//        b2drBox2dDebugRenderer.render(world, camera.combined.scl(PPM));
    }

    private boolean gameOverCheck() {
		if(Numplayers == 2) {
			return player.getCurrentState().equals(STATE.DEAD) && player2.getCurrentState().equals(STATE.DEAD);
		}
		return player.getCurrentState().equals(STATE.DEAD);
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

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
}
