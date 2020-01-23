package org.springframework.security.oauth.examples.sparklr.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth.examples.sparklr.domain.User;
import org.springframework.security.oauth.examples.sparklr.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by zwan on 1/13/20.
 */
@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/register")
	public ModelAndView register(@ModelAttribute User user)
	{
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return new ModelAndView("oauth_error");
	}
}
