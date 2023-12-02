package student.examples.ggengine.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import student.examples.ggengine.event.GamePublisher;
import student.examples.ggengine.game.GameState;
import student.examples.ggengine.services.GameService;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {
	
//	@Autowired
//	private GameEventPublisher gep;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping("/join/{id}")
	public Long joinGame(@PathVariable Long id) {
		//take id of the palyer
//		log.info(id);
//		gep.publishGameStatusChange(id, GameState.STARTED);
		//signal the start of the new game
		gameService.joinGame(id);
		return id;
	}
	
	@GetMapping("/leave")
	public void leaveGame() {
		//take id of the palyer
		gameService.leaveGame();
		
		//signal the leave of the new game
	}
}
