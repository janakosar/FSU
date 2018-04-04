package com.fsu.base.federationofsport.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

    static final String CLIEN_ID = "fsu-client";
    static final String CLIENT_SECRET = "fsu-secret";
    static final String GRANT_TYPE_PASSWORD = "password";
    static final String AUTHORIZATION_CODE = "authorization_code";
    static final String REFRESH_TOKEN = "refresh_token";
    static final String IMPLICIT = "implicit";
    static final String SCOPE_READ = "read";
    static final String SCOPE_WRITE = "write";
    static final String TRUST = "trust";
    static final int ACCESS_TOKEN_VALIDITY_SECONDS = 1*60*60;
    static final int FREFRESH_TOKEN_VALIDITY_SECONDS = 6*60*60;

//	@Autowired
//	@Qualifier("userDetailsService")
//	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

    @Autowired
    private TokenStore tokenStore;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer configurer) throws Exception {
        configurer.tokenStore(tokenStore)
                .authenticationManager(authenticationManager);

//        configurer.authenticationManager(authenticationManager);
//		configurer.userDetailsService(userDetailsService);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//		clients.inMemory().withClient("gigy")
//				.secret("secret").accessTokenValiditySeconds(expiration)
//				.scopes("read", "write").authorizedGrantTypes("password", "refresh_token").resourceIds("resource");

        clients
                .inMemory()
                .withClient(CLIEN_ID)
                .secret(CLIENT_SECRET)
                .authorizedGrantTypes(GRANT_TYPE_PASSWORD, AUTHORIZATION_CODE, REFRESH_TOKEN, IMPLICIT )
                .scopes(SCOPE_READ, SCOPE_WRITE, TRUST)
                .accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS).
                refreshTokenValiditySeconds(FREFRESH_TOKEN_VALIDITY_SECONDS);
    }



}

/**

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.security.authentication.AuthenticationManager;
 import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
 import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
 import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
 import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
 import org.springframework.security.oauth2.provider.token.TokenStore;

 @Configuration
 @EnableAuthorizationServer
 public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

 static final String CLIEN_ID = "devglan-client";
 static final String CLIENT_SECRET = "devglan-secret";
 static final String GRANT_TYPE_PASSWORD = "password";
 static final String AUTHORIZATION_CODE = "authorization_code";
 static final String REFRESH_TOKEN = "refresh_token";
 static final String IMPLICIT = "implicit";
 static final String SCOPE_READ = "read";
 static final String SCOPE_WRITE = "write";
 static final String TRUST = "trust";
 static final int ACCESS_TOKEN_VALIDITY_SECONDS = 1*60*60;
 static final int FREFRESH_TOKEN_VALIDITY_SECONDS = 6*60*60;

 @Autowired
 private TokenStore tokenStore;

 @Autowired
 private AuthenticationManager authenticationManager;

 @Override
 public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {

 configurer
 .inMemory()
 .withClient(CLIEN_ID)
 .secret(CLIENT_SECRET)
 .authorizedGrantTypes(GRANT_TYPE_PASSWORD, AUTHORIZATION_CODE, REFRESH_TOKEN, IMPLICIT )
 .scopes(SCOPE_READ, SCOPE_WRITE, TRUST)
 .accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS).
 refreshTokenValiditySeconds(FREFRESH_TOKEN_VALIDITY_SECONDS);
 }

 @Override
 public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
 endpoints.tokenStore(tokenStore)
 .authenticationManager(authenticationManager);
 }
 }
 */