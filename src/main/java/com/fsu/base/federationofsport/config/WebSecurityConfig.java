package com.fsu.base.federationofsport.config;

import com.fsu.base.federationofsport.model.Role;
import com.fsu.base.federationofsport.model.User;
import com.fsu.base.federationofsport.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import javax.annotation.Resource;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource(name = "userService")
    private UserService userDetailsService;

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {

        userDetailsService.save(createAdminUser());
        userDetailsService.save(createBasicUser());

        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    private User createAdminUser(){
        User user = new User();
        user.setUsername("chocolate.puppies");
        user.setPassword("mylikerpuppies");
        user.setRole(Role.ROLE_ADMIN);
        return user;
    }

    private User createBasicUser(){
        User user = new User();
        user.setUsername("fhtghttuuj");
        user.setPassword("jukjImesiJqsju");
        user.setRole(Role.ROLE_BASIC);
        return user;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http
//                .csrf().disable()
//                .anonymous().disable()
//                .authorizeRequests()
//                .antMatchers(
//                        "/api/v1/trainers/create", "/api/v1/trainers/delete/**",
//                        "/api/v1/advertisement/create", "/api/v1/advertisement/delete/**",
//                        "/api/v1/cheerleaders/create", "/api/v1/cheerleaders/delete/**",
//                        "/api/v1/news/create", "/api/v1/news/delete/**",
//                        "/api/v1/sponsors/create", "/api/v1/sponsors/delete/**",
//                        "/api/v1/videos/create", "/api/v1/videos/delete/**"
//                ).authenticated();
        http
                .cors()
                .and()
                .csrf().disable()
                .anonymous().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/api/**", "/oauth/**").permitAll()
                .and()
                .httpBasic();

    }

    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }

    @Bean
    @Autowired
    public TokenStoreUserApprovalHandler userApprovalHandler(TokenStore tokenStore) {
        TokenStoreUserApprovalHandler handler = new TokenStoreUserApprovalHandler();
        handler.setTokenStore(tokenStore);
        handler.setRequestFactory(new DefaultOAuth2RequestFactory(clientDetailsService));
        handler.setClientDetailsService(clientDetailsService);
        return handler;
    }

    @Bean
    @Autowired
    public ApprovalStore approvalStore(TokenStore tokenStore) {
        TokenApprovalStore store = new TokenApprovalStore();
        store.setTokenStore(tokenStore);
        return store;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
