package student.examples.ggengine.game;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Game {
	private Set<Item> items = new HashSet<Item>();
	private GameState gameState = GameState.PENDING;
	//Set of players
}
