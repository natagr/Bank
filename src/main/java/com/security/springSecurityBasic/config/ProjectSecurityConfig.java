package com.security.springSecurityBasic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.config.Customizer;

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
        http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/myAccount","/myBalance","/myLoans","/myCards").authenticated()
                        .requestMatchers("/notices","/contact").permitAll())
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

}
