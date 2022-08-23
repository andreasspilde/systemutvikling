package inf112.skeleton.app.entites;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public abstract class GameEnitiy extends Game {

    public SpriteBatch batch;
    public World world;
    public Body body;


    @Override
    public void create () {
    }
    public Body createBody (World world, Vector2 pos, int width, int height, float PPM, float scale) {
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.DynamicBody;
        def.fixedRotation = true;
        def.position.set(pos);
        Body playerBody = world.createBody(def);
        PolygonShape shape = new PolygonShape();
        float halfWidth = (float) width / 2;
        float halfHeight = (float) height / 2;
        shape.setAsBox(halfWidth *scale / PPM, halfHeight *scale / PPM);
        FixtureDef fixDeF = new FixtureDef();
        fixDeF.density = 1.0f;
        fixDeF.shape = shape;
        playerBody.createFixture(fixDeF).setUserData(this);
        shape.dispose();

        return playerBody;
    }

    public World getWorld () {
        return world;
    }

    public Body getBody () {
        return this.body;
    }

    public void dispose () {
        batch.dispose();
    }

    public void render () {
    }


}