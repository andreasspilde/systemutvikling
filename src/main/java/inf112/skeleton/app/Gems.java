package inf112.skeleton.app;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;


import inf112.skeleton.screens.GameScreen;

public class Gems {

	private static final float PPM = GameScreen.PPM;
	private final float gemWidth = 14; // might fix
	private float gemHeigth = 11;
	private World world;
	
	public void createBody(MapObjects objects, World world) {
		this.world = world;
		for(MapObject object: objects) {
			if(!(object instanceof RectangleMapObject)) {
				continue;
			}
			RectangleMapObject rect = (RectangleMapObject) object;
			float x = (rect.getRectangle().x + 8)/PPM;
			float y = (rect.getRectangle().y + 8)/PPM;
			Vector2 pos = new Vector2(x,y);
			BodyDef bodyDef = new BodyDef();
			bodyDef.type = BodyDef.BodyType.StaticBody;
			
			bodyDef.position.set(pos);
			Body body = world.createBody(bodyDef);
			PolygonShape shape = new PolygonShape();
			float halfWidth = gemHeigth / 2;
			float halfHeight = gemHeigth / 2; // might fix ------------------------
			shape.setAsBox(halfWidth / PPM, halfWidth / PPM);
			FixtureDef fixDeF = new FixtureDef();
			fixDeF.density = 1.0f;
			fixDeF.shape = shape;
			body.createFixture(fixDeF).setUserData("gem");
			body.createFixture(shape, 0);
			shape.dispose();
		}
		
	}

	public World getWorld() {
		return world;
	}
}
