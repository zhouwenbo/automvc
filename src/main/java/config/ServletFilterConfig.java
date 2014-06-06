package config;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 14-6-4.
 */
public class ServletFilterConfig {


  /*@Override
    public void onStartup(ServletContext servletContext) throws ServletException {
            fff
    }
    */


  @Bean
    public ServletRegistrationBean createServletRegistration(){
        List<String> list = new ArrayList<String>();
        list.add(".htm");
        ServletRegistrationBean bean = new ServletRegistrationBean();
        bean.setUrlMappings(list);
        return bean;
    }



}
