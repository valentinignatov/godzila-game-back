package student.examples.ggengine.game;

import java.util.HashSet;
import java.util.Set;

public class Team implements ParticipantCollection  {
//	Set<Participant> participants;
	private Set<Participant> participants = new HashSet<Participant>();

	@Override
	public void add(Participant participant) {
		participants.add(participant);
		
	}

	@Override
	public void remove(Participant participant) {
		participants.remove(participant);
	}
}
