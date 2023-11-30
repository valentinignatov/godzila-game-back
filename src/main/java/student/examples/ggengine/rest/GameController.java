package student.examples.ggengine.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import student.examples.ggengine.event.GameEventPublisher;
import student.examples.ggengine.game.GameState;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/game")
public class GameController {
	@Autowired
	private GameEventPublisher gep;
	
	@GetMapping("/join/{id}")
	public int joinGame(@PathVariable int id) {
		//take id of the palyer
//		log.info(id);
		gep.publishGameStatusChange(id, GameState.STARTED);
		//signal the start of the new game
		return id;
	}
	
	@GetMapping("/leave")
	public void leaveGame() {
		//take id of the palyer
		
		//signal the leave of the new game
	}
}
