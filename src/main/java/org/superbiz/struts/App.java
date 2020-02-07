package org.superbiz.struts;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public FilterRegistrationBean siteMeshFilterBean() {
        FilterRegistrationBean bean = new FilterRegistrationBean(new SiteMeshFilter());
        bean.addUrlPatterns("/*");
        bean.setOrder(Ordered.LOWEST_PRECEDENCE);
        return bean;
    }

    @Bean
    public FilterRegistrationBean strutsPrepareAndExecuteFilterBean() {
        FilterRegistrationBean bean = new FilterRegistrationBean(new StrutsPrepareAndExecuteFilter());
        bean.addUrlPatterns("/");
        bean.addUrlPatterns("/addUserForm.action");
        bean.addUrlPatterns("/addUser.action");
        bean.addUrlPatterns("/findUserForm.action");
        bean.addUrlPatterns("/findUser.action");
        bean.addUrlPatterns("/listAllUsers.action");
        return bean;
    }

}
