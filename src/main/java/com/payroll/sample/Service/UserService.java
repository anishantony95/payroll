package com.payroll.sample.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.payroll.sample.Entity.User;
import com.payroll.sample.Repo.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		for (User user : userRepository.findAll()) {
			users.add(user);
		}
		return users;
	}

	public User saveMyUser(User user) {

		userRepository.save(user);
		return user;
	}

	public List<User> deleteUserById(int id) {
		userRepository.deleteById(id);
		return getAllUsers();
	}

	public User findUserByEmailId(String emailId) {
		return userRepository.findByEmail(emailId);
		

	}

	public List<User> updateUser(User user) {
		userRepository.save(user);
		return getAllUsers();
	}
	// --------------------------------------------------------

	public Optional<User> findUserByEmailId(int id) {
		
		return userRepository.findById(id);
		
	}

}
