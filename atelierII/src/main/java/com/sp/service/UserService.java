package com.sp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.User;
import com.sp.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRep;
	
	public int addUser(User c) {
		Optional<User> optUser = userRep.findByEmail(c.getEmail());
		if (optUser.isEmpty()) {
			User createdUser = userRep.save(c);
			System.out.println(createdUser);
			return createdUser.getId();
		}
		return 0;
	}
	
	public User getUser(int id) {
		Optional<User> uOpt = userRep.findById(id);
		if (uOpt.isPresent()) {
			return uOpt.get();
		}else {
			return null;
		}
	}

	public boolean login(String email, String passwd) {
		// TODO Auto-generated method stub
		Optional<User> optUser = userRep.findByEmail(email);
		if (optUser != null) {
			if (optUser.get().getPwd() == passwd) {
				return true;
			}
		}
		return false;
	}

}