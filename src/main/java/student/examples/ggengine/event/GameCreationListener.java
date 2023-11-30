package student.examples.ggengine.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import student.examples.ggengine.services.GameService;

@Slf4j
@Component
public class GameCreationListener implements ApplicationListener<GameCreationEvent> {
	
	@Autowired
	private GameService gameService;

	@Override
	public void onApplicationEvent(GameCreationEvent event) {
		// TODO Auto-generated method stub
		log.info("id " + event.getId());
		log.info("status " + event.getGameState());
		gameService.addGame();
	}

}
