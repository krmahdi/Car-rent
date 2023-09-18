package com.epam.carrental.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.carrental.domain.Car;
import com.epam.carrental.domain.User;
import com.epam.carrental.domain.UserRole;
import com.epam.carrental.model.config.DbConnection;
import com.epam.carrental.model.dao.genericDao;

public class UserDao implements genericDao<User> {
	private static final Logger LOGGER = LogManager.getLogger();

	private Connection connection = new DbConnection().getConnection();

	private static final String INSERT_USER = "INSERT INTO user_table (user_name, user_email, user_password, user_address, user_blocked, user_role)"
			+ " VALUES(?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_USER = "UPDATE user_table SET user_name=?,	user_email=?,	user_password=?,user_adress=?,user_blocked=?,user_role=? WHERE user_id=?";

	@Override
	public int insertItem(final User item) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
			preparedStatement.setString(1, item.getUserName());
			preparedStatement.setString(2, item.getUserEmail());
			preparedStatement.setString(3, item.getUserPassword());
			preparedStatement.setString(4, item.getUserAdress());
			preparedStatement.setBoolean(5, item.isUserBlocked());
			preparedStatement.setString(6, item.getUserRole().name());

			return preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<User> getAllItems() {
		List<User> users=new ArrayList<>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user_table");
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				 long userId=resultSet.getLong("user_id");
				 String userName=resultSet.getString("user_name");
				 String userEmail=resultSet.getString("user_email");
				 String userAdress=resultSet.getString("user_adress");
				 String userPassword=resultSet.getString("user_password");
				 boolean userBlocked=resultSet.getBoolean("user_Blocked");
				 UserRole userRole=UserRole.valueOf(resultSet.getString("user_role"));
				 User user=new User( userId, userName, userEmail,  userAdress, userPassword,userBlocked,userRole);
				 users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return users;
	}

	@Override
	public User getItemById(final long id) {
		User user =new User();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user_table WHERE user_id=?");
			preparedStatement.setLong(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				 long userId=resultSet.getLong("user_id");
				 String userName=resultSet.getString("user_name");
				 String userEmail=resultSet.getString("user_email");
				 String userAdress=resultSet.getString("user_adress");
				 String userPassword=resultSet.getString("user_password");
				 boolean userBlocked=resultSet.getBoolean("user_Blocked");
				 UserRole userRole=UserRole.valueOf(resultSet.getString("user_role"));
				 user=new User( userId, userName, userEmail,  userAdress, userPassword,userBlocked,userRole);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return user;
	}

	@Override
	public int updateItem(final User item) {

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);
			preparedStatement.setString(1, item.getUserName());
			preparedStatement.setString(2, item.getUserEmail());
			preparedStatement.setString(3, item.getUserPassword());
			preparedStatement.setString(4, item.getUserAdress());
			preparedStatement.setBoolean(5, item.isUserBlocked());
			preparedStatement.setString(6, item.getUserRole().name());
			preparedStatement.setLong(7, item.getUserId());

			return preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int deleteItem(final long id) {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement;
		try {
		     preparedStatement = connection.prepareStatement("DELETE FROM user_table WHERE user_id = ?" );
			preparedStatement.setLong(1, id);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error("error is:"+e);

		}

		return 0;		
	
	}
}
