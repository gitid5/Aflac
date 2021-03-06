package com.aflac.partner.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.aflac.partner.model.LoginModel;

/**
 * @author AshokKumarAvvaru
 *
 */
public interface AflacService {

	LoginModel loginCheck(LoginModel loginModel) throws IOException;

	List<LoginModel> geAllUsers() throws IOException;

	ResponseEntity<Object> updateUser(LoginModel loginModel, String name) throws IOException;
	
	

}
