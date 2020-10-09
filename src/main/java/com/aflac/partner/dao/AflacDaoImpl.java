package com.aflac.partner.dao;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.aflac.partner.entity.LoginEntity;
import com.aflac.partner.entity.LoginRepository;
import com.aflac.partner.model.LoginModel;

/**
 * @author AshokKumarAvvaru
 *
 */
@Repository
public class AflacDaoImpl implements AflacDao{
	@Autowired
	LoginRepository loginRepository;

	@Override
	public LoginModel loginCheck(LoginModel loginModel) throws IOException {
		LoginEntity loginEntity = loginRepository.findByName(loginModel.getUserName());
		return toLoginModel(loginEntity);
	}

	@Override
	public List<LoginModel> geAllUsers() throws IOException {
		Iterable<LoginEntity> loginEntitys = loginRepository.findAll();
		List<LoginModel> loginModels = new ArrayList<LoginModel>();
		for (LoginEntity loginEntity : loginEntitys) {
			loginModels.add(toLoginModel(loginEntity));
		}
		return loginModels;
	}
	
	LoginModel toLoginModel(LoginEntity loginEntity){
		LoginModel loginModel = new LoginModel();
		loginModel.setUserId(loginEntity.getUserId());
		loginModel.setUserName(loginEntity.getUserName());
		loginModel.setPassword(loginEntity.getPassword());
		return loginModel;
	}

	LoginEntity toLoginEntity(LoginModel loginModel){
		LoginEntity loginEntity = new LoginEntity();
		loginEntity.setUserId(loginModel.getUserId());
		loginEntity.setUserName(loginModel.getUserName());
		loginEntity.setPassword(loginModel.getPassword());
		return loginEntity;
	}

	@Override
	public ResponseEntity<Object> updateUser(LoginModel loginModel, String id) throws IOException {
		Optional<LoginEntity> loginEntity = loginRepository.findById(id);
		if(!loginEntity.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		loginModel.setUserId(id);
		loginRepository.save(toLoginEntity(loginModel));
		return ResponseEntity.noContent().build();
	}
	
}
