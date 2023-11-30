package student.examples.ggengine.event;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;
import student.examples.ggengine.game.GameState;

@Getter
public class GameCreationEvent extends ApplicationEvent  {
	private int id;
	private GameState gameState;
	

	public GameCreationEvent(Object source, int id, GameState gameState) {
		super(source);
		this.id = id;
		this.gameState = gameState;
	}

}
