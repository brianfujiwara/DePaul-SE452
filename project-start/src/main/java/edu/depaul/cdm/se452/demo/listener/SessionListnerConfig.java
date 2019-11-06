package edu.depaul.cdm.se452.demo.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SessionListnerConfig {

    private static final Logger log = LoggerFactory.getLogger(SessionListnerConfig.class);

    @Bean                           // bean for http session listener
    public HttpSessionListener httpSessionListener() {
        return new HttpSessionListener() {
            @Override
            public void sessionCreated(HttpSessionEvent se) {               // This method will be called when session created
                log.info("Session Created with session id+" + se.getSession().getId());
            }

            @Override
            public void sessionDestroyed(HttpSessionEvent se) {         // This method will be automatically called when session destroyed
                log.info("Session Destroyed, Session id:" + se.getSession().getId());
            }
        };
    }

    @Bean                   // bean for http session attribute listener
    public HttpSessionAttributeListener httpSessionAttributeListener() {
        return new HttpSessionAttributeListener() {
            @Override
            public void attributeAdded(HttpSessionBindingEvent se) {            // This method will be automatically called when session attribute added
                log.info("Attribute Added following information");
                log.info("Attribute Name:" + se.getName());
                log.info("Attribute Value:" + se.getName());
            }

            @Override
            public void attributeRemoved(HttpSessionBindingEvent se) {      // This method will be automatically called when session attribute removed
                log.info("attributeRemoved");
            }

            @Override
            public void attributeReplaced(HttpSessionBindingEvent se) {     // This method will be automatically called when session attribute replace
                log.info("Attribute Replaced following information");
                log.info("Attribute Name:" + se.getName());
                log.info("Attribute Old Value:" + se.getValue());
            }
        };
    }

}
