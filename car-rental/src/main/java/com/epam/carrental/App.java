package com.epam.carrental;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.epam.carrental.domain.User;
import com.epam.carrental.domain.UserRole;
import com.epam.carrental.model.config.DbConnection;
import com.epam.carrental.model.dao.impl.UserDao;
import com.epam.carrental.util.propertiesReader;

public class App {

	public static void main(final String[] args) throws SQLException {
		Properties properties=propertiesReader.getProperties("src/main/ressource/application.properties");
		System.out.println("file length:" +properties.size());
		System.out.println("jdbcURL:" +properties.getProperty("jdbcUrl"));
		Connection connection=new DbConnection().getConnection();
		System.out.println("connected to which driver:" +connection.getCatalog());
		

		UserDao userDao = new UserDao();

		System.out.println("============================ SELECT ALL ===============================");

		List<User> users = userDao.getAllItems();
	    for(int i=0;i<users.size();i++) {
		    System.out.println(users.get(i));
	    }

		System.out.println("============================ SELECT BY ID ===============================");

		User user = userDao.getItemById(4);
		System.out.println(" Item By Id: " + user);
		System.out.println("============================ DELETE ===============================");

		System.out.println("Deleted Status: " + userDao.deleteItem(10));
		List<User> usersAfterDelete = userDao.getAllItems();
		for(int i=0;i<users.size();i++) {
		    System.out.println(usersAfterDelete.get(i));
	    }

		System.out.println("============================ UPDATE ===============================");
		User userBeforeUpdate = userDao.getItemById(2);
		System.out.println(" userBeforeUpdate: " + userBeforeUpdate);
		User updateUser = new User(2, "userName", " ", "userPassword", "userAddress", false, UserRole.ADMIN);
		//System.out.println("Updated Status: " + userDao.updateItem(updateUser));
		userDao.updateItem(updateUser);
		User userAfterUpdate = userDao.getItemById(2);
		System.out.println(" userAfterUpdate: " + userAfterUpdate);
		System.out.println("============================ INSERT  ===============================");
		//User newuser = new User("userName", "New UserEmail", "userPassword", "userAddress", false, UserRole.ADMIN);
		//System.out.println("Insert Starus: " + userDao.insertItem(newuser));
		//userDao.insertItem(newuser);
		//List<User> userNew = userDao.getAllItems();
		//userNew.forEach(System.out::println);
		User newuser = new User("userName", "New UserEmail", "userPassword", "userAddress", false, UserRole.ADMIN);
		System.out.println("Insert Starus: " + userDao.insertItem(newuser));
		List<User> userNew = userDao.getAllItems();
		//userNew.forEach(System.out::println)
		for(int i=0;i<userNew.size();i++){
		    System.out.println(userNew.get(i));
		} 
		
	}
	
	
	
	


}