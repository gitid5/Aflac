package com.aflac.partner.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aflac.partner.model.LoginModel;
import com.aflac.partner.service.AflacService;

/**
 * @author AshokKumarAvvaru
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/aflac", produces = MediaType.APPLICATION_JSON_VALUE)
public class AflacController {
	@Autowired
	AflacService aflacService;

	@GetMapping("/geAllUsers")
	List<LoginModel> geAllUsers() throws IOException {
		return aflacService.geAllUsers();
	}

	@GetMapping("/geUser/{name}")
	LoginModel geUser(@PathVariable String name) throws IOException {
		LoginModel loginModel = new LoginModel();
		loginModel.setUserName(name);
		return aflacService.loginCheck(loginModel);
	}

	@PutMapping("/updateUser/{name}")
	ResponseEntity<Object> updateUser(@RequestBody LoginModel loginModel, @PathVariable String name) throws IOException {
		return aflacService.updateUser(loginModel,name);
	}

	@PostMapping("/Login")
	LoginModel loginCheck(@RequestBody LoginModel loginModel) throws IOException {
		return aflacService.loginCheck(loginModel);

	}
}
