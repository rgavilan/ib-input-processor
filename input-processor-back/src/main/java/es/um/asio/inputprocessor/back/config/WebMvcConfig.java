package es.um.asio.inputprocessor.back.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import es.um.asio.inputprocessor.back.config.properties.CorsProperties;
import es.um.asio.inputprocessor.back.filter.SimpleCORSFilter;
import es.um.asio.inputprocessor.service.ServiceConfig;

/**
 * Web MVC related configuration.
 */
@EnableConfigurationProperties(CorsProperties.class)
@Configuration
@Import(ServiceConfig.class)
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * Configures and registers the CORS filter for the application.
     *
     * @param corsProperties
     *            Cors related configuration properties.
     * @return the filter registration bean
     */
    @Bean
    public FilterRegistrationBean<SimpleCORSFilter> simpleCORSFilterRegistrationBean(
            @Autowired final CorsProperties corsProperties) {
        final FilterRegistrationBean<SimpleCORSFilter> registrationBean = new FilterRegistrationBean<>();
        final SimpleCORSFilter corsFilter = new SimpleCORSFilter(corsProperties.isEnabled(),
                corsProperties.getAllowedOrigin(), corsProperties.getAllowedMethods(),
                corsProperties.getAllowedHeaders(), corsProperties.getMaxAge());
        registrationBean.setFilter(corsFilter);
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return registrationBean;
    }
}
