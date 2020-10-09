package com.aflac.partner.service;
/**
 * @author AshokKumarAvvaru
 *
 */
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aflac.partner.dao.AflacDao;
import com.aflac.partner.model.LoginModel;
@Service
public class AflacServiceImpl implements AflacService{
	
	@Autowired
	AflacDao aflacDao;

	@Override
	public LoginModel loginCheck(LoginModel loginModel) throws IOException {
		return aflacDao.loginCheck(loginModel);
	}

	@Override
	public List<LoginModel> geAllUsers() throws IOException {
		return aflacDao.geAllUsers();
	}


	@Override
	public ResponseEntity<Object> updateUser(LoginModel loginModel, String name) throws IOException {
		return aflacDao.updateUser(loginModel,name);
	}
	

}
