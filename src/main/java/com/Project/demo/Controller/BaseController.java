package com.Project.demo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class BaseController {
	protected void checkemail(String useremail) {
		if (useremail.isBlank())
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
	}

}
