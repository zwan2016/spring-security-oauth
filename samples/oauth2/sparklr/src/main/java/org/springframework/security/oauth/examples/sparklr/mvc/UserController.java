package org.springframework.security.oauth.examples.sparklr.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth.examples.sparklr.PhotoServiceUser;
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

	@GetMapping("/test")
	public ModelAndView register()
	{
		User user = new User();
		user.setUsername("zwan");
		user.setPassword("Mstr123");
		userRepository.save(user);
		return new ModelAndView("oauth_error");
	}
}
