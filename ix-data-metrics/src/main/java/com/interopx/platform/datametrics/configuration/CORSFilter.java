package com.interopx.platform.datametrics.configuration;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The Class CORSFilter.
 * CORS Filter is a generic solution for fitting Cross-Origin Resource Sharing support to Java web applications. 
 * It is for enabling cross-domain requests from web browsers to servers and web APIs that opt in to handle them.
 */
@Component
public class CORSFilter implements Filter {

	/** The LOGGERGER */
	private static final Logger LOGGER = LoggerFactory.getLogger(CORSFilter.class);

	/**
	 * Instantiates a new CORS filter.
	 */
	public CORSFilter(){
		LOGGER.info("SimpleCORSFilter init");
	}

	/** (non-Javadoc)
	 * Details of the APIs and the request types that can be used with this application
	 * 
	 * @param req
	 * @param res
	 * @param chain
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		LOGGER.info("Entry - doFilter Method in CORSFilter ");

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me, X-AUTH-TOKEN");
		response.setHeader("Exposed-Headers", "X-AUTH-TOKEN,Prefer,Origin, X-Requested-With,"
				+ " Content-Type, Access-Control-Max-Age,"
				+ "Access-Control-Allow-Methods,Access-Control-Allow-Origin");

		chain.doFilter(req, res);
		LOGGER.info("Exit - doFilter Method in CORSFilter ");
	}

	/** 
	 *  initialization filter config
	 *  @param filterConfig 
	 */
	@Override
	public void init(FilterConfig filterConfig) {
		LOGGER.info("Entry - init Method in CORSFilter ");

	}

	/** 
	 * Destroy method
	 */
	@Override
	public void destroy() {
		LOGGER.info("Entry - destroy Method in CORSFilter ");

	}

}
