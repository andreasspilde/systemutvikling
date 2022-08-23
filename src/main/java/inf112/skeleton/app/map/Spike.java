package inf112.skeleton.app.map;


import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;


public class Spike {

	public Body getBody() {
		return body;
	}
	public void setBody(Body body) {
		this.body = body;
	}
	World world;
	Body body;
	public Spike(Body body) {
		this.body = body;
	}
	public Spike(Vector2[] vertices, World world) {
		this.world = world;
		body = createBody(vertices);
	}
	
	private Body createBody(Vector2[] vertices) {
		
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.StaticBody;
		Body body = world.createBody(bodyDef);
		
		ChainShape cs = new ChainShape();
		cs.createChain(vertices);
		FixtureDef fDef = new FixtureDef();
		fDef.density = 1.0f;
		fDef.shape = cs;
		fDef.isSensor = true;
		body.createFixture(fDef).setUserData(this);
		cs.dispose();
		return body;
	}
	public void onContact() {
		System.out.println("Spike been hit");
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
    		return false;
    	}
		
		if(!(obj instanceof Spike)) {
			return false;
		}
    	Spike otherPlayer = (Spike) obj;
    	return this.getBody() == otherPlayer.getBody();
	}
}
