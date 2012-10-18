package cn.github.studyframework.filter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import cn.github.studyframework.domain.Beans;

public class ConfigFilter implements Filter{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException,
			ServletException {
		// TODO Auto-generated method stub
		
	}

	public void init(FilterConfig config) throws ServletException {
		String path =config.getInitParameter("configPath");
		ServletContext context = config.getServletContext();
		String realPath=context.getRealPath(path);
		JAXBContext jc;
		try {
			InputStream is = new FileInputStream(realPath);  
			jc = JAXBContext.newInstance(Beans.class);
		    Unmarshaller u = jc.createUnmarshaller();  
		    Beans beans = (Beans)u.unmarshal(is);
		    System.out.println(beans.getBeanList().get(0).getId());
		} catch (Exception e) {
			e.printStackTrace();
		}  

 
	}

}
