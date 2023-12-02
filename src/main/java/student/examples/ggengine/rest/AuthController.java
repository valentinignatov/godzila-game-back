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
import student.examples.ggengine.event.UserPublisher;
import student.examples.ggengine.services.AuthService;
import student.examples.ggengine.services.GameService;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

	@Autowired
	AuthService authService;

	@Autowired
	UserPublisher userPublisher;

	@Autowired
	GameService gameService;

	@GetMapping("/signin/{userName}/{userPassword}")
	public void signin(@PathVariable String userName, @PathVariable String userPassword) {
		if (userName.equalsIgnoreCase("user") && userPassword.equalsIgnoreCase("user")) {
			userPublisher.publishUserIsSigned("User is signed in");
		}
	}

	@GetMapping("/signout/{id}")
	public ResponseEntity signout(@PathVariable UUID id) {
		
		boolean isUserrRemoved = gameService.leaveGame(id);

		if (isUserrRemoved) {
			return new ResponseEntity<String>(" {status: \"success\", \"message\": \"user removed\"}",
					HttpStatus.OK);
		} else
			return new ResponseEntity<String>(" {status: \"failed\", \"message\": \"no such user to remove\"}",
					HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
	}
}
