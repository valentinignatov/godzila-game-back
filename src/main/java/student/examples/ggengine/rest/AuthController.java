package student.examples.ggengine.rest;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import student.examples.ggengine.domain.entity.User;
import student.examples.ggengine.domain.entity.UserBean;
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
	
	@PostMapping("/signup")
	public ResponseEntity signup(@Valid@RequestBody User user) {
		return new ResponseEntity<>(authService.registerNewUserAccount(user), HttpStatus.OK);
	}
	
	@PostMapping("/signin")
	public ResponseEntity signin(@Valid@RequestBody UserBean user) {
		User response = authService.signinUserAccount(user.getUsername(), user.getPassword());
		
		gameService.addUserWaiting(response);

		if (response != null) {
			return new ResponseEntity<String>(" {status: \"success\", \"token\": \"" + response.getToken() + "\"}", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(" {status: \"failed\", \"message\": \"no such user\"}",HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
		}
	}

	@GetMapping("/signout/{id}")
	public ResponseEntity signout(@PathVariable UUID id) {
		boolean isUserrRemoved = gameService.leaveGame(id);//Remove user from allParticipants

		if (isUserrRemoved) {
			return new ResponseEntity<String>(" {status: \"success\", \"message\": \"user removed\"}", HttpStatus.OK);
		} else
			return new ResponseEntity<String>(" {status: \"failed\", \"message\": \"no such user to remove\"}",HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity findAll() {
		
		return new ResponseEntity<>(authService.findAll(), HttpStatus.OK);
	}
}
