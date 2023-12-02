package student.examples.ggengine.event;

import java.util.UUID;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;
import student.examples.ggengine.game.GameState;

@Getter
public class GameEvent extends ApplicationEvent  {
	private UUID id;
	private GameState gameState;
	

	public GameEvent(Object source, UUID id, GameState gameState) {
		super(source);
		this.id = id;
		this.gameState = gameState;
	}

}
