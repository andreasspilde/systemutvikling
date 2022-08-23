package inf112.skeleton.app;

import com.badlogic.gdx.InputAdapter;

import inf112.skeleton.app.entites.Player;

import com.badlogic.gdx.Input.Keys;

public class PlayerInputProcessor extends InputAdapter {
	
	Player player;
	Player player2;
	
	public PlayerInputProcessor(Player player) {
		this.player = player;
	}
	public PlayerInputProcessor(Player player, Player player2) {
		this.player = player;
		this.player2 = player2;
	}
	@Override
	public boolean keyDown(int keycode) {
		switch(keycode) {
			case Keys.LEFT:
				player.setLeftMove(true);
				break;
			case Keys.RIGHT:
				player.setRightMove(true);
				break;
			case Keys.UP:
				player.setUpMove(true);
				break;
			case Keys.A:
				if(player2 == null) {
					return true;
				}
				player2.setLeftMove(true);
				break;
			case Keys.D:
				if(player2 == null) {
					return true;
				}
				player2.setRightMove(true);
				break;
			case Keys.W:
				if(player2 == null) {
					return true;
				}
				player2.setUpMove(true);
				break;
				
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch(keycode) {
		case Keys.LEFT:
			player.setLeftMove(false);
			break;
		case Keys.RIGHT:
			player.setRightMove(false);;
			break;
		case Keys.UP:
			player.setUpMove(false);
			break;
		case Keys.A:
			if(player2 == null) {
				return true;
			}
			player2.setLeftMove(false);
			break;
		case Keys.D:
			if(player2 == null) {
				return true;
			}
			player2.setRightMove(false);
			break;
		case Keys.W:
			if(player2 == null) {
				return true;
			}
			player2.setUpMove(false);
			break;
		}
		return true;
	}
}