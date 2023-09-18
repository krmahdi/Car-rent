package com.epam.carrental.model.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.carrental.util.propertiesReader;

public class DbConnection {

	private static final Logger LOGGER = LogManager.getLogger();
	private static final String PROPERTIES_DB_FILE = "src/main/ressource/application.properties";
	private static final String URL = "jdbcUrl";
	private static final String USER = "postgres.username";
	private static final String PASSWORD = "postgres.password";

	private String databaseUrl = "";
	private String databaseUser = "";
	private String databasePassword = "";

	public DbConnection() {
		Properties properties = propertiesReader.getProperties(PROPERTIES_DB_FILE);
		databaseUrl = properties.getProperty(URL);
		databaseUser = properties.getProperty(USER);
		databasePassword = properties.getProperty(PASSWORD);
	}

	public Connection getConnection() {
		try {
			Connection connection = DriverManager.getConnection(databaseUrl, databaseUser, databasePassword);

			LOGGER.info("Successfully connected to Database URL: " + databaseUrl);
			return connection;
		} catch (SQLException e) {
			LOGGER.error("Unable to connect to Database URL: " + databaseUrl + " " + e);
			throw new RuntimeException("Unable to connect to Database URL: " + databaseUrl);
		}
	}

}