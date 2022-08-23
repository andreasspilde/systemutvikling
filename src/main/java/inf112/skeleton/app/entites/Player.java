package inf112.skeleton.app.entites;

import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import inf112.skeleton.app.State.STATE;




public class Player extends GameEnitiy {

	private STATE currentState;
	private STATE previousState;
	private long timeOfJump;
	public Texture texturePlayer;
    private boolean leftMove;
    private boolean rightMove;
    private boolean upMove;
	private int score;



	@Override
    public void create () {
		texturePlayer = new Texture("A.png");
    }

    public Player(World world, Vector2 pos, int width, int height, float PPM, float scale) {
    	this.world = world;
    	this.body = createBody(world, pos, width, height, PPM, scale);
    	this.score = 0;
    	currentState = STATE.STANDING;
    	previousState = STATE.STANDING;
    	timeOfJump = 0;

    }
    public void updateMotion(){
		int horizontalForce = 0;

    	if (leftMove) {
    		horizontalForce -= 1;
				texturePlayer = new Texture("B.png");
    	}

    	if (rightMove) {
    		horizontalForce += 1;
			texturePlayer = new Texture("A.png");
    	}

    	if(isUpMove() && (TimeUtils.timeSinceMillis(timeOfJump) > 1000)) {
    		texturePlayer = new Texture("player_jump.png");
    		getBody().applyForceToCenter(0, 330, false);

    		timeOfJump = TimeUtils.millis();


    	}
    	getBody().setLinearVelocity(horizontalForce * 5, getBody().getLinearVelocity().y);
    }

    public void setLeftMove(boolean t) {
    	if(rightMove && t) {
    		rightMove = false;
    	}
	    leftMove = t;
    }

    public STATE getCurrentState() {
		return currentState;
	}

	public void setCurrentState(STATE currentState) {
		this.currentState = currentState;
	}
	
	public void setRightMove(boolean t) {
    	if(leftMove && t) {
    		leftMove = false;
    	}
	    rightMove = t;
    }


    public boolean isUpMove() {
    	return upMove;
    }

    public void setUpMove(boolean upMove) {
    	this.upMove = upMove;
    }


    public void setScore(int score) {
    	this.score = score;
    }

    public int getScore() {
    	return this.score;
    }
    @Override
    public boolean equals(Object obj) {
    	if(obj == null) {
    		return false;
    	}

    	if(!(obj instanceof Player)) {
			return false;
		}
    	Player otherPlayer = (Player) obj;
    	return this.getBody() == otherPlayer.getBody();

    }

	public void updateScore() {
		this.score = getScore() + 1;

	}

	//password:: checker123

}
