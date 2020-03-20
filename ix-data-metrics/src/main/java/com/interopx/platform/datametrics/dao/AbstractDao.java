package com.interopx.platform.datametrics.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The Class AbstractDao.
 */
public abstract class AbstractDao {


	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractDao.class);


	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Gets the session.
	 *
	 * @return the session
	 */
	protected Session getSession() {
		LOGGER.info("Entry - getSession Method in AbstractDao ");

		return sessionFactory.getCurrentSession();
	}

	/**
	 * Persist.
	 *
	 * @param entity the entity
	 */
	public void persist(Object entity) {
		LOGGER.info("Entry - persist Method in AbstractDao ");

		getSession().persist(entity);
	}

	/**
	 * Delete.
	 *
	 * @param entity the entity
	 */
	public void delete(Object entity) {
		LOGGER.info("Entry - delete Method in AbstractDao ");

		getSession().delete(entity);
	}
}
