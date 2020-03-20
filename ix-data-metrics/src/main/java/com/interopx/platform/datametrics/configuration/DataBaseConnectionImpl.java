package com.interopx.platform.datametrics.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * The Class DataBaseConnectionImpl.
 */
@Configuration
public class DataBaseConnectionImpl implements DataBaseConnection {

	/** The environment. */
	@Autowired
	private Environment environment;

	/** The statement. */
	private Statement statement = null;

	/** The prepared statement. */
	private PreparedStatement preparedStatement = null;

	/** The connection. */
	private static Connection connection;

	/** The result set. */
	private ResultSet resultSet = null;

	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Gets the connection object.
	 *
	 * @return the connection object
	 */
	public Connection getConnectionObject() {
		try {
			if (connection == null) {
				Class.forName(environment.getRequiredProperty("jdbc.driverClassName"));
				connection = DriverManager.getConnection(environment.getRequiredProperty("jdbc.url"), getProperties());

				statement = connection.createStatement();
				statement.execute("SET graph_path=" + environment.getRequiredProperty("agens.jdbc.graph.path") + ";");
				// connection.setAutoCommit(false);
			}
		} catch (Exception ex) {
			logger.error("Exception in getConnectionObject of DataBaseConnectionImpl :: ");
			ex.printStackTrace();
		}
		return connection;
	}

	/**
	 * Gets the properties.
	 *
	 * @return the properties
	 */
	private Properties getProperties() {
		Properties properties = new Properties();
		try {
			// properties.setProperty("username",environment.getRequiredProperty("jdbc.username"));
			properties.setProperty("password", environment.getRequiredProperty("jdbc.password"));
			properties.setProperty("graph_path", environment.getRequiredProperty("agens.jdbc.graph.path"));
			properties.setProperty("user", environment.getRequiredProperty("jdbc.username"));
		} catch (Exception ex) {
			logger.error("Exception in getProperties of DataBaseConnectionImpl :: ");
			ex.printStackTrace();
		}
		return properties;
	}

	/**
	 * Creates the statement.
	 *
	 * @return the statement
	 */
	public Statement createStatement() {
		try {
			statement = getConnectionObject().createStatement();
		} catch (Exception ex) {
			// close();
			logger.error("Exception in createStatement of DataBaseConnectionImpl :: ");
			ex.printStackTrace();
		}
		return statement;
	}

	/**
	 * Prepared statement.
	 *
	 * @param query the query
	 * @return the prepared statement
	 */
	public PreparedStatement preparedStatement(String query) {
		try {
			preparedStatement = getConnectionObject().prepareStatement(query);
		} catch (Exception ex) {
			// close();
			logger.error("Exception in preparedStatement of DataBaseConnectionImpl :: ");
			ex.printStackTrace();
		}
		return preparedStatement;
	}

	/**
	 * Gets the result set.
	 *
	 * @param preparedStatement the prepared statement
	 * @return the result set
	 */
	public ResultSet getResultSet(PreparedStatement preparedStatement) {
		try {
			resultSet = preparedStatement.executeQuery();
		} catch (Exception ex) {
			// close();
			logger.error("Exception in getResultSet of DataBaseConnectionImpl :: ");
			ex.printStackTrace();
		}
		return resultSet;
	}

	/**
	 * Gets the result set.
	 *
	 * @param query the query
	 * @return the result set
	 */
	public ResultSet getResultSet(String query) {
		try {
			resultSet = createStatement().executeQuery(query);
		} catch (Exception ex) {
			// close();
			logger.error("Exception in getResultSet  String Query of DataBaseConnectionImpl :: ");
			ex.printStackTrace();
		}
		return resultSet;
	}

	/**
	 * Gets the execute update.
	 *
	 * @param preparedStatement the prepared statement
	 * @return the execute update
	 */
	public int getExecuteUpdate(PreparedStatement preparedStatement) {
		int result = 0;
		try {
			result = preparedStatement.executeUpdate();
		} catch (Exception ex) {
			// close();
			logger.error("Exception in getResultSet of DataBaseConnectionImpl :: ");
			ex.printStackTrace();
		}
		return result;
	}

	/**
	 * Close.
	 */
	public void close() {
		logger.info("Inside close of DataBaseConnectionImpl");
		closeStatement(statement);
		closePreparedStatement(preparedStatement);
		logger.info("Leaving close of  DataBaseConnectionImpl");
	}

	/**
	 * Close statement.
	 *
	 * @param statement the statement
	 */
	public void closeStatement(Statement statement) {
		logger.info("Inside closeStatement of DataBaseConnectionImpl");
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (Exception ex) {
			logger.error("Exception in closeStatement  of DataBaseConnectionImpl :: ");
			ex.printStackTrace();
		}
		//closeResultSet(resultSet);
		// closeConnection(connection);
		logger.info("Leaving closeStatement of  DataBaseConnectionImpl");
	}

	/**
	 * Close prepared statement.
	 *
	 * @param preparedStatement the prepared statement
	 */
	public void closePreparedStatement(PreparedStatement preparedStatement) {
		try {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		} catch (Exception ex) {
			logger.error("Exception in closePreparedStatement  of DataBaseConnectionImpl :: ");
			ex.printStackTrace();
		}
		//closeResultSet(resultSet);
		// closeConnection(connection);
	}

	/**
	 * Close result set.
	 *
	 * @param resultSet the result set
	 */
	public void closeResultSet(ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (Exception ex) {
			logger.error("Exception in closeResultSet  of DataBaseConnectionImpl :: ");
			ex.printStackTrace();
		}
		// closeConnection(connection);
	}

	/**
	 * Close connection.
	 *
	 * @param connection the connection
	 */
//	public void closeConnection(Connection connection) {
//		try {
//			if (connection != null) {
//				connection.close();
//			}
//		} catch (Exception ex) {
//			logger.error("Exception in closeConnection  of DataBaseConnectionImpl :: ");
//			ex.printStackTrace();
//		}
//	}

}
