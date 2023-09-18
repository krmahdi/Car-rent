package com.epam.carrental.model.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.epam.carrental.domain.Car;
import com.epam.carrental.model.config.DbConnection;
import com.epam.carrental.model.dao.genericDao;

public class CarDao implements genericDao<Car> {
	private Connection connection=new DbConnection().getConnection();
	private static final String INSERT_USER ="INSERT INTO user_table(user_name,	user_email,	user_password,user_adress,user_blocked,user_role)"+ "VALUES(?,?,?,?,?,?)";

	@Override
	public int insertItem(Car item) {
		try {
			PreparedStatement preparedStatement= connection.prepareStatement("");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Car> getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car getItemById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateItem(Car item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteItem(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

}

