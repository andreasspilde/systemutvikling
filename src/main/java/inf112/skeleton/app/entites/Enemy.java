package inf112.skeleton.app.entites;

import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import inf112.skeleton.app.State.STATE;


public class Enemy extends GameEnitiy {

    public World world;
    public Texture texturePlayer;
    private float x_velocity;

    @Override
    public void create () {
        texturePlayer = new Texture("resources/Monster_L.png");
    }

    public Enemy(World world, Vector2 pos, int width, int height, float PPM, float scale) {
        this.world = world;
        this.body = createBody(world, pos, width, height, PPM, scale);
        this.x_velocity = -2;
    }

    public void updateMotion () {
        getBody().setLinearVelocity(x_velocity,0);

    }

    public void changeDirection(){
        x_velocity = x_velocity * -1;
        if(x_velocity > 0){
            texturePlayer = new Texture("resources/Monste_R.png");
        }else {
            texturePlayer = new Texture("resources/Monster_L.png");
        }
    }


}

