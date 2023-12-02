package student.examples.ggengine.event;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import student.examples.ggengine.game.GameState;

@Component
public class GamePublisher {
	
	@Autowired
    private ApplicationEventPublisher applicationEventPublisher;
	
//	public GameEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
//		this.applicationEventPublisher=
//	}
	
	public void publishGameStatusChange(UUID id, GameState newStatus) {
		GameEvent event = new GameEvent(this, id, newStatus);
		applicationEventPublisher.publishEvent(event);
	}
}
