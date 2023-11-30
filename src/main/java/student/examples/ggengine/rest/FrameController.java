package student.examples.ggengine.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import student.examples.ggengine.conn.Frame;
import student.examples.ggengine.services.GameService;

@CrossOrigin
@RestController
public class FrameController {
	private GameService gameService;
	
	//Todo optimase
	FrameController(GameService gameService) {
		this.gameService = gameService;
	}
	
	@PostMapping("update")
	  public Frame getData() {
	    Frame frame = new Frame(0, gameService.getGames().stream().findFirst().get().getItems());
	    return frame;
	  }
}
