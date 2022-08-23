package inf112.skeleton.app.map;

import java.util.Arrays;
import java.util.List;

public class Levels {
	public static List<String> levels = Arrays.asList("cave_platformer_prototype.tmx", "Map2.tmx", "Map3.tmx");
	
	public String getLevel(int i) {
		if(i<levels.size()) {
			return levels.get(i);
		}
		else {
			return levels.get(0);
		}
	}
}