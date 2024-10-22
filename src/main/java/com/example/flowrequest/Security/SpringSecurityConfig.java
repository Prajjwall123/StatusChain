package com.example.flowrequest.Security;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SpringSecurityConfig {

//    private final JwtAuthenticationFilter jwtAuthFilter;
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(customUserDetailService);
//        authenticationProvider.setPasswordEncoder(PasswordEncoderUtil.getInstance());
//        return authenticationProvider;
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//        return config.getAuthenticationManager();
//    }


    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
//                .csrf().disable() // Disable CSRF protection for development, but enable it in production
                .authorizeHttpRequests(authorize->authorize
                        .requestMatchers("/*/**")
                        .permitAll() // Allow these URLs without authentication
                        .anyRequest()
                        .authenticated())
                        .csrf().disable() // Disable CSRF protection for development, but enable it in production
        ;


        return httpSecurity.build();
    }


}