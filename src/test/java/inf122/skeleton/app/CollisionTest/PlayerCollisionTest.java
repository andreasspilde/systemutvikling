package inf122.skeleton.app.CollisionTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

import com.badlogic.gdx.physics.box2d.World;


import inf112.skeleton.app.State.STATE;
import inf112.skeleton.app.WorldContactListener;
import inf112.skeleton.app.entites.Player;
import inf112.skeleton.app.map.Spike;

class PlayerCollisionTest {

	World world;
	WorldContactListener worldContactListener;
	Player player;
	Spike spike;
	static int PPM;
	Vector2 playerPos;
	ArrayList<Body> bodies;
	static Vector2[] spikePoints;

	
	@BeforeAll
	static void initializeSpikePoints() {
		spikePoints = new Vector2[5];
		spikePoints[0] = new Vector2(18, 0);
		spikePoints[1] = new Vector2(18.5f, 1);
		spikePoints[2] = new Vector2(19, 0);
		spikePoints[3] = new Vector2(19.5f, 1);
		spikePoints[4] = new Vector2(20, 0);
		
		PPM = 1; // No need to convert since we're not using graphics here.
		System.out.println("initialization done");
	}
	
	@BeforeEach
	void setUp() throws Exception {
		world = new World(new Vector2(0, 0), false); // No gravity in x or y direction.
		System.out.println("Setup started");
		bodies = new ArrayList<>();
		
		worldContactListener = new WorldContactListener(true);
		world.setContactListener(worldContactListener);
		playerPos = new Vector2(16, 0);
		
		spike = new Spike(spikePoints, world);
		player = new Player(world, playerPos, 2, 4, PPM, 1);
		bodies.add(player.getBody());
		bodies.add(spike.getBody());

		
		System.out.println("Setup complete");

	}

	@AfterEach
	void tearDown() throws Exception {
		for(Body body : bodies) {
			world.destroyBody(body);
		}
		world.dispose();
	}

	@Test
	void testIsSpikeContact() {
		//move body into spike

		System.out.println(player.getBody().getPosition().x);
		while(player.getCurrentState() != STATE.DEAD) {
			world.step(1/60f, 6, 2);
			player.getBody().setLinearVelocity(5, 0);
		}
		assertEquals(STATE.DEAD, player.getCurrentState());
	}

}
