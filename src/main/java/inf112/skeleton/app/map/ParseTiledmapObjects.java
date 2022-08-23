package inf112.skeleton.app.map;

import java.util.ArrayList;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;

public class ParseTiledmapObjects {

	// pixel per tile
	private static float ppt = 16;
	private static final ArrayList<Vector2> playerSpawnPoints = new ArrayList<Vector2>();
	private static final ArrayList<Vector2> EnemySpawnPoints = new ArrayList<Vector2>();
	
	public static void parsePolyLineObject(MapObjects objects, World world) {
		for(MapObject object: objects) {
			Shape shape;
			if(object instanceof PolylineMapObject) {
				shape = createPolyLine((PolylineMapObject) object);
			}
			else {
				continue;
			}
			
			BodyDef bodyDef = new BodyDef();
			
			bodyDef.type = BodyDef.BodyType.StaticBody;
			Body body = world.createBody(bodyDef);
			body.createFixture(shape, 0);
			shape.dispose();
		}
	}
	
public static void parsePolyLineObject(MapObjects objects, World world, String name) {
		
		for(MapObject object: objects) {
			Shape shape;
			if(object instanceof PolylineMapObject) {
				shape = createPolyLine((PolylineMapObject) object);

			}
			else {
				continue;
			}
			
			BodyDef bodyDef = new BodyDef();
			
			bodyDef.type = BodyDef.BodyType.StaticBody;
			Body body = world.createBody(bodyDef);
			FixtureDef fDef = new FixtureDef();
			fDef.density = 1.0f;
			fDef.shape = shape;
			fDef.isSensor = true;
			if(name.equals("spike")) {
				Spike spike = new Spike(body);
				body.createFixture(fDef).setUserData(spike);
				shape.dispose();
			}
			else {
				body.createFixture(fDef).setUserData(name);
				shape.dispose();
			}
			
		}



	}

	private static ChainShape createPolyLine(PolylineMapObject polyline) {
		float[] vertices = polyline.getPolyline().getTransformedVertices();
		Vector2[] worldVertices = new Vector2[vertices.length/2];
		
		for(int i = 0; i < worldVertices.length; i++) {
			worldVertices[i] = new Vector2(vertices[i*2]/ppt, vertices[i*2 + 1]/ppt);
		}
		
		ChainShape cs = new ChainShape();
		cs.createChain(worldVertices);
		return cs;
	}
	
	/**
	 * @param MapLayer layer
	 * This method iterates over the objects of the layer. Points are made as rectangles in tiled.
	 * The x and y coordinates are extracted by casting the object as an RectangleMapObject then retrieve
	 * the rectangle object and finally get the x or y coordinate by getter method.
	 * A Vector2 object is then created with the x and y coordinate and then added to the ArrayList of playerSpawnPoints.
	 * @throws IllegalArgumentException is the layer has zero objects.
	 */
	
	public static void parseSpawnPoints(MapLayer layer) {
		if(layer.getObjects().getCount() == 0) {
			throw new IllegalArgumentException("This layer is empty!");
		}
		
		for(MapObject object: layer.getObjects()) {
			if(object instanceof RectangleMapObject) {
				float x = ((RectangleMapObject) object).getRectangle().getX() / ppt;
				float y = ((RectangleMapObject) object).getRectangle().getY() / ppt;
				Vector2 vector = new Vector2(x,y);
				
				
				if(layer.getName().equals("Player-Spawn")) {
					playerSpawnPoints.add(vector);
				}
				
				if(layer.getName().equals("Enemy-Spawn")) {
					EnemySpawnPoints.add(vector);
				}
			}
			
		}
	}
	
	
	
	public static void parseRectObjects(MapObjects objects, World world, String name, boolean isSensor) {

		for(MapObject object: objects) {
			if(!(object instanceof RectangleMapObject)) {
				continue;
			}
			RectangleMapObject rect = (RectangleMapObject) object;
			float x = (rect.getRectangle().x + rect.getRectangle().getWidth()/2)/ppt;
			float y = (rect.getRectangle().y + rect.getRectangle().getHeight()/2)/ppt;
			Vector2 pos = new Vector2(x,y);
			BodyDef bodyDef = new BodyDef();
			bodyDef.type = BodyDef.BodyType.StaticBody;
			
			bodyDef.position.set(pos);
			Body body = world.createBody(bodyDef);
			PolygonShape shape = new PolygonShape();
			float halfWidth = rect.getRectangle().getWidth() / 2;
			float halfHeight = rect.getRectangle().getHeight() / 2;
			shape.setAsBox(halfWidth / ppt, halfHeight / ppt);
			FixtureDef fixDeF = new FixtureDef();
			fixDeF.density = 0;
			fixDeF.shape = shape;
			fixDeF.isSensor = isSensor;
			body.createFixture(fixDeF).setUserData(name);
			shape.dispose();
		}
	}
	public static ArrayList<Vector2> getPlayerSpawnPoints(){
		return playerSpawnPoints;
	}

	public static ArrayList<Vector2> getEnemySpawnPoints(){
		return EnemySpawnPoints;
	}
}
