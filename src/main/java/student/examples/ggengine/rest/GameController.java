package student.examples.ggengine.rest;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity joinGame(@PathVariable UUID id) {

		boolean isThereUser = gameService.joinGame(id);

		if (isThereUser) {
			return new ResponseEntity<String>("", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(" {status: \"failed\", \"message\": \"unauthorized game access\"}",
					HttpStatus.UNAUTHORIZED);
		}
	}

	@GetMapping("/leave/{id}")
	public ResponseEntity leaveGame(@PathVariable UUID id) {
		// take id of the palyer
		boolean isUserrRemoved = gameService.leaveGame(id);
		
		if (isUserrRemoved) {
			return new ResponseEntity<String>(" {status: \"failed\", \"message\": \"unauthorized game access\"}", HttpStatus.OK);
		} else
			return new ResponseEntity<String>(" {status: \"failed\", \"message\": \"no such user to remove\"}",
					HttpStatus.UNAUTHORIZED);
		// signal the leave of the new game
	}
}
