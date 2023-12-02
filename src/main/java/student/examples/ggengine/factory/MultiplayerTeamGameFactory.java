package student.examples.ggengine.factory;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import student.examples.ggengine.event.GamePublisher;
import student.examples.ggengine.game.Game;
import student.examples.ggengine.game.GameState;
import student.examples.ggengine.game.MutiPlayerTeamGame;

@Slf4j
@Component
@Getter
//@RequiredArgsConstructor
public class MultiplayerTeamGameFactory implements GameFactory {
	
	@Autowired
	private GamePublisher gep;
	
	MutiPlayerTeamGame multiPlayerTeamGame;
	
	public MultiplayerTeamGameFactory() {
		init();
	}

	private void init() {
		multiPlayerTeamGame = new MutiPlayerTeamGame();
	}

	@Override
	public MutiPlayerTeamGame createGame(Long id) {
//		gep.publishGameStatusChange(id, GameState.STARTED);
//		UUID id = UUID.randomUUID();
//		Game game = new MutiPlayerTeamGame();
//		UUID uuid = UUID.fromString(String.valueOf(id));
		gep.publishGameStatusChange(UUID.randomUUID(), GameState.STARTED);
		log.info("Multiplayer Team Game Created");
		
		
		return multiPlayerTeamGame;
	}

}
