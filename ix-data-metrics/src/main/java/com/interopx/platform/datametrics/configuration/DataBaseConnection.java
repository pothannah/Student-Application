package com.interopx.platform.datametrics.configuration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * The Interface DataBaseConnection.
 */
public interface DataBaseConnection {

	/**
	 * Gets the connection object.
	 *
	 * @return the connection object
	 */
	//	 DataSource getDataSource();
	Connection getConnectionObject() ;

	/**
	 * Creates the statement.
	 *
	 * @return the statement
	 */
	Statement createStatement();

	/**
	 * Prepared statement.
	 *
	 * @param query the query
	 * @return the prepared statement
	 */
	PreparedStatement preparedStatement(String query);

	/**
	 * Gets the result set.
	 *
	 * @param preparedStatement the prepared statement
	 * @return the result set
	 */
	ResultSet getResultSet(PreparedStatement preparedStatement);

	/**
	 * Gets the result set.
	 *
	 * @param query the query
	 * @return the result set
	 */
	ResultSet getResultSet(String query);

	/**
	 * Gets the execute update.
	 *
	 * @param preparedStatement the prepared statement
	 * @return the execute update
	 */
	int getExecuteUpdate(PreparedStatement preparedStatement);

	/**
	 * Close.
	 */
	void close();

	/**
	 * Close statement.
	 *
	 * @param statement the statement
	 */
	void closeStatement(Statement statement);

	/**
	 * Close prepared statement.
	 *
	 * @param preparedStatement the prepared statement
	 */
	void closePreparedStatement(PreparedStatement preparedStatement);

	/**
	 * Close result set.
	 *
	 * @param resultSet the result set
	 */
	void closeResultSet(ResultSet resultSet);

	/**
	 * Close connection.
	 *
	 * @param connection the connection
	 */
	//void closeConnection(Connection connection);

}
