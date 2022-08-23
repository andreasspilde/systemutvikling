package inf112.skeleton.app;


import com.badlogic.gdx.physics.box2d.*;
import inf112.skeleton.app.State.STATE;
import inf112.skeleton.app.entites.Enemy;
import inf112.skeleton.app.entites.Player;
import inf112.skeleton.app.map.Spike;
import inf112.skeleton.screens.GameScreen;

public class WorldContactListener implements ContactListener {

	GameScreen gameScreen;
	boolean isTest;
	public WorldContactListener(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
	}
	
	public WorldContactListener(boolean isTest) {
		this.isTest = isTest;
	}

	@Override
	public void beginContact(Contact contact) {
		Fixture fixA = contact.getFixtureA();
		Fixture fixB = contact.getFixtureB();
		
		if(fixA == null || fixB == null) {
			return;
		}

		if(isMonsterContact(fixA,fixB)){
			Fixture enemy = (fixA.getUserData() instanceof Enemy) ? fixA : fixB;
			if(enemy.getUserData() != null && enemy.getUserData() instanceof Enemy){
				((Enemy)  enemy.getUserData()).changeDirection();
			}
		}

		if(isSpikesContact(fixA, fixB)) {
			Fixture player = (fixA.getUserData() instanceof Player) ? fixA : fixB;
			Fixture spike = (player.equals(fixA)) ? fixB : fixA;
			if(player.getUserData() != null && player.getUserData() instanceof Player) {
				((Player) player.getUserData()).setCurrentState(STATE.DEAD);
				if(!isTest) {
				GameScreen.scheduledForRemovalList.add(player.getBody());
				}
			}

		} if(isGemContact(fixA, fixB)){
			Fixture player = (fixA.getUserData() instanceof Player) ? fixA : fixB;
			Fixture gem = (player.equals(fixA)) ? fixB : fixA;
			if(player.getUserData() != null && player.getUserData() instanceof Player) {
				((Player) player.getUserData()).updateScore();
			}
			if(gem.getUserData() != null && gem.getUserData() == "gem") {
				if(!isTest) {
				World world = ((Player) player.getUserData()).getWorld(); 
				if(!GameScreen.scheduledForRemovalList.contains(gem.getBody())) {
					GameScreen.scheduledForRemovalList.add(gem.getBody());
				}
				}
			}

		}

		if(MonsterKillPlayer(fixA, fixB)){
			Fixture player = (fixA.getUserData() instanceof Player) ? fixA : fixB;
			Fixture enemy = player.equals(fixA) ? fixB:fixA;
			if(player.getUserData() != null && player.getUserData() instanceof Player) {
				((Player) player.getUserData()).setCurrentState(STATE.DEAD);
				if(!isTest) {
				GameScreen.scheduledForRemovalList.add(player.getBody());
				}
			}
		}
		
		if(isGoalContact(fixA, fixB)) {
			gameScreen.setIsPlayerAtGoal(true);
		}

	}



	@Override
	public void endContact(Contact contact) {
		Fixture fixA = contact.getFixtureA();
		Fixture fixB = contact.getFixtureB();
		
		if(fixA == null || fixB == null) {
			return;
		}

		if(fixA == null || fixB == null) {
			return;
		}
		
		if(isGoalContact(fixA, fixB)) {
			gameScreen.setIsPlayerAtGoal(false);
		}
		
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		// TODO Auto-generated method stub
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		// TODO Auto-generated method stub
	}
	
	private boolean isSpikesContact(Fixture a, Fixture b) {
		if(a.getUserData() instanceof Spike || b.getUserData() instanceof Spike ) {
			return a.getUserData() instanceof Player || b.getUserData() instanceof Player;
		}
		
		return false;
	}
	
	private boolean isGemContact(Fixture a, Fixture b) {

		if(a.getUserData() == "gem" || b.getUserData() == "gem") {
			return a.getUserData() instanceof Player || b.getUserData() instanceof Player;
		}
				return false;
	}

	public boolean isMonsterContact(Fixture a, Fixture b) {
		if(a.getUserData() == "monstercollison" || b.getUserData() == "monstercollison") {
			return a.getUserData() instanceof Enemy || b.getUserData() instanceof Enemy;
		}
		return false;
	}

	public boolean MonsterKillPlayer(Fixture a, Fixture b){
		if(a.getUserData() instanceof Player || b.getUserData() instanceof Player) {
			return a.getUserData() instanceof Enemy || b.getUserData() instanceof Enemy;
		}
		return false;
	}


	private boolean isGoalContact(Fixture a, Fixture b) {
		if(a.getUserData() == "goal" || b.getUserData() == "goal") {
			return a.getUserData() instanceof Player || b.getUserData() instanceof Player;
		}
		return false;
	}

}
