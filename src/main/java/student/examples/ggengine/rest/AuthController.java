package student.examples.ggengine.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import student.examples.ggengine.event.UserPublisher;
import student.examples.ggengine.services.AuthService;

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

	@GetMapping("/signin/{userName}/{userPassword}")
	public void signin(@PathVariable String userName,
					   @PathVariable String userPassword) {
		if (userName.equalsIgnoreCase("user" ) && userPassword.equalsIgnoreCase("user")) {
			userPublisher.publishUserIsSigned("User is signed in");
		}
	}
	
	@GetMapping("/signout")
	public void signout() {
		
	}
}
