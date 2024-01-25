package com.security.springSecurityBasic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.config.Customizer;

import javax.sql.DataSource;


@Configuration
public class ProjectSecurityConfig {

//    @Bean
//    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
//        http.authorizeHttpRequests().anyRequest().authenticated();
//        http.formLogin();
//        http.httpBasic();
//        return http.build();
//    }

//    @Bean
//    SecurityFilterChain customSecurityFilterChain(HttpSecurity http) throws Exception{
//        http.authorizeHttpRequests()
//                .requestMatchers("/myAccount", "/myBalance", "/myCards", "/myLoans").authenticated()
//                .requestMatchers("/notices", "/contact").permitAll()
//                .and().formLogin()
//                .and().httpBasic();
//        return http.build();
//    }

    @Bean
    SecurityFilterChain customSecurityFilterChainSpring6(HttpSecurity http) throws Exception{
        http.csrf().disable()
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/myAccount","/myBalance","/myLoans","/myCards").authenticated()
                        .requestMatchers("/notices","/contact", "/register").permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

//    @Bean
//    SecurityFilterChain customSecurityFilterChainDenyAll(HttpSecurity http) throws Exception{
//        http.authorizeHttpRequests()
//                .anyRequest().denyAll()
//                .and().formLogin()
//                .and().httpBasic();
//        return http.build();
//    }

//        @Bean
//    SecurityFilterChain customSecurityFilterChainDenyAllSpring6(HttpSecurity http) throws Exception{
//        http.authorizeHttpRequests((requests) -> requests
//                .anyRequest().denyAll())
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());
//        return http.build();
//    }

//    @Bean
//    SecurityFilterChain customSecurityFilterChainDenyAllPermitAll(HttpSecurity http) throws Exception{
//        http.authorizeHttpRequests()
//                .anyRequest().permitAll()
//                .and().formLogin()
//                .and().httpBasic();
//        return http.build();
//    }

//        @Bean
//    SecurityFilterChain customSecurityFilterChainDenyAllPermitAllSpring6(HttpSecurity http) throws Exception{
//            http.authorizeHttpRequests((requests) -> requests
//                            .anyRequest().permitAll())
//                    .formLogin(Customizer.withDefaults())
//                    .httpBasic(Customizer.withDefaults());
//        return http.build();
//    }
//

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService(){
//        UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("12345").authorities("admin").build();
//        UserDetails user = User.withDefaultPasswordEncoder().username("user").password("12345").authorities("read").build();
//        return new InMemoryUserDetailsManager(admin, user);
//    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsServiceWithoutPasswordEncoder(){
//        UserDetails admin = User.withUsername("admin").password("12345").authorities("admin").build();
//        UserDetails user = User.withUsername("user").password("12345").authorities("read").build();
//        return new InMemoryUserDetailsManager(admin, user);
//    }


//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource){
//        return new JdbcUserDetailsManager(dataSource);
//
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }



}
