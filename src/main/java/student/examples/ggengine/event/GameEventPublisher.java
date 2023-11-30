package student.examples.ggengine.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import student.examples.ggengine.game.GameState;

@Component
public class GameEventPublisher {
	
	@Autowired
    private ApplicationEventPublisher applicationEventPublisher;
	
//	public GameEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
//		this.applicationEventPublisher=
//	}
	
	public void publishGameStatusChange(int id, GameState newStatus) {
		GameCreationEvent event = new GameCreationEvent(this, id, newStatus);
		applicationEventPublisher.publishEvent(event);
	}
}
