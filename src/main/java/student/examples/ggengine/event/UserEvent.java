package student.examples.ggengine.event;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

@Getter
public class UserEvent extends ApplicationEvent {
	
	private String isUserSigned;

	public UserEvent(Object source, String isUserSigned) {
		super(source);
		this.source = source;
		this.isUserSigned = isUserSigned;
	}

}
