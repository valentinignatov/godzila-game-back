package student.examples.ggengine.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import student.examples.ggengine.services.GameService;

@Slf4j
@Component
public class UserListener implements ApplicationListener<UserEvent> {
	
	@Autowired
	GameService gameService;
	
	@Override
	public void onApplicationEvent(UserEvent event) {
		log.info(event.getIsUserSigned());
		gameService.addUserWaiting();
	}

}
