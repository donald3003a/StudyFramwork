package cn.github.studyframework.listener;

import java.io.InputStream;
import java.net.MalformedURLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

public class ConfigListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {

	}

	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		String path = context.getInitParameter("contextConfig");
	
			String in = context.getRealPath(path);
			try {		
				XMLConfiguration configuration = new XMLConfiguration(path);
			} catch (ConfigurationException e) {
				e.printStackTrace();
			}

	}

}
