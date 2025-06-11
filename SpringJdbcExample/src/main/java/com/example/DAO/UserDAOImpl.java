package com.example.DAO;


	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.List;
	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
	import org.springframework.jdbc.core.RowMapper;
	import org.springframework.stereotype.Repository;

import com.example.model.User;

	@Repository
	@Primary
	public class UserDAOImpl implements UserDAO {
		
		@Autowired
		private Environment env;

	    @Autowired
	    private JdbcTemplate jdbcTemplate;
	    
	    @Value("${sql.selectUser}")
	    private String insertQuery;
	    
	    @Value("${sql.getUserById}")
	    private String userById;
	    
	    @Value("${sql.insertUser}")
	    private String insertUser;

	    public List<User> getAllUsers() {
	    	//String sql= env.getProperty("sql.selectUser");
	        return jdbcTemplate.query(insertQuery, new BeanPropertyRowMapper<>(User.class)) ;
	    }
	    
	    public User getUserById(int id) {
	    	//String sql = env.getProperty("sql.getUserById");
	    	return jdbcTemplate.queryForObject(userById,new Object[] {id}, new BeanPropertyRowMapper<>(User.class));
	    }
	    
	    public void save(User user) {
	        //String sql = env.getProperty("sql.insertUser");
	        jdbcTemplate.update(insertUser, user.getName(), user.getEmail());
	    }
	}

