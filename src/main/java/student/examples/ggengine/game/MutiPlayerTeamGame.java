package student.examples.ggengine.game;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
public class MutiPlayerTeamGame extends Game implements HasPlayers, HasTeams {

	UUID id;
	Set<Item> items;
	HashMap<String, Team> teams;
	Set<Participant> participants;

	public MutiPlayerTeamGame() {
		items = new HashSet();
		teams = new HashMap();
		teams.put("Team A", new Team());
		teams.put("Team B", new Team());
		participants = new HashSet();
	}

	public HashMap<String, Team> getTeams() {
		return teams;
	}

	public Set<Participant> getPlayers() {
		return participants;
	}

	@Override
	public UUID getId() {
		return id;
	}

	@Override
	public Set<Item> getItems() {
		return items;
	}

}
