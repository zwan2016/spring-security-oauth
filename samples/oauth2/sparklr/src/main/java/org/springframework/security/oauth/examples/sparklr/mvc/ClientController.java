package org.springframework.security.oauth.examples.sparklr.mvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth.examples.sparklr.domain.Client;
import org.springframework.security.oauth.examples.sparklr.domain.User;
import org.springframework.security.oauth.examples.sparklr.repository.ClientRepository;
import org.springframework.security.oauth.examples.sparklr.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;


/**
 * Created by zwan on 1/13/20.
 */
@Controller
public class ClientController {

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	private ObjectMapper objectMapper;

	@PostMapping("/apply")
	public ModelAndView apply(@ModelAttribute Client client)
	{
		clientRepository.save(client);
		return new ModelAndView("../../index");
	}
}
