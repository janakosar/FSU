package com.fsu.base.federationofsport.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

/**
 * Created by yana on 04.04.18.
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "resource_id";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID).stateless(false);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.
                anonymous().disable()
                .authorizeRequests()
                .antMatchers(
                        "/api/v1/trainers/create", "/api/v1/trainers/delete/**",
                        "/api/v1/advertisement/create", "/api/v1/advertisement/delete/**",
                        "/api/v1/cheerleaders/create", "/api/v1/cheerleaders/delete/**",
                        "/api/v1/news/create", "/api/v1/news/delete/**",
                        "/api/v1/sponsors/create", "/api/v1/sponsors/delete/**",
                        "/api/v1/videos/create", "/api/v1/videos/delete/**"
                        )
                .authenticated();
    }

}
