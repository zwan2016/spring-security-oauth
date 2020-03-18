package org.springframework.security.oauth.examples.sparklr.mvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth.examples.sparklr.domain.User;
import org.springframework.security.oauth.examples.sparklr.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by zwan on 1/13/20.
 */
@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ObjectMapper objectMapper;

	@PostMapping("/register")
	public ModelAndView register(@ModelAttribute User user)
	{
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return new ModelAndView("../../index");
	}

	@RequestMapping(value = "/user", params = "format=json")
	public ResponseEntity<String> getUser(Principal principal) throws JsonProcessingException {
		User user = userRepository.findByUsername(principal.getName());
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/javascript");
		return new ResponseEntity<String>(objectMapper.writeValueAsString(user), headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/user", params = "format=string")
	public ResponseEntity<String> getUserOAuth(Principal principal) throws JsonProcessingException {
		User user = userRepository.findByUsername(principal.getName());
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "text/plain");
		System.out.println(objectMapper.writeValueAsString(user));
		return new ResponseEntity<String>(objectMapper.writeValueAsString(user), headers, HttpStatus.OK);
	}

	@PostMapping("/update")
	public ModelAndView updateUser(@ModelAttribute User user, Principal principal)
	{
		User currentUser = userRepository.findByUsername(principal.getName());
		currentUser.setFunFact(user.getFunFact());
		userRepository.save(currentUser);
		return new ModelAndView("../../index");
	}
}
