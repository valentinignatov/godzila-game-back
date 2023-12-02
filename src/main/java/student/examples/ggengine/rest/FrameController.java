package student.examples.ggengine.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import student.examples.ggengine.conn.Frame;
import student.examples.ggengine.game.Game;
import student.examples.ggengine.services.GameService;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class FrameController {
	
//	@Autowired
	private GameService gameService;
	
	//Todo optimase
	
	@PostMapping("update")
	  public Frame getData() {
	    Frame frame = new Frame(0, gameService.getGames().stream().findFirst().get().getItems());
	    return frame;
	  }
}
