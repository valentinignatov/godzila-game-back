package student.examples.ggengine.services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import student.examples.ggengine.factory.GameFactory;
import student.examples.ggengine.factory.MultiplayerTeamGameFactory;
import student.examples.ggengine.factory.ParticipantFactory;
import student.examples.ggengine.game.Game;
import student.examples.ggengine.game.GameState;
import student.examples.ggengine.game.Item;
import student.examples.ggengine.game.MutiPlayerTeamGame;
import student.examples.ggengine.game.Participant;
import student.examples.ggengine.game.Player;
import student.examples.ggengine.game.Rock;
import student.examples.ggengine.game.Team;

@Slf4j
@Getter
@Setter
@Service
public class GameService {

	@Autowired
	GameFactory gameFactory;

//	private Game game;
	private MutiPlayerTeamGame game;
	private Map<UUID,Participant> allParticipants;

//	@Autowired
//	MultiplayerTeamGameFactory multiplayerTeamGamefactory;

	@Autowired
	ParticipantFactory participantFactory;

	private Set<Game> games;

	public GameService() {
		init();
	}

	public void addGame() {
		games.add(gameFactory.createGame(null));
	}

	public void init() {
		games = new HashSet<Game>();
		allParticipants = new HashMap<UUID,Participant>();
		i = 0;
//		game = (MutiPlayerTeamGame) gameFactory.createGame(null);
	}
	
	//Waiting area here
	public void addUserWaiting() {
		UUID uuid = UUID.randomUUID();
		Participant participant = participantFactory.createParticipant(uuid, "randomName");
		allParticipants.put(uuid,participant);
		
	}

	@Scheduled(fixedRate = 15) // 15
	public void updateGameState() {
//	    rock.setTop(rock.getTop() + 1);
//	    rock = new Rock(
//	        rock.getWidth(), 
//	        rock.getHeight(), 
//	        rock.getSpeedX(), 
//	        rock.getSpeedY(), 
//	        rock.getTop() + 1,
//	        rock.getLeft(), 
//	        rock.getRotation(), 
//	        rock.getRotationSpeed(), 
//	        rock.getItemType());
//		Item item = items.stream().findFirst().get();
//		items.remove(item);
//		items.add(new Rock(
//				item.getWidth(), 
//				item.getHeight(), 
//				item.getSpeedX(), 
//				item.getSpeedY(), 
//				item.getTop() + 1,
//				item.getLeft(), 
//				item.getRotation(), 
//		        item.getRotationSpeed(), 
//		        item.getItemType()));
//		if (games.isEmpty()) {
//			return;
//		}
//		Game game = games.stream().findFirst().get();
//
//		Item item = game.getItems().stream().findFirst().get();
//		game.getItems().remove(item);
//
//		game.getItems().add(new Rock(item.getWidth(), item.getHeight(), item.getSpeedX(), item.getSpeedY(),
//				item.getTop() + 1, item.getLeft(), item.getRotation(), item.getRotationSpeed(), null));

//	    log.info("Update:" + rock.getTop());
	}

//	public void addGame() {
//		Game game = new Game();
//		game.getItems().add(new Rock(0, 0, 0, 0, 0, 0, 0, 0, null));
//		game.setGameState(GameState.STARTED);
//		games.add(game);

//		games.forEach(System.out::println);

//	}

	int i;

	public boolean joinGame(UUID id) {
//		Participant participant = participantFactory.createParticipant(1L, "randomName");
		Participant participant = allParticipants.get(id);
		
		if (participant == null) {
			return false;
		}
		
		Team team = new Team();
		team.add(participant);

		if (games.isEmpty()) {
			games.add(gameFactory.createGame(1L));
		}

		game = (MutiPlayerTeamGame) games.stream().findFirst().get();
		
		if (i <= 3) {
			game.getTeams().get("Team A").add(participant);
		}
		i++;

		if (i > 3 && i < 8) {
			game.getTeams().get("Team B").add(participant);
		}
		
		//Todo change the logic to work with multiple games
//		if (i == 8) {
//			i = 0;
//			games.add(gameFactory.createGame(1L));
//		}

		Rock rock = new Rock(0, 0, 0, 0, 0, 0, 0, 0, null);
		game.getTeams().get("Team A");
		game.getItems().add(rock);
		games.add(game);
		
		return true;

	}

	public void leaveGame() {

	}

	
}
