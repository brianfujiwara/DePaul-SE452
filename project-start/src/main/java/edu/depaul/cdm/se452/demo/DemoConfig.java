package edu.depaul.cdm.se452.demo;

import edu.depaul.cdm.se452.demo.model.Airport;
import java.time.format.DateTimeFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class DemoConfig {

    @Bean
    public FormattingConversionService conversionService() {
        DefaultFormattingConversionService conversionService
                = new DefaultFormattingConversionService(false);

        DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
        registrar.setDateFormatter(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        registrar.setDateTimeFormatter(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
        registrar.registerFormatters(conversionService);

        // other desired formatters
        return conversionService;
    }
}
