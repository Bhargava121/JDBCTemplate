package com.example.DAO;
import java.util.List;

import com.example.model.User;

public interface UserDAO {
	List<User> getAllUsers();

	User getUserById(int id);

	void save(User user);
	}


