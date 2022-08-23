package inf122.skeleton.app.CollisionTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

import inf112.skeleton.app.WorldContactListener;
import inf112.skeleton.app.State.STATE;
import inf112.skeleton.app.entites.Enemy;
import inf112.skeleton.app.entites.Player;

class EnemyTest {

	private static final float PPM = 16;
	private World world;
	private ArrayList<Body> bodies;
	private WorldContactListener worldContactListener;
	private Vector2 playerPos;
	private Player player;

	@BeforeEach
	void setUp() throws Exception {
		world = new World(new Vector2(0, 0), false); // No gravity in x or y direction.
		System.out.println("Setup started");
		bodies = new ArrayList<>();
		
		worldContactListener = new WorldContactListener(true);
		world.setContactListener(worldContactListener);
		playerPos = new Vector2(16, 0);
		
		player = new Player(world, playerPos, 2, 4, PPM, 1);
		bodies.add(player.getBody());

		
		System.out.println("Setup complete");

	}
	
	@Test
	void testKillsPlayer() {
		new Enemy(world, playerPos, (int)PPM, (int)PPM, (int)PPM, 1);
		world.step(1/60f, 6, 2);
		assertEquals(STATE.DEAD, player.getCurrentState());
	}

}
