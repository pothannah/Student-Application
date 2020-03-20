package com.interopx.platform.datametrics.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * The Class ApplicationController.
 */
@RestController
public class ApplicationController {


	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationController.class);

	/**
	 * Swagger home page.
	 *
	 * @return the model and view
	 */
	@RequestMapping(value="/actuator/info",method = RequestMethod.GET)
	public ModelAndView swaggerHomePage(){
		LOGGER.info("Entry - swaggerHomePage Method in ApplicationController ");

		LOGGER.info("Exit - swaggerHomePage Method in ApplicationController ");
		return new ModelAndView("redirect:/swagger-ui.html");
	}

	/**
	 * Swagger page.
	 *
	 * @return ModelAndView
	 */
	@RequestMapping(value="",method = RequestMethod.GET)
	public ModelAndView swaggerPage(){
		LOGGER.info("Entry - swaggerPage Method in ApplicationController ");
		LOGGER.info("Exit - swaggerPage Method in ApplicationController ");
		return new ModelAndView("redirect:/swagger-ui.html");
	}
}
