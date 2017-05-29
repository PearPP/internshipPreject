package com.oceantest.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class OceanTestInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
 
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;//new Class[] { OceanTestServiceConfig.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;//new Class[] { OceanTestWebConfig.class };
    }
  
    @Override
    protected String[] getServletMappings() {
        return null;//new String[] { "/" };
    }
    
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
    	// root context
        AnnotationConfigWebApplicationContext rootContext =
                new AnnotationConfigWebApplicationContext();
        rootContext.register(OceanTestServicesConfig.class); // configuration class for root context
//        rootContext.scan("...service", "...dao"); // scan only some packages
        servletContext.addListener(new ContextLoaderListener(rootContext));
    	
    	// dispatcher servlet 1
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.setParent(rootContext);
        webContext.register(OceanTestWebConfig.class); 
//        webContext.scan("...web1");            // scan some other packages
        ServletRegistration.Dynamic dispatcher1 = servletContext.addServlet("dispatcherWeb", new DispatcherServlet(webContext));
        dispatcher1.setLoadOnStartup(1);
        dispatcher1.addMapping("/web/*");

      
     // dispatcher servlet 1
        AnnotationConfigWebApplicationContext restContext = new AnnotationConfigWebApplicationContext();
        restContext.setParent(rootContext);					//pp--start at root context
        restContext.register(OceanTestRestConfig.class); 	//pp--set class to register --> OceanTestRestConfig
//        webContext.scan("...web1");            // scan some other packages
        ServletRegistration.Dynamic dispatcherRest = servletContext.addServlet("dispatcherRest", new DispatcherServlet(restContext));
        dispatcherRest.setLoadOnStartup(1);
        dispatcherRest.addMapping("/rest/*");				//pp--set path-- oceantest/rest/... -- /rest/ is prefix path
        
     // dispatcher servlet 1
        AnnotationConfigWebApplicationContext wsContext = new AnnotationConfigWebApplicationContext();
        wsContext.setParent(rootContext);
        wsContext.register(OceanTestWSConfig.class); 
//        webContext.scan("...web1");            // scan some other packages
        ServletRegistration.Dynamic dispatcherWS = servletContext.addServlet("dispatcherWS", new DispatcherServlet(wsContext));
        dispatcherWS.setLoadOnStartup(1);
        dispatcherWS.addMapping("/ws/*");
        
        ///////////////////////////////////////////////
//        //สำหรับการ map url
//        AnnotationConfigWebApplicationContext policyWebContext = new AnnotationConfigWebApplicationContext();
//        policyWebContext.setParent(rootContext);
//        policyWebContext.register(OceanPolicyWebConfig.class); 
//        ServletRegistration.Dynamic policyDispatcher = servletContext.addServlet("dispatcherPolicyWeb", new DispatcherServlet(policyWebContext));
//        policyDispatcher.setLoadOnStartup(1);
//        policyDispatcher.addMapping("/policyweb/*");
        
    }
 
}