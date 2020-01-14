package org.springframework.security.oauth.examples.sparklr.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth.examples.sparklr.PhotoServiceUser;
import org.springframework.security.oauth.examples.sparklr.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by zwan on 1/13/20.
 */
@Controller
public class UserController {

	@GetMapping("/test")
	public ModelAndView register()
	{
		return new ModelAndView("oauth_error");
	}
}
