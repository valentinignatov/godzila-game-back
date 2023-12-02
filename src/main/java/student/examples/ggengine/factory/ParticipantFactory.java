package student.examples.ggengine.factory;

import student.examples.ggengine.game.Participant;

public interface ParticipantFactory {
	public Participant createParticipant(Long id,String name);
}
