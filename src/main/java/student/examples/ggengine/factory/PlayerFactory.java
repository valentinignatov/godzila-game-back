package student.examples.ggengine.factory;

import java.util.UUID;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import student.examples.ggengine.game.Participant;
import student.examples.ggengine.game.Player;

@Slf4j
@Component
public class PlayerFactory implements ParticipantFactory {
	
	@Override
	public Participant createParticipant(UUID uuid, String name) {
		Participant player = new Player(uuid, name);
		log.info("In Player Factory, Player Created");
		return player;
	}
}
