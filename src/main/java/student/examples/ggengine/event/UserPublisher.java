package student.examples.ggengine.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class UserPublisher {
	
	@Autowired
    private ApplicationEventPublisher applicationEventPublisher;
	
	public void publishUserIsSigned(String isUserSigned) {
		UserEvent event = new UserEvent(this, isUserSigned);
		applicationEventPublisher.publishEvent(event);
	}
}
