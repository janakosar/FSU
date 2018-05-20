package com.fsu.base.federationofsport.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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

                .antMatchers(HttpMethod.OPTIONS, "/oauth/**").permitAll()

                .antMatchers(HttpMethod.POST, "/api/users**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/users/me").authenticated()
                .antMatchers(HttpMethod.GET, "/api/users").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/users**").hasRole("ADMIN")

                .antMatchers(HttpMethod.POST, "/api/trainers**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/trainers**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/trainers**").permitAll()

                .antMatchers(HttpMethod.POST, "/api/advertisement**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/advertisement**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/advertisement**").permitAll()


                .antMatchers(HttpMethod.POST, "/api/cheerleaders**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/cheerleaders**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/cheerleaders**").permitAll()

                .antMatchers(HttpMethod.POST, "/api/news**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/news**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/news**").permitAll()


                .antMatchers(HttpMethod.POST, "/api/sponsors**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/sponsors**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/sponsors**").permitAll()

                .antMatchers(HttpMethod.POST, "/api/videos**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/videos**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/videos**").permitAll()

                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler())

                .and().httpBasic();

    }
}