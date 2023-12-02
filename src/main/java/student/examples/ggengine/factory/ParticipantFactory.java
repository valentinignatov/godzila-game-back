package student.examples.ggengine.factory;

import java.util.UUID;

import student.examples.ggengine.game.Participant;

public interface ParticipantFactory {
	public Participant createParticipant(UUID uuid,String name);
}
